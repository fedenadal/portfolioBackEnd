
package com.porfoliofedenadal.backendSpringBoot.Service;

import com.porfoliofedenadal.backendSpringBoot.Model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List <Persona>  verPersonas();
            
    public void crearPersona (Persona per);
    
    public void borrarPersona (long id);
    
    public Persona buscarPersona (long id);

    public void editarPersona(Persona per);
    
}
