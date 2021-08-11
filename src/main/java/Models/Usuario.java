/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author wilal
 */
public class Usuario {
    private int id_usuario;
    private String rut;
    private String nombre;
    private String apellido;
    private String pass;
    private String las_time; 
    private int tipo_usuario;
    private String tipo_descripcion;

    public Usuario() {
    }

    public Usuario(int id_usuario, String rut, String nombre, String apellido, String pass, String las_time, int tipo_usuario, String tipo_descripcion) {
        this.id_usuario = id_usuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
        this.las_time = las_time;
        this.tipo_usuario = tipo_usuario;
        this.tipo_descripcion = tipo_descripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLas_time() {
        return las_time;
    }

    public void setLas_time(String las_time) {
        this.las_time = las_time;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getTipo_descripcion() {
        return tipo_descripcion;
    }

    public void setTipo_descripcion(String tipo_descripcion) {
        this.tipo_descripcion = tipo_descripcion;
    }
    
    
   
}
