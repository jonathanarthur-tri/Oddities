package com.trilogi.services;


import com.trilogi.entities.Researcher;
import com.trilogi.repositories.researcher.IResearcher;
import java.util.Collection;

public class ResearcherService {
    private final IResearcher repository;

    // Constructor Injection
    public ResearcherService(IResearcher repository) {
        this.repository = repository;
    }

    public void registerNewResearcher(Researcher researcher) {
        // Add business logic here (validation, etc.)

        repository.registerResearcher(researcher);
    }

    public void updateResearcher(Researcher researcher) {
        repository.updateResearcherInfo(researcher);
    }

    public boolean deactivateResearcher(long id) {
        return repository.deactivateResearcher(id);
    }

    public Collection<Researcher> getAllResearchers() {
        return repository.getResearchers();
    }
}
