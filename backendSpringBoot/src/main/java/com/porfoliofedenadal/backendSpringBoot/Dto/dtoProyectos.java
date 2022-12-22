/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfoliofedenadal.backendSpringBoot.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Fd
 */
public class dtoProyectos {
   
    @NotBlank
    private String nombreP;
    private String URLimagen1;
    private String URLimagen2;
    private String URLimagen3;
    private String descripcion1P;
    private String descripcion2P;
    private String descripcion3P;
    private String URLlinkP;


//CONTRUCTOR

    public dtoProyectos() {
    }
    
    public dtoProyectos(String nombreP, String URLimagen1, String URLimagen2, String URLimagen3, String descripcion1P, String descripcion2P, String descripcion3P, String URLlinkP) {
        this.nombreP = nombreP;
        this.URLimagen1 = URLimagen1;
        this.URLimagen2 = URLimagen2;
        this.URLimagen3 = URLimagen3;
        this.descripcion1P = descripcion1P;
        this.descripcion2P = descripcion2P;
        this.descripcion3P = descripcion3P;
        this.URLlinkP = URLlinkP;
    }

//GETTERS Y SETTERS

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getURLimagen1() {
        return URLimagen1;
    }

    public void setURLimagen1(String URLimagen1) {
        this.URLimagen1 = URLimagen1;
    }

    public String getURLimagen2() {
        return URLimagen2;
    }

    public void setURLimagen2(String URLimagen2) {
        this.URLimagen2 = URLimagen2;
    }

    public String getURLimagen3() {
        return URLimagen3;
    }

    public void setURLimagen3(String URLimagen3) {
        this.URLimagen3 = URLimagen3;
    }

    public String getDescripcion1P() {
        return descripcion1P;
    }

    public void setDescripcion1P(String descripcion1P) {
        this.descripcion1P = descripcion1P;
    }

    public String getDescripcion2P() {
        return descripcion2P;
    }

    public void setDescripcion2P(String descripcion2P) {
        this.descripcion2P = descripcion2P;
    }

    public String getDescripcion3P() {
        return descripcion3P;
    }

    public void setDescripcion3P(String descripcion3P) {
        this.descripcion3P = descripcion3P;
    }

    public String getURLlinkP() {
        return URLlinkP;
    }

    public void setURLlinkP(String URLlinkP) {
        this.URLlinkP = URLlinkP;
    }
    
    
    
}