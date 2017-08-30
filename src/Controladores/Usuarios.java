/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import IO.Usuario;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Usuarios {
    
    public List<Usuario> ListUsuario() {
        List<Usuario> resultado = null;

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            resultado = Conexion.getInstance().getEntity().createNativeQuery("select * from Usuario", Usuarios.class).getResultList();
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();
        }
        return resultado;

    }

    public void actualizar(Usuario u) {

        Conexion.getInstance().getEntity().getTransaction().begin();
        try {
            Usuario aux = Conexion.getInstance().getEntity().find(Usuario.class, u.getUsuario());
            Conexion.getInstance().getEntity().merge(u);
            Conexion.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Conexion.getInstance().getEntity().getTransaction().rollback();

        }
    }
}
