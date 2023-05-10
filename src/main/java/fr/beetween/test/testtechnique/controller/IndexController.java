package fr.beetween.test.testtechnique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.beetween.test.testtechnique.model.Formation;
import fr.beetween.test.testtechnique.service.FormationService;

@Controller
public class IndexController {

    @Autowired
    FormationService formationService;

    @GetMapping("/")
    private String index(Model model) {
        List<Formation> formations = formationService.getFormations();
        model.addAttribute("formations", formations);
        return "formations";
    }

    @GetMapping("/refresh-formations")
    public String refreshFormations(Model model) {
        formationService.updateAllFormations();
        List<Formation> updatedFormations = formationService.getFormations();
        model.addAttribute("formations", updatedFormations);
        return "formations::formations-table";
    }

}
