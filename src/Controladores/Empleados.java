/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Empleado;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Empleados {
    
  public List<Empleado> ListEmpleado() {
        List<Empleado> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from Empleado", Empleados.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;

    }

    public void actualizar(Empleado em) {

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            Empleado aux = Conexion.getInstance().getEntity().find(Empleado.class, em.getNombre());
            Conexion.getInstance().getEntity().merge(em);
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();

        }
    }
}
