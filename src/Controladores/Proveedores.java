/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.CodigoDeVelocidad;
import IO.Proveedor;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Proveedores {

    public List<Proveedor> ListProveedor() {
        List<Proveedor> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from Proveedor", Proveedor.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;
    }

    public void actualizar(Proveedor c) {

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            Proveedor aux = Conexion.getInstance().getEntity().find(Proveedor.class, c.getRut());
            Conexion.getInstance().getEntity().merge(c);
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
    }
}
