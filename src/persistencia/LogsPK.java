/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andres
 */
@Embeddable
public class LogsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "accion")
    private int accion;
    @Basic(optional = false)
    @Column(name = "ordinal")
    private int ordinal;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "maquina")
    private String maquina;

    public LogsPK() {
    }

    public LogsPK(int accion, int ordinal, Date fecha, String maquina) {
        this.accion = accion;
        this.ordinal = ordinal;
        this.fecha = fecha;
        this.maquina = maquina;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) accion;
        hash += (int) ordinal;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (maquina != null ? maquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogsPK)) {
            return false;
        }
        LogsPK other = (LogsPK) object;
        if (this.accion != other.accion) {
            return false;
        }
        if (this.ordinal != other.ordinal) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.maquina == null && other.maquina != null) || (this.maquina != null && !this.maquina.equals(other.maquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.LogsPK[ accion=" + accion + ", ordinal=" + ordinal + ", fecha=" + fecha + ", maquina=" + maquina + " ]";
    }
    
}
