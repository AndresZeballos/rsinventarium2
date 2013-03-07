/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "meses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meses.findAll", query = "SELECT m FROM Meses m"),
    @NamedQuery(name = "Meses.findByMes", query = "SELECT m FROM Meses m WHERE m.mes = :mes"),
    @NamedQuery(name = "Meses.findByActualizacion", query = "SELECT m FROM Meses m WHERE m.actualizacion = :actualizacion")})
public class Meses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mes")
    private String mes;
    @Basic(optional = false)
    @Column(name = "actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;

    public Meses() {
    }

    public Meses(String mes) {
        this.mes = mes;
    }

    public Meses(String mes, Date actualizacion) {
        this.mes = mes;
        this.actualizacion = actualizacion;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mes != null ? mes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meses)) {
            return false;
        }
        Meses other = (Meses) object;
        if ((this.mes == null && other.mes != null) || (this.mes != null && !this.mes.equals(other.mes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Meses[ mes=" + mes + " ]";
    }
    
}
