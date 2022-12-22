
package com.porfoliofedenadal.backendSpringBoot.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    private String descripcionE;
    private String areaE;
    
    //CONSTRUCTOR
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String areaE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.areaE = areaE;
    }

    
    
   //GETTERS Y SETTERS

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getAreaE() {
        return areaE;
    }

    public void setAreaE(String areaE) {
        this.areaE = areaE;
    }

    
}
