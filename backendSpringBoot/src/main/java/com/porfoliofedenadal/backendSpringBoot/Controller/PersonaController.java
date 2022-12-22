package com.porfoliofedenadal.backendSpringBoot.Controller;

import com.porfoliofedenadal.backendSpringBoot.Model.Persona;
import com.porfoliofedenadal.backendSpringBoot.Service.IPersonaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    
    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona per) {
        persoServ.crearPersona(per);
    }

    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable long id) {
        persoServ.borrarPersona(id);

    }
    
     @PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/edit/persona")
    public void editarPersona(@RequestBody Persona per) {
        persoServ.editarPersona(per);
    }

}
