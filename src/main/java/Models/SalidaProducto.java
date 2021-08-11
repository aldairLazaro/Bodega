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
public class SalidaProducto {
    private int id_salida;
    private int codigo;
    private String descripcion;
    private int cantidad;
    private String cento_costo;
    private String fecha_salida;

    public SalidaProducto() {
    }

    public SalidaProducto(int id_salida, int codigo, String descripcion, int cantidad, String cento_costo, String fecha_salida) {
        this.id_salida = id_salida;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.cento_costo = cento_costo;
        this.fecha_salida = fecha_salida;
    }

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
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

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
    
}
