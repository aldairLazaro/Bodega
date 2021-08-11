/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author haitr
 */
public class DaoUsuario extends Conexion {
    
    public boolean RegistrarUsuario(Usuario user) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO usuario (nombre, apellido, rut, password, id_tipo_usuario)"
                + "VALUES (?,?,?,?,? )"; 
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellido());
            ps.setString(3, user.getRut());
            ps.setString(4, user.getPass());
            ps.setInt(5, user.getTipo_usuario());
            ps.execute();            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public int ExisteUsuario(String rut) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT count(id) FROM usuario Where rut = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }
    
    public boolean Login(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT u.id, u.rut, u.password, u.nombre, u.id_tipo_usuario, t.descripcion FROM usuario AS u "
                + "INNER JOIN tipo_usuario AS t ON u.id_tipo_usuario=t.id_tipo_usuario WHERE rut = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getRut());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                if (user.getPass().equals(rs.getString(3))) {
                    
//                    String sqlUpdate = "UPDATE usuario SET last_time = ? WHERE id = ?";
//                    
//                    ps = con.prepareStatement(sqlUpdate);
//                    ps.setString(1, user.getLas_time());
//                    ps.setInt(2, rs.getInt(1));
//                    ps.execute();
                    
                    
                    user.setId_usuario(rs.getInt(1));
                    user.setRut(rs.getString(2));
                    user.setNombre(rs.getString(4));
                    user.setTipo_usuario(rs.getInt(5));
                    user.setTipo_descripcion(rs.getString(6));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
