/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "monedas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monedas.findAll", query = "SELECT m FROM Monedas m"),
    @NamedQuery(name = "Monedas.findByMoneda", query = "SELECT m FROM Monedas m WHERE m.moneda = :moneda")})
public class Monedas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "moneda")
    private String moneda;

    public Monedas() {
    }

    public Monedas(String moneda) {
        this.moneda = moneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moneda != null ? moneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monedas)) {
            return false;
        }
        Monedas other = (Monedas) object;
        if ((this.moneda == null && other.moneda != null) || (this.moneda != null && !this.moneda.equals(other.moneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Monedas[ moneda=" + moneda + " ]";
    }
    
}
