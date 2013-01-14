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
@Table(name = "locales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locales.findAll", query = "SELECT l FROM Locales l"),
    @NamedQuery(name = "Locales.findByLocal", query = "SELECT l FROM Locales l WHERE l.local = :local")})
public class Locales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "local")
    private String local;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locales", fetch = FetchType.LAZY)
    private List<Articulos> articulosList;

    public Locales() {
    }

    public Locales(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @XmlTransient
    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (local != null ? local.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locales)) {
            return false;
        }
        Locales other = (Locales) object;
        if ((this.local == null && other.local != null) || (this.local != null && !this.local.equals(other.local))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Locales[ local=" + local + " ]";
    }
    
}
