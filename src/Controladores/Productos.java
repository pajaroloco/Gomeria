/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Producto;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Productos {
   
    public List<Producto> ListProducto() {
        List<Producto> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from Producto", Producto.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;
    }

    public void actualizar(Producto p) {

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            Producto aux = Conexion.getInstance().getEntity().find(Producto.class, p.getId());
            Conexion.getInstance().getEntity().merge(p);
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
    }
//    public List<Producto> ListProductoPorProveedor(int id) {
//        List<Producto> resultado = null;
//
//        Conexion.getInstance().getEntity().getTransaction().begin();
//        try {
//            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from Producto inner join proveedor p on p.id=producto.idProveedor where p.id="+id, Producto.class).getResultList();
//            Conexion.getInstance().getEntity().getTransaction().commit();
//        } catch (Exception e) {
//            Conexion.getInstance().getEntity().getTransaction().rollback();
//        }
//        return resultado;
//
//    }
    
}
