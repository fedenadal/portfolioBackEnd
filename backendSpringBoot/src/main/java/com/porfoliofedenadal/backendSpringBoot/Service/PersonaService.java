
//logica de negocio
package com.porfoliofedenadal.backendSpringBoot.Service;


import com.porfoliofedenadal.backendSpringBoot.Model.Persona;
import com.porfoliofedenadal.backendSpringBoot.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
      persoRepo.save(per);
    }

    @Override
    public void borrarPersona(long id) {
    persoRepo.deleteById(id);
    }

    @Override
    public  Persona buscarPersona(long id) {
    return persoRepo.findById(id).orElse(null);
    }
    
    

    @Override
    public void editarPersona(Persona per) {
  persoRepo.save(per);
    }
    
}
