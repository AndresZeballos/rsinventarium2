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
@Table(name = "componentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componentes.findAll", query = "SELECT c FROM Componentes c"),
    @NamedQuery(name = "Componentes.findByComponent", query = "SELECT c FROM Componentes c WHERE c.component = :component")})
public class Componentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "component")
    private String component;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "componentes", fetch = FetchType.LAZY)
    private List<Composiciones> composicionesList;

    public Componentes() {
    }

    public Componentes(String component) {
        this.component = component;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @XmlTransient
    public List<Composiciones> getComposicionesList() {
        return composicionesList;
    }

    public void setComposicionesList(List<Composiciones> composicionesList) {
        this.composicionesList = composicionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (component != null ? component.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componentes)) {
            return false;
        }
        Componentes other = (Componentes) object;
        if ((this.component == null && other.component != null) || (this.component != null && !this.component.equals(other.component))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Componentes[ component=" + component + " ]";
    }
    
}
