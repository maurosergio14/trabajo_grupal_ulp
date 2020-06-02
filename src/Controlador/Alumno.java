 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.time.LocalDate;

/**
 *
 * 
 */
public class Alumno {
    private int id_alumno = -1;
    private String nombre;
    private LocalDate fecNac;
    private boolean activo;

    public Alumno(int id_alumno, String nombre, LocalDate fecNac, boolean activo) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public Alumno(String nombre, LocalDate fecNac, boolean activo) {
        this.id_alumno = -1;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.activo=activo;
    }
    
    public Alumno(){ }
    
    public int getId() {
        return id_alumno;
    }

    public void setId(int id) {
        this.id_alumno = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    public String toString(){
        
        
        return id_alumno+"-"+nombre;
    
        
    }
    
}
