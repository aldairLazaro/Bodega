/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Models.TipoUsuario;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wilal
 */
public class DaoBuscarTrabajador extends Conexion {

    public Usuario BuscarUsuario(String rut, String pass) {
        Usuario usuario = new Usuario();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM usuario WHERE rut = ? and password = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, pass);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setId_usuario((rs.getInt("id_usuario")));
                usuario.setRut(rs.getString("rut"));
                usuario.setRut(rs.getString("nombre"));
                usuario.setRut(rs.getString("apellido"));
                
                int idT = Integer.parseInt(rs.getString("id_tipo_usuario"));
                TipoUsuario tpUsuario =  BuscarTipoUsuario(idT);
                usuario.setTipo_usuario(tpUsuario);
                return usuario;
                
            }
            return null;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public TipoUsuario BuscarTipoUsuario(int id_tipo_usuario){
        TipoUsuario tpUsuario = new TipoUsuario();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM tipo_usuario WHERE id_tipo_usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_tipo_usuario);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tpUsuario.setId_tipo_usuario(Integer.parseInt(rs.getString("id_tipo_usuario")));
                tpUsuario.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return tpUsuario;
    }

}
