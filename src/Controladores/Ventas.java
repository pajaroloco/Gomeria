/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.DetalleDeVenta;
import IO.Venta;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Ventas {
    
    public List<Venta> ListVenta() {
        List<Venta> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from Venta", Venta.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;

    }

    public List<DetalleDeVenta> ListDetalleDeVenta() {
        List<DetalleDeVenta> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from DetalleDeVenta", DetalleDeVenta.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;

    }

}
