package io.archilab.prox.userprofileservice.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;

    @GetMapping("/showProfessors")
    public String findProfessors(Model model)
    {
        List<Professor> professors = (List<Professor>) professorService.findAll();

        model.addAttribute("professors", professors);

        return "showProfessors";
    }
}
