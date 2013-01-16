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
@Table(name = "composiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Composiciones.findAll", query = "SELECT c FROM Composiciones c"),
    @NamedQuery(name = "Composiciones.findByCodigo", query = "SELECT c FROM Composiciones c WHERE c.composicionesPK.codigo = :codigo"),
    @NamedQuery(name = "Composiciones.findByComponent", query = "SELECT c FROM Composiciones c WHERE c.composicionesPK.component = :component"),
    @NamedQuery(name = "Composiciones.findByPorcentaje", query = "SELECT c FROM Composiciones c WHERE c.porcentaje = :porcentaje")})
public class Composiciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComposicionesPK composicionesPK;
    @Basic(optional = false)
    @Column(name = "porcentaje")
    private int porcentaje;
    @JoinColumn(name = "component", referencedColumnName = "component", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Componentes componentes;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descripciones descripciones;

    public Composiciones() {
    }

    public Composiciones(ComposicionesPK composicionesPK) {
        this.composicionesPK = composicionesPK;
    }

    public Composiciones(ComposicionesPK composicionesPK, int porcentaje) {
        this.composicionesPK = composicionesPK;
        this.porcentaje = porcentaje;
    }

    public Composiciones(String codigo, String component) {
        this.composicionesPK = new ComposicionesPK(codigo, component);
    }

    public ComposicionesPK getComposicionesPK() {
        return composicionesPK;
    }

    public void setComposicionesPK(ComposicionesPK composicionesPK) {
        this.composicionesPK = composicionesPK;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public void setComponentes(Componentes componentes) {
        this.componentes = componentes;
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
        hash += (composicionesPK != null ? composicionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Composiciones)) {
            return false;
        }
        Composiciones other = (Composiciones) object;
        if ((this.composicionesPK == null && other.composicionesPK != null) || (this.composicionesPK != null && !this.composicionesPK.equals(other.composicionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Composiciones[ composicionesPK=" + composicionesPK + " ]";
    }
    
}
