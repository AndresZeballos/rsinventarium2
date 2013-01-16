/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
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
@Table(name = "articulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulos.findAll", query = "SELECT a FROM Articulos a"),
    @NamedQuery(name = "Articulos.findByCodigo", query = "SELECT a FROM Articulos a WHERE a.articulosPK.codigo = :codigo"),
    @NamedQuery(name = "Articulos.findByTalle", query = "SELECT a FROM Articulos a WHERE a.articulosPK.talle = :talle"),
    @NamedQuery(name = "Articulos.findByColor", query = "SELECT a FROM Articulos a WHERE a.articulosPK.color = :color"),
    @NamedQuery(name = "Articulos.findByLocal", query = "SELECT a FROM Articulos a WHERE a.articulosPK.local = :local"),
    @NamedQuery(name = "Articulos.findByStock", query = "SELECT a FROM Articulos a WHERE a.stock = :stock")})
public class Articulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticulosPK articulosPK;
    @Column(name = "stock")
    private Integer stock;
    @JoinColumn(name = "talle", referencedColumnName = "talle", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Talles talles;
    @JoinColumn(name = "local", referencedColumnName = "local", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Locales locales;
    @JoinColumn(name = "color", referencedColumnName = "Color", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colores colores;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descripciones descripciones;

    public Articulos() {
    }

    public Articulos(ArticulosPK articulosPK) {
        this.articulosPK = articulosPK;
    }

    public Articulos(String codigo, String talle, String color, String local) {
        this.articulosPK = new ArticulosPK(codigo, talle, color, local);
    }

    public ArticulosPK getArticulosPK() {
        return articulosPK;
    }

    public void setArticulosPK(ArticulosPK articulosPK) {
        this.articulosPK = articulosPK;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Talles getTalles() {
        return talles;
    }

    public void setTalles(Talles talles) {
        this.talles = talles;
    }

    public Locales getLocales() {
        return locales;
    }

    public void setLocales(Locales locales) {
        this.locales = locales;
    }

    public Colores getColores() {
        return colores;
    }

    public void setColores(Colores colores) {
        this.colores = colores;
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
        hash += (articulosPK != null ? articulosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        if ((this.articulosPK == null && other.articulosPK != null) || (this.articulosPK != null && !this.articulosPK.equals(other.articulosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Articulos[ articulosPK=" + articulosPK + " ]";
    }
    
}
