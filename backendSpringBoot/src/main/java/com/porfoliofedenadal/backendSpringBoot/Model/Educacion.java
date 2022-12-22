
package com.porfoliofedenadal.backendSpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String descripcionEd;
    private String areaEd;
    
    //CONSTRUCTOR
 public Educacion() {
    }
    
 public Educacion(String nombreEd, String descripcionEd, String areaEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.areaEd = areaEd;
    }

 
 
    
    //GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
