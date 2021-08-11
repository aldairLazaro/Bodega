/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author haitr
 */
public class IngresoProducto {
    private int id_ingreso;
    private int codigo;
    private String descripcion;
    private int cantidad;
    private String cento_costo;
    private String fecha_entrada;

    public IngresoProducto() {
    }

    public IngresoProducto(int id_ingreso, int codigo, String descripcion, int cantidad, String cento_costo, String fecha_entrada) {
        this.id_ingreso = id_ingreso;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.cento_costo = cento_costo;
        this.fecha_entrada = fecha_entrada;
    }

    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCento_costo() {
        return cento_costo;
    }

    public void setCento_costo(String cento_costo) {
        this.cento_costo = cento_costo;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    
    
}
