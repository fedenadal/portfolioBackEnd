
package com.porfoliofedenadal.backendSpringBoot.Security.Entity;

import com.porfoliofedenadal.backendSpringBoot.Security.Enums.RolNombre;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Rol {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    //CONSTRUCTOR

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }


//GETTERS Y SETTERS    

    public int getId() {
        return id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
     
    
    
}
