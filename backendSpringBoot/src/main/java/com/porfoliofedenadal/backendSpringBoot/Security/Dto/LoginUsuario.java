
package com.porfoliofedenadal.backendSpringBoot.Security.Dto;

import com.sun.istack.NotNull;


public class LoginUsuario {
    
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String password;
    
    
    //GETTERS Y SETTERS

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
