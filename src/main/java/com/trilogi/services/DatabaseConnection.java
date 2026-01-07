package com.trilogi.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseConnection {

    private static DatabaseConnection instance;

    private final EntityManagerFactory emf;
    private final EntityManager em;

    private DatabaseConnection() {
        this.emf = Persistence.createEntityManagerFactory("OdditiesPU");
        this.em = emf.createEntityManager();
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void close() {
        if (em.isOpen()) em.close();
        if (emf.isOpen()) emf.close();
    }
}