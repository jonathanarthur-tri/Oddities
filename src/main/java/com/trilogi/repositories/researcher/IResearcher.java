package com.trilogi.repositories.researcher;

import com.trilogi.entities.Researcher;

import java.util.Collection;

public interface IResearcher {
    void registerResearcher(Researcher researcher);
    void updateResearcherInfo(Researcher researcher);
    boolean deactivateResearcher(long researcherId);
    Collection<Researcher> getResearchers();
}
