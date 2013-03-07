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
@Table(name = "costos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costos.findAll", query = "SELECT c FROM Costos c"),
    @NamedQuery(name = "Costos.findByCodigo", query = "SELECT c FROM Costos c WHERE c.costosPK.codigo = :codigo"),
    @NamedQuery(name = "Costos.findByTalle", query = "SELECT c FROM Costos c WHERE c.costosPK.talle = :talle"),
    @NamedQuery(name = "Costos.findByOrigen", query = "SELECT c FROM Costos c WHERE c.origen = :origen"),
    @NamedQuery(name = "Costos.findByCostoEntrada", query = "SELECT c FROM Costos c WHERE c.costoEntrada = :costoEntrada"),
    @NamedQuery(name = "Costos.findByCostoCompra", query = "SELECT c FROM Costos c WHERE c.costoCompra = :costoCompra")})
public class Costos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CostosPK costosPK;
    @Column(name = "origen")
    private String origen;
    @Column(name = "costo_entrada")
    private String costoEntrada;
    @Basic(optional = false)
    @Column(name = "costo_compra")
    private String costoCompra;
    @JoinColumn(name = "talle", referencedColumnName = "talle", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Talles talles;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descripciones descripciones;

    public Costos() {
    }

    public Costos(CostosPK costosPK) {
        this.costosPK = costosPK;
    }

    public Costos(CostosPK costosPK, String costoCompra) {
        this.costosPK = costosPK;
        this.costoCompra = costoCompra;
    }

    public Costos(String codigo, String talle) {
        this.costosPK = new CostosPK(codigo, talle);
    }

    public CostosPK getCostosPK() {
        return costosPK;
    }

    public void setCostosPK(CostosPK costosPK) {
        this.costosPK = costosPK;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getCostoEntrada() {
        return costoEntrada;
    }

    public void setCostoEntrada(String costoEntrada) {
        this.costoEntrada = costoEntrada;
    }

    public String getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(String costoCompra) {
        this.costoCompra = costoCompra;
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
        hash += (costosPK != null ? costosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costos)) {
            return false;
        }
        Costos other = (Costos) object;
        if ((this.costosPK == null && other.costosPK != null) || (this.costosPK != null && !this.costosPK.equals(other.costosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Costos[ costosPK=" + costosPK + " ]";
    }
    
}
