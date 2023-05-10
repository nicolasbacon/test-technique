package fr.beetween.test.testtechnique.service;

import java.util.List;

import fr.beetween.test.testtechnique.model.Formation;

public interface FormationService {
    
    List<Formation> getFormations();

    Formation getFormationById(int formationId);

    Formation insert(Formation formation);

    void updateFormation(Formation formation);

    void deleteFormation(int formationId);

    void updateAllFormations();
}
