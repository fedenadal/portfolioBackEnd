package com.porfoliofedenadal.backendSpringBoot.Repository;

import com.porfoliofedenadal.backendSpringBoot.Model.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {

    public Optional<Skills> findByNombreS(String nombreS);

    public boolean existsByNombreS(String nombreS);

}
