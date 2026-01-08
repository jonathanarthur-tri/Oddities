package com.trilogi.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseService {
    private static DatabaseService instance;
    private final EntityManagerFactory emf;

    private DatabaseService() {
        this.emf = Persistence.createEntityManagerFactory("OdditiesPU");
    }

    public static synchronized DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }


    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
