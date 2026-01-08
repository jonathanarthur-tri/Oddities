package com.trilogi.app;

import com.trilogi.repositories.researcher.*;
import com.trilogi.services.*;
import jakarta.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ServiceContainer {
    private final Map<Class<?>, Supplier<?>> services = new HashMap<>();
    private final DatabaseService dbService;
    private EntityManager currentEntityManager;

    public ServiceContainer() {
        this.dbService = DatabaseService.getInstance();
        registerServices();
    }

    private void registerServices() {
        // Register EntityManager factory (creates new one per request)
        services.put(EntityManager.class, () -> {
            if (currentEntityManager == null || !currentEntityManager.isOpen()) {
                currentEntityManager = dbService.createEntityManager();
            }
            return currentEntityManager;
        });

        // Register Repositories
        services.put(IResearcher.class, () ->
                new ResearcherRepository(getService(EntityManager.class))
        );

        // Register Services
        services.put(ResearcherService.class, () ->
                new ResearcherService(getService(IResearcher.class))
        );

        // Add more registrations as needed...
    }

    @SuppressWarnings("unchecked")
    public <T> T getService(Class<T> serviceClass) {
        Supplier<?> supplier = services.get(serviceClass);
        if (supplier == null) {
            throw new IllegalArgumentException("Service not registered: " + serviceClass.getName());
        }
        return (T) supplier.get();
    }

    public void closeEntityManager() {
        if (currentEntityManager != null && currentEntityManager.isOpen()) {
            currentEntityManager.close();
            currentEntityManager = null;
        }
    }

    public void shutdown() {
        closeEntityManager();
        dbService.close();
    }
}