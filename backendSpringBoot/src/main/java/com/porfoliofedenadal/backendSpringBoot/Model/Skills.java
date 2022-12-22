
package com.porfoliofedenadal.backendSpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreS;
    private String nivelS;
    private String areaS;
    
    //CONTRUCTOR

     public Skills() {
    }
     
    public Skills(String nombreS, String nivelS, String areaS) {
        this.nombreS = nombreS;
        this.nivelS = nivelS;
        this.areaS = areaS;
    }
    
    
    //GETERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
