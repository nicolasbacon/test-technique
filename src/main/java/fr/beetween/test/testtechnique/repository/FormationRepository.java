package fr.beetween.test.testtechnique.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.beetween.test.testtechnique.model.Formation;

public interface FormationRepository extends CrudRepository<Formation, Integer> {

    @Override
    List<Formation> findAll();

}
