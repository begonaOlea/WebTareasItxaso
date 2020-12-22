package com.demo.servicios;

import com.demo.excepciones.DBException;
import com.demo.producto.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DB {
    private static Map<Integer, Tareas> tarea;
    private static Set<Usuario> usuarios;
    
    static {
        tarea = new HashMap<Integer, Tareas>();
        tarea.put(1, new Tareas(1, "Leer libro", Estados.INPROGRESS, 1));
        tarea.put(2, new Tareas(2, "Hacer ejercicio matematicas", Estados.TODO, 1));
        tarea.put(3, new Tareas(3, "Ver pelicula", Estados.DONE, 2));
        tarea.put(4, new Tareas(4, "Hacer resumen de pelicula", Estados.INPROGRESS, 2));
        tarea.put(4, new Tareas(5, "Hacer presentacion", Estados.DONE, 3));
        tarea.put(4, new Tareas(5, "Ensayar presentacion", Estados.INPROGRESS, 3));
        
        usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario(1, "pepe.martinez", "Pepe", "Martinez", "pepe123"));
        usuarios.add(new Usuario(2, "laura.sanchez", "Laura", "Sanchez", "laura123"));
        usuarios.add(new Usuario(3, "maria.alonso", "Maria", "Alonso", "maria123"));
    }
    
    private DB() {}
    
    public static synchronized Collection<Tareas> getAllTareas(){
         return tarea.values();
    }
    
    public static synchronized Collection<Usuario> getUsuarios(){
         return usuarios;
    }
    
    
}
