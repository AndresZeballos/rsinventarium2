/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precios.findAll", query = "SELECT p FROM Precios p"),
    @NamedQuery(name = "Precios.findByCodigo", query = "SELECT p FROM Precios p WHERE p.preciosPK.codigo = :codigo"),
    @NamedQuery(name = "Precios.findByTalle", query = "SELECT p FROM Precios p WHERE p.preciosPK.talle = :talle"),
    @NamedQuery(name = "Precios.findByPrecio", query = "SELECT p FROM Precios p WHERE p.precio = :precio")})
public class Precios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PreciosPK preciosPK;
    @Basic(optional = false)
    @Column(name = "precio")
    private String precio;
    @JoinColumn(name = "talle", referencedColumnName = "talle", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Talles talles;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descripciones descripciones;

    public Precios() {
    }

    public Precios(PreciosPK preciosPK) {
        this.preciosPK = preciosPK;
    }

    public Precios(PreciosPK preciosPK, String precio) {
        this.preciosPK = preciosPK;
        this.precio = precio;
    }

    public Precios(String codigo, String talle) {
        this.preciosPK = new PreciosPK(codigo, talle);
    }

    public PreciosPK getPreciosPK() {
        return preciosPK;
    }

    public void setPreciosPK(PreciosPK preciosPK) {
        this.preciosPK = preciosPK;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Talles getTalles() {
        return talles;
    }

    public void setTalles(Talles talles) {
        this.talles = talles;
    }

    public Descripciones getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(Descripciones descripciones) {
        this.descripciones = descripciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preciosPK != null ? preciosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precios)) {
            return false;
        }
        Precios other = (Precios) object;
        if ((this.preciosPK == null && other.preciosPK != null) || (this.preciosPK != null && !this.preciosPK.equals(other.preciosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Precios[ preciosPK=" + preciosPK + " ]";
    }
    
}
