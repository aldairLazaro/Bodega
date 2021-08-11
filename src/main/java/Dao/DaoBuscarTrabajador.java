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

    public Boolean Login(String rut, String pass) {
        Usuario usuario = new Usuario();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT u.id, u.nombre, u.apellido, u.rut, u.password, u.id_tipo_usuario, t.descripcion "
                + "FROM usuario AS u INNER JOIN tipo_usuario AS t ON u.id_tipo_usuario=t.id_tipo_usuario WHERE   usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getRut());
            ps.setString(2, usuario.getPass());

            rs = ps.executeQuery();

            if (rs.next()) {
                if (usuario.getPass().equals(rs.getString(5))) {
                    usuario.setId_usuario((rs.getInt("id")));
                    usuario.setRut(rs.getString("rut"));
                    usuario.setRut(rs.getString("nombre"));
                    usuario.setRut(rs.getString("apellido"));
                    usuario.setTipo_usuario((rs.getInt("id_tipo")));
                    return true;
                } else {
                    return false;
                }
            }
            return false;

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

    public TipoUsuario BuscarTipoUsuario(int id_tipo_usuario) {
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
