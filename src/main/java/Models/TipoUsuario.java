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
public class TipoUsuario {
    private int id_tipo_usuario;
    private String descripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(int id_tipo_usuario, String descripcion) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.descripcion = descripcion;
    }

    /**
     * @return the id_tipo_usuario
     */
    public int getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    /**
     * @param id_tipo_usuario the id_tipo_usuario to set
     */
    public void setId_tipo_usuario(int id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
