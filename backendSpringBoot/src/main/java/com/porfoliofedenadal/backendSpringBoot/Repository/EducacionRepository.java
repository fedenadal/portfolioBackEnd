
package com.porfoliofedenadal.backendSpringBoot.Repository;

import com.porfoliofedenadal.backendSpringBoot.Model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findByNombreEd(String nombreEd);

    public boolean existsByNombreEd(String nombreEd);
}
