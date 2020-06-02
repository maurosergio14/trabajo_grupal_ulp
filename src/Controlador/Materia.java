/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Sergio
 */
public class Materia {

private int id_mater=-1;
private String nombre;

    public Materia(int id, String nombre) {
        this.id_mater = id;
        this.nombre = nombre;
    }
  public Materia( String nombre) {
        
        this.nombre = nombre;
    }public Materia(){}

    public int getId() {
        return id_mater;
    }

    public void setId(int id_mater) {
        this.id_mater = id_mater;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@Override
    public String toString(){
    
        return id_mater+"-"+nombre;
    }


}
