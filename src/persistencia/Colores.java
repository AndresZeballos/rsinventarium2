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
@Table(name = "colores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colores.findAll", query = "SELECT c FROM Colores c"),
    @NamedQuery(name = "Colores.findByColor", query = "SELECT c FROM Colores c WHERE c.color = :color")})
public class Colores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Color")
    private String color;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colores", fetch = FetchType.LAZY)
    private List<Articulos> articulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "color", fetch = FetchType.LAZY)
    private List<LineaFactura> lineaFacturaList;

    public Colores() {
    }

    public Colores(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @XmlTransient
    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    @XmlTransient
    public List<LineaFactura> getLineaFacturaList() {
        return lineaFacturaList;
    }

    public void setLineaFacturaList(List<LineaFactura> lineaFacturaList) {
        this.lineaFacturaList = lineaFacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (color != null ? color.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colores)) {
            return false;
        }
        Colores other = (Colores) object;
        if ((this.color == null && other.color != null) || (this.color != null && !this.color.equals(other.color))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Colores[ color=" + color + " ]";
    }
    
}
