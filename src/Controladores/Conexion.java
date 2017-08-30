/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor
 */
public class Conexion {

    public Conexion() {
    }

    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }

    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();

        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GomeriaPU");

        private static final EntityManager em = emf.createEntityManager();

        private static final CodigoDeVelocidades cdv = new CodigoDeVelocidades();

        private static final Compras com = new Compras();

        private static final IndiceDeCargas idc = new IndiceDeCargas();

        private static final Productos pro = new Productos();

        private static final Proveedores prove = new Proveedores();

        private static final Ventas vent = new Ventas();
        
        private static final Usuarios usuario = new Usuarios();
        
        private static final Empleados empleado = new Empleados();

    }

    public byte[] convertirImagen(String path) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedImage img = ImageIO.read(new File(path));
        ImageIO.write(img, "png", baos);
        baos.flush();

        String base64String = Base64.encode(baos.toByteArray());
        baos.close();

        return Base64.decode(base64String);
    }

    public EntityManager getEntity() {

        return ConexionHolder.em;

    }

    public Compras getCompras() {

        return ConexionHolder.com;

    }

    public CodigoDeVelocidades getCodigoDeVelocidades() {

        return ConexionHolder.cdv;

    }

    public IndiceDeCargas getIndiceDeCargas() {

        return ConexionHolder.idc;

    }

    public Productos getProductos() {

        return ConexionHolder.pro;

    }

    public Proveedores getProveedores() {

        return ConexionHolder.prove;

    }

    public Ventas getVentas() {

        return ConexionHolder.vent;

    }
    
    public Usuarios getUsuarios(){
        
        return ConexionHolder.usuario;
        
    }
    
    public Empleados getEmpleados(){
        
        return ConexionHolder.empleado;
        
    }

    public void guardar(Object object) {

        getEntity().getTransaction().begin();

        try {

            getEntity().persist(object);

            getEntity().getTransaction().commit();

        } catch (Exception e) {

            getEntity().getTransaction().rollback();

        }

    }
    public void actualizar(Object object) {

        getEntity().getTransaction().begin();

        try {

            getEntity().merge(object);

            getEntity().getTransaction().commit();

        } catch (Exception e) {

            getEntity().getTransaction().rollback();

        }
        
    }
    
    public void cerrarEntity() {
        
        ConexionHolder.em.close();
        
    }

}
