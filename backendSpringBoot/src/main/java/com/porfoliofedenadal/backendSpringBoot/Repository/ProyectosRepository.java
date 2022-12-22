/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfoliofedenadal.backendSpringBoot.Repository;

import com.porfoliofedenadal.backendSpringBoot.Model.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

   
@Repository
public interface ProyectosRepository extends JpaRepository <Proyectos,Integer> {
    public Optional <Proyectos> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
        
}
