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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "modulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulos.findAll", query = "SELECT m FROM Modulos m"),
    @NamedQuery(name = "Modulos.findByModulo", query = "SELECT m FROM Modulos m WHERE m.modulo = :modulo")})
public class Modulos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "modulo")
    private String modulo;
    @Basic(optional = false)
    @Lob
    @Column(name = "licencia")
    private byte[] licencia;

    public Modulos() {
    }

    public Modulos(String modulo) {
        this.modulo = modulo;
    }

    public Modulos(String modulo, byte[] licencia) {
        this.modulo = modulo;
        this.licencia = licencia;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public byte[] getLicencia() {
        return licencia;
    }

    public void setLicencia(byte[] licencia) {
        this.licencia = licencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modulo != null ? modulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulos)) {
            return false;
        }
        Modulos other = (Modulos) object;
        if ((this.modulo == null && other.modulo != null) || (this.modulo != null && !this.modulo.equals(other.modulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Modulos[ modulo=" + modulo + " ]";
    }
    
}
