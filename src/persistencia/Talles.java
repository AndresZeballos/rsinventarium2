/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "talles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talles.findAll", query = "SELECT t FROM Talles t"),
    @NamedQuery(name = "Talles.findByTalle", query = "SELECT t FROM Talles t WHERE t.talle = :talle")})
public class Talles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "talle")
    private String talle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talles", fetch = FetchType.LAZY)
    private List<Articulos> articulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talles", fetch = FetchType.LAZY)
    private List<Costos> costosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talle", fetch = FetchType.LAZY)
    private List<LineaFactura> lineaFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talles", fetch = FetchType.LAZY)
    private List<Precios> preciosList;

    public Talles() {
    }

    public Talles(String talle) {
        this.talle = talle;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    @XmlTransient
    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    @XmlTransient
    public List<Costos> getCostosList() {
        return costosList;
    }

    public void setCostosList(List<Costos> costosList) {
        this.costosList = costosList;
    }

    @XmlTransient
    public List<LineaFactura> getLineaFacturaList() {
        return lineaFacturaList;
    }

    public void setLineaFacturaList(List<LineaFactura> lineaFacturaList) {
        this.lineaFacturaList = lineaFacturaList;
    }

    @XmlTransient
    public List<Precios> getPreciosList() {
        return preciosList;
    }

    public void setPreciosList(List<Precios> preciosList) {
        this.preciosList = preciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talle != null ? talle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talles)) {
            return false;
        }
        Talles other = (Talles) object;
        if ((this.talle == null && other.talle != null) || (this.talle != null && !this.talle.equals(other.talle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Talles[ talle=" + talle + " ]";
    }
    
}
