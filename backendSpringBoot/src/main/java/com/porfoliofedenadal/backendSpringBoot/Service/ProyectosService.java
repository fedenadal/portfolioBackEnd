package com.porfoliofedenadal.backendSpringBoot.Service;

import com.porfoliofedenadal.backendSpringBoot.Model.Proyectos;
import com.porfoliofedenadal.backendSpringBoot.Repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {
    @Autowired
    ProyectosRepository proyectosRepository;
    
 public List<Proyectos> list() {
        return proyectosRepository.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return proyectosRepository.findById(id);
    }

    public Optional<Proyectos> getByNombreP(String nombreP) {
        return proyectosRepository.findByNombreP(nombreP);
    }

    public void save(Proyectos proyecto) {
        proyectosRepository.save(proyecto);
    }

    public void delete(int id) {
        proyectosRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return proyectosRepository.existsById(id);
    }

    public boolean existsByNombreP(String nombreP) {
        return proyectosRepository.existsByNombreP(nombreP);
    }
}

