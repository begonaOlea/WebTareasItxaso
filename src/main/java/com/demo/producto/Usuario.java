package com.demo.producto;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{
    // ATRIBUTOS
    private int id;
    private String apodo;
    private String nombre;
    private String apellido;
    private String contraseña;

    // CONSTRUCTOR
    public Usuario(int id, String usuario, String nombre, String apellido, String contraseña) {
        this.id = id;
        this.apodo = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }
    
    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String usuario) {
        this.apodo = usuario;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + apodo + ", nombre=" + nombre + ", apellido=" + apellido + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    // EQUALS AND HASHCODE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.apodo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.apodo, other.apodo)) {
            return false;
        }
        return true;
    }
}
