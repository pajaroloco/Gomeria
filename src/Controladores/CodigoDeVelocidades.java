/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.CodigoDeVelocidad;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Victor
 */
public class CodigoDeVelocidades {

    public List<CodigoDeVelocidad> ListCodigoDeVelocidad() {
        List<CodigoDeVelocidad> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from CodigoDeVelocidad", CodigoDeVelocidad.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;

    }

    public void actualizar(CodigoDeVelocidad c) {

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            CodigoDeVelocidad aux = Conexion.getInstance().getEntity().find(CodigoDeVelocidad.class, c.getSimbVelocidad());
            Conexion.getInstance().getEntity().merge(c);
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();

        }
    }

}
