
package com.porfoliofedenadal.backendSpringBoot.Service;

import com.porfoliofedenadal.backendSpringBoot.Model.Educacion;
import com.porfoliofedenadal.backendSpringBoot.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository educacionRepository;

    public List<Educacion> list() {
        return educacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return educacionRepository.findById(id);
    }

    public Optional<Educacion> getByNombreEd(String nombreEd) {
        return educacionRepository.findByNombreEd(nombreEd);
    }

    public void save(Educacion edu) {
        educacionRepository.save(edu);
    }

    public void delete(int id) {
        educacionRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return educacionRepository.existsById(id);
    }

    public boolean existsByNombreEd(String nombreEd) {
        return educacionRepository.existsByNombreEd(nombreEd);
    }
    
}
