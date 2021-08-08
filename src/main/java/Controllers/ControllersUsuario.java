/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoBuscarTrabajador;
import Models.Usuario;

/**
 *
 * @author wilal
 */
public class ControllersUsuario {
    
    public Usuario InicioSesion(String rut, String pass){
        DaoBuscarTrabajador dao = new DaoBuscarTrabajador();
        Usuario user = dao.BuscarUsuario(rut, pass);
        
        if (user==null) {
            return null;
        }else{
            return user;
        }
    }
}
