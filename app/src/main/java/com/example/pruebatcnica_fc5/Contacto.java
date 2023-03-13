package com.example.pruebatcnica_fc5;

public class Contacto
{
    private String nombre, apellido, celular, parentesco, numero;

    public Contacto()
    {

    }

    public Contacto(String nombre, String apellido, String celular, String parentesco, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.parentesco = parentesco;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
