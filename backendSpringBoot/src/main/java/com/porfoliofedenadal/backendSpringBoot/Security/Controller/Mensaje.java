
package com.porfoliofedenadal.backendSpringBoot.Security.Controller;


public class Mensaje {
    private String mensaje;
    //CONTRUCTOR

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //GETTERS Y SETTERS

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
