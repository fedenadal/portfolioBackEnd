
package com.porfoliofedenadal.backendSpringBoot.Repository;


import com.porfoliofedenadal.backendSpringBoot.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
