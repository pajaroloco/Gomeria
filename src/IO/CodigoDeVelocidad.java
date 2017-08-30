/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Victor
 */
@Entity
public class CodigoDeVelocidad implements Serializable {

    @OneToMany(mappedBy = "codigoDeVelocidades")
    private List<Producto> productos;

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    
    private String simbVelocidad;
    
    private String velocidadKmH;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getSimbVelocidad() {
        return simbVelocidad;
    }

    public void setSimbVelocidad(String simbVelocidad) {
        this.simbVelocidad = simbVelocidad;
    }

    public String getVelocidadKmH() {
        return velocidadKmH;
    }

    public void setVelocidadKmH(String velocidadKmH) {
        this.velocidadKmH = velocidadKmH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (simbVelocidad != null ? simbVelocidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoDeVelocidad)) {
            return false;
        }
        CodigoDeVelocidad other = (CodigoDeVelocidad) object;
        if ((this.simbVelocidad == null && other.simbVelocidad != null) || (this.simbVelocidad != null && !this.simbVelocidad.equals(other.simbVelocidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return simbVelocidad;
    }
    
}
