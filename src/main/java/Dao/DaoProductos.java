/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Models.IngresoProducto;
import Models.Productos;
import Models.SalidaProducto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haitr
 */
public class DaoProductos extends Conexion{
    
    public boolean RegistrarProductoBase(Productos pro){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO productos (codigo, descripcion, cantidad) VALUES"
                + "(?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public List<Productos>ListarProductosBase(){
        List<Productos>ListarProductosBase = new ArrayList<>();
        
        PreparedStatement ps =null;
        Connection con = getConexion();
        ResultSet rs = null;
        
        String sql = "SELECT id_productos, codigo, descripcion, cantidad FROM productos";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Productos pro = new Productos();
                pro.setId_producto(rs.getInt("id_productos"));
                pro.setCodigo(rs.getInt("codigo"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCantidad(rs.getInt("cantidad"));
                
                ListarProductosBase.add(pro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ListarProductosBase;
    }
    
    public boolean IngresoProductos(IngresoProducto ingreso){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO ingreso (codigo, descripcion, cantidad, centro_costo) VALUES"
                + "(?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, ingreso.getCodigo());
            ps.setString(2, ingreso.getDescripcion());
            ps.setInt(3, ingreso.getCantidad());
            ps.setString(4, ingreso.getCento_costo());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public boolean BuscarIngreso(IngresoProducto ingreso){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "Select descripcion from ingreso where codigo = ?";
        
        try {
            ps = con.prepareCall(sql);          
            ps.setInt(1, ingreso.getCodigo());
            rs = ps.executeQuery();
            if (rs.next()) {
                ingreso.setDescripcion(rs.getString("descripcion"));
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean SalidaProducto(SalidaProducto salida){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO salida (codigo, descripcion, cantidad, centro_costo) VALUES"
                + "(?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, salida.getCodigo());
            ps.setString(2, salida.getDescripcion());
            ps.setInt(3, salida.getCantidad());
            ps.setString(4, salida.getCento_costo());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
