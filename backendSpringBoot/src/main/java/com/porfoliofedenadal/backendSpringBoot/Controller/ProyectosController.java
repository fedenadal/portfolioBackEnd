package com.porfoliofedenadal.backendSpringBoot.Controller;

import com.porfoliofedenadal.backendSpringBoot.Dto.dtoExperiencia;
import com.porfoliofedenadal.backendSpringBoot.Dto.dtoProyectos;
import com.porfoliofedenadal.backendSpringBoot.Model.Experiencia;
import com.porfoliofedenadal.backendSpringBoot.Model.Proyectos;
import com.porfoliofedenadal.backendSpringBoot.Security.Controller.Mensaje;
import com.porfoliofedenadal.backendSpringBoot.Service.ProyectosService;
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
@RequestMapping("proyect")
@CrossOrigin(origins = "https://portfoliofedenadal.web.app")
public class ProyectosController {

    @Autowired
    ProyectosService proyectosService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyecto) {
        if (StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("por favor ingrese el nombre"), HttpStatus.BAD_REQUEST);
        }
        if (proyectosService.existsByNombreP(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("ese Proyecto ya fue registrada"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyecto = new Proyectos(dtoproyecto.getNombreP(), dtoproyecto.getURLimagen1(),
                dtoproyecto.getDescripcion1P(),
                dtoproyecto.getURLimagen2(),
                dtoproyecto.getDescripcion2P(),
                dtoproyecto.getURLimagen3(),
                dtoproyecto.getDescripcion3P(),
                dtoproyecto.getURLlinkP());
        proyectosService.save(proyecto);

        return new ResponseEntity(new Mensaje("proyecto agregado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyectos dtoproyecto) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        if (proyectosService.existsByNombreP(dtoproyecto.getNombreP()) && proyectosService.getByNombreP(dtoproyecto.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Proyecto ya registrado"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("por favor ingrese el nombre"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyecto = proyectosService.getOne(id).get();
        proyecto.setNombreP(dtoproyecto.getNombreP());
        proyecto.setURLimagen1(dtoproyecto.getURLimagen1());
        proyecto.setDescripcion1P(dtoproyecto.getDescripcion1P());
        proyecto.setURLimagen2(dtoproyecto.getURLimagen2());
        proyecto.setDescripcion2P(dtoproyecto.getDescripcion2P());
        proyecto.setURLimagen3(dtoproyecto.getURLimagen3());
        proyecto.setDescripcion3P(dtoproyecto.getDescripcion3P());
        proyecto.setURLlinkP(dtoproyecto.getURLlinkP());

        proyectosService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

}
