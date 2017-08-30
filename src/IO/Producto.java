/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.awt.Image;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    private String nombreProducto;
    
    private String medida;
    
    private String marca;
    
    private String modelo;
    
    private String precio;
    
//    private String foto;
    
    private boolean activo;
    
    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private IndiceDeCarga indiceDeCargas;
    
    @ManyToOne
    private CodigoDeVelocidad codigoDeVelocidades;
    
    @ManyToOne
    private DetalleDeCompra detalleDeCompras;
    
    @ManyToOne
    private DetalleDeVenta detalleDeVentas;
    
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

//Transforma el array de bytes en la foto
    public ImageIcon getFotoImage() {
        Image aux = new ImageIcon(foto).getImage();
        //El valor 150, depende del tamaño del visor a utilizar
        ImageIcon perfil = new ImageIcon(aux.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        return perfil;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

//    public List<Proveedor> getProveedors() {
//        return proveedors;
//    }
//
//    public void setProveedors(List<Proveedor> proveedors) {
//        this.proveedors = proveedors;
//    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

//    public String getFoto() {
//        return foto;
//    }
//
//    public void setFoto(String foto) {
//        this.foto = foto;
//    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public IndiceDeCarga getIndiceDeCargas() {
        return indiceDeCargas;
    }

    public void setIndiceDeCargas(IndiceDeCarga indiceDeCargas) {
        this.indiceDeCargas = indiceDeCargas;
    }

    public CodigoDeVelocidad getCodigoDeVelocidades() {
        return codigoDeVelocidades;
    }

    public void setCodigoDeVelocidades(CodigoDeVelocidad codigoDeVelocidades) {
        this.codigoDeVelocidades = codigoDeVelocidades;
    }

    public DetalleDeCompra getDetalleDeCompras() {
        return detalleDeCompras;
    }

    public void setDetalleDeCompras(DetalleDeCompra detalleDeCompras) {
        this.detalleDeCompras = detalleDeCompras;
    }

    public DetalleDeVenta getDetalleDeVentas() {
        return detalleDeVentas;
    }

    public void setDetalleDeVentas(DetalleDeVenta detalleDeVentas) {
        this.detalleDeVentas = detalleDeVentas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IO.Producto[ id=" + id + " ]";
    }

    public void setProveedors(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
