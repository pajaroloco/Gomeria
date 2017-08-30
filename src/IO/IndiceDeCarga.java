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
public class IndiceDeCarga implements Serializable {

    @OneToMany(mappedBy = "indiceDeCargas")
    private List<Producto> productos;

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    private String indiceCarga;
    
    private String kg;
    
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

    public String getindiceCarga() {
        return indiceCarga;
    }

    public void setindiceCarga(String indiceCarga) {
        this.indiceCarga = indiceCarga;
    }

    public String getkg() {
        return kg;
    }

    public void setkg(String kg) {
        this.kg = kg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indiceCarga != null ? indiceCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndiceDeCarga)) {
            return false;
        }
        IndiceDeCarga other = (IndiceDeCarga) object;
        if ((this.indiceCarga == null && other.indiceCarga != null) || (this.indiceCarga != null && !this.indiceCarga.equals(other.indiceCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return indiceCarga;
    }
    
}
