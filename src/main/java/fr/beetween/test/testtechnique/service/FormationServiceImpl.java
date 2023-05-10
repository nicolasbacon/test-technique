package fr.beetween.test.testtechnique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.beetween.test.testtechnique.model.Formation;
import fr.beetween.test.testtechnique.model.FormationsResponse;
import fr.beetween.test.testtechnique.repository.FormationRepository;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    FormationRepository formationRepository;

    @Override
    public List<Formation> getFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(int formationId) {
        return formationRepository.findById(formationId).get();
    }

    @Override
    public Formation insert(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public void updateFormation(Formation formation) {
        formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(int formationId) {
        formationRepository.deleteById(formationId);
    }

    @Override
    public void updateAllFormations() {
        String uri = "https://labonnealternance.apprentissage.beta.gouv.fr/api/V1/formations?romeDomain=D11&latitude=48.117266&longitude=-1.6777926&radius=50&caller=contact%40domaine%20nom_de_societe";
        RestTemplate restTemplate = new RestTemplate();
        FormationsResponse response = restTemplate.getForObject(uri, FormationsResponse.class);
        if (response != null) {
            List<Formation> formations = response.getFormations();
            formationRepository.deleteAll();
            formationRepository.saveAll(formations);    
        }

    }

}
