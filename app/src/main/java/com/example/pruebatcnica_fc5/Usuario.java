package com.example.pruebatcnica_fc5;

import java.io.Serializable;

public class Usuario implements Serializable
{
    String correo, contraseña;

    public Usuario()
    {

    }

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
