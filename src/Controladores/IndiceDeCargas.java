/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.CodigoDeVelocidad;
import IO.IndiceDeCarga;
import java.util.List;

/**
 *
 * @author Victor
 */
public class IndiceDeCargas {

    public List<IndiceDeCarga> ListIndiceDeCarga() {
        List<IndiceDeCarga> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from IndiceDeCarga", IndiceDeCarga.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;

    }

    public void actualizar(IndiceDeCarga i) {

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            IndiceDeCarga aux = Conexion.getInstance().getEntity().find(IndiceDeCarga.class, i.getindiceCarga());
            Conexion.getInstance().getEntity().merge(i);
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();

        }
    }
}
