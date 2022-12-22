
package com.porfoliofedenadal.backendSpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String areaE;
    
    //CONSTRUCTOR

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String areaE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.areaE = areaE;
    }

 
    
    //GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
