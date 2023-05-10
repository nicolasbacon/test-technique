package fr.beetween.test.testtechnique.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormationsResponse {
    
    @JsonProperty("results")
    private List<Formation> formations;

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }
}
