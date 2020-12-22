package com.demo.producto;

public class Tareas {

    // ATRIBUTOS
    private int IDTarea;
    private String descripcion;
    private Estados estado;
    private int IDUsuario;

    // CONSTRUCTOR
    public Tareas(int IDTarea, String descripcion, Estados estado, int IDUsuario) {
        this.IDTarea = IDTarea;
        this.descripcion = descripcion;
        this.estado = estado;
        this.IDUsuario = IDUsuario;
    }

    // GETTERS Y SETTERS
    public int getIDTarea() {
        return IDTarea;
    }

    public void setIDTarea(int IDTarea) {
        this.IDTarea = IDTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Tareas{" + "IDTarea=" + IDTarea + ", descripcion=" + descripcion + ", estado=" + estado + ", IDUsuario=" + IDUsuario + '}';
    }
    
    // HASHCODE Y EQUALS
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.IDTarea;
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
        final Tareas other = (Tareas) obj;
        if (this.IDTarea != other.IDTarea) {
            return false;
        }
        return true;
    }
    
    

}
