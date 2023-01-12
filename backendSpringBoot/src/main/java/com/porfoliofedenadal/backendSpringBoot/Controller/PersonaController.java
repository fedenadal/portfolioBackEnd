package com.porfoliofedenadal.backendSpringBoot.Controller;


import com.porfoliofedenadal.backendSpringBoot.Dto.dtoPersona;
import com.porfoliofedenadal.backendSpringBoot.Model.Persona;
import com.porfoliofedenadal.backendSpringBoot.Security.Controller.Mensaje;

import com.porfoliofedenadal.backendSpringBoot.Service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/personas")
@CrossOrigin(origins = "https://portfoliofedenadal.web.app")
@RestController
public class PersonaController {
 
    @Autowired
    PersonaService personaService;

    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
            }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if (!personaService.existsById(id)){
            return new ResponseEntity (new Mensaje ("No existe el id"), HttpStatus.BAD_REQUEST);
           }
        
      Persona persona = personaService.getOne(id).get();
      return new ResponseEntity(persona,HttpStatus.OK);
        
    }

    @PreAuthorize ("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona) {
        if (StringUtils.isBlank (dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("por favor ingrese el nombre"), HttpStatus.BAD_REQUEST);
        } else {
        }
        if (personaService.existsByNombre(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("esa persona ya fue registrada"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtopersona.getNombre(),dtopersona.getApellido(),dtopersona.getUbicacion(),dtopersona.getTitulo(),dtopersona.getSubtitulo(), dtopersona.getDescripcion(),dtopersona.getImg() );
        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
@PreAuthorize ("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Persona ya registrada"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("por favor ingrese el nombre"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setUbicacion(dtopersona.getUbicacion());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setSubtitulo(dtopersona.getSubtitulo());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
                
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
@PreAuthorize ("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    }

}

