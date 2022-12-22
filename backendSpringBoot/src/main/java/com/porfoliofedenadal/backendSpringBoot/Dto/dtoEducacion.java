
package com.porfoliofedenadal.backendSpringBoot.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    private String descripcionEd;
    private String areaEd;
    
    
    //CONTRUCTOR

        public dtoEducacion() {
    }
        
    public dtoEducacion(String nombreEd, String descripcionEd, String areaEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.areaEd = areaEd;
    }

    //GETTERS Y SETTERS

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

    public String getAreaEd() {
        return areaEd;
    }

    public void setAreaEd(String areaEd) {
        this.areaEd = areaEd;
    }
    

}
