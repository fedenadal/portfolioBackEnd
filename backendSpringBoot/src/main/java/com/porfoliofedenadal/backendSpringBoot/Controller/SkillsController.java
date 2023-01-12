package com.porfoliofedenadal.backendSpringBoot.Controller;

import com.porfoliofedenadal.backendSpringBoot.Dto.dtoSkills;
import com.porfoliofedenadal.backendSpringBoot.Model.Skills;
import com.porfoliofedenadal.backendSpringBoot.Security.Controller.Mensaje;
import com.porfoliofedenadal.backendSpringBoot.Service.SkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins = "https://portfoliofedenadal.web.app")

public class SkillsController {
    @Autowired
    SkillsService skillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
@PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills) {
        if (StringUtils.isBlank(dtoskills.getNombreS())) {
            return new ResponseEntity(new Mensaje("por favor ingrese el nombre"), HttpStatus.BAD_REQUEST);
        }
        if (skillsService.existsByNombreS(dtoskills.getNombreS())) {
            return new ResponseEntity(new Mensaje("esa habilidad ya fue registrada"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoskills.getNombreS(), dtoskills.getNivelS(), dtoskills.getAreaS());
        skillsService.save(skills);

        return new ResponseEntity(new Mensaje("Habilidad agregada"), HttpStatus.OK);
    }
@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (skillsService.existsByNombreS(dtoskills.getNombreS()) && skillsService.getByNombreS(dtoskills.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Habilidad ya registrada"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoskills.getNombreS())) {
            return new ResponseEntity(new Mensaje("por favor ingrese el nombre"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = skillsService.getOne(id).get();
        skills.setNombreS(dtoskills.getNombreS());
        skills.setNivelS(dtoskills.getNivelS());
        skills.setAreaS (dtoskills.getAreaS());

        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
@PreAuthorize ("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad Eliminada"), HttpStatus.OK);
    }

    
}
