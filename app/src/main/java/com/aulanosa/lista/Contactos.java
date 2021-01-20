package com.aulanosa.lista;

public class Contactos {

    String nombre;
    String apellidos;
    String telefono;
    String email;
    String direccion;
    String observaciones;

    public Contactos(String nombre, String apellidos, String telefono,
                     String email, String direccion, String observaciones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
