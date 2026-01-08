package com.trilogi.repositories.researcher;

import com.trilogi.entities.Researcher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.Collection;
import java.util.List;

public class ResearcherRepository implements IResearcher {
    private final EntityManager em;

    // Constructor Injection - receives dependencies
    public ResearcherRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void registerResearcher(Researcher researcher) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(researcher);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Failed to register researcher", e);
        }
    }

    @Override
    public void updateResearcherInfo(Researcher researcher) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(researcher);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Failed to update researcher", e);
        }
    }

    @Override
    public boolean deactivateResearcher(long researcherId) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Researcher researcher = em.find(Researcher.class, researcherId);
            if (researcher != null) {
                researcher.setActive(false); // Assuming you have this field
                em.merge(researcher);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw new RuntimeException("Failed to deactivate researcher", e);
        }
    }

    @Override
    public Collection<Researcher> getResearchers() {
        return em.createQuery("SELECT r FROM Researcher r", Researcher.class)
                .getResultList();
    }
}