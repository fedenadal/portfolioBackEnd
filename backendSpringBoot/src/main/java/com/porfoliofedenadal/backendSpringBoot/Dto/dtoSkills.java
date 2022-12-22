
package com.porfoliofedenadal.backendSpringBoot.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
    @NotBlank
    private String nombreS;
    private String nivelS;
    private String areaS;

    public dtoSkills() {
    }
    
    
    //CONTRUCTOR

    public dtoSkills(String nombreS, String nivelS, String areaS) {
        this.nombreS = nombreS;
        this.nivelS = nivelS;
        this.areaS = areaS;
    }

    //GETTERS Y SETTERS
    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getNivelS() {
        return nivelS;
    }

    public void setNivelS(String nivelS) {
        this.nivelS = nivelS;
    }

    public String getAreaS() {
        return areaS;
    }

    public void setAreaS(String areaS) {
        this.areaS = areaS;
    }
            
}
