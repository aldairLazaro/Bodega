/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.DaoProductos;
import Models.IngresoProducto;
import Models.Productos;
import Models.SalidaProducto;
import java.util.List;

/**
 *
 * @author haitr
 */
public class ControllersProducto {
    
    public boolean AgregarProductosBase(Productos pro){
        DaoProductos dao = new DaoProductos();
        return dao.RegistrarProductoBase(pro);
    }
    
    public boolean UpdateProductosbase(Productos pro){
        DaoProductos dao = new DaoProductos();
        return dao.UpdateProductosBase(pro);
    }
    
    public List<Productos> ListarProductosBase(){
        DaoProductos dao = new DaoProductos();
        return dao.ListarProductosBase();
    }
    
    public  boolean IngresarProductos(IngresoProducto ingreso){
        DaoProductos dao = new DaoProductos();
        return dao.IngresoProductos(ingreso);
    }
    
    public boolean BuscarCodigoIngreso(IngresoProducto ingreso){
        DaoProductos dao = new DaoProductos();
        return dao.BuscarIngreso(ingreso);
    }
    
    public boolean SalidaProducto(SalidaProducto salida){
        DaoProductos dao = new DaoProductos();
        return dao.SalidaProducto(salida);
    }
}
