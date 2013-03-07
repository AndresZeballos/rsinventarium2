/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "logs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l"),
    @NamedQuery(name = "Logs.findByAccion", query = "SELECT l FROM Logs l WHERE l.logsPK.accion = :accion"),
    @NamedQuery(name = "Logs.findByOrdinal", query = "SELECT l FROM Logs l WHERE l.logsPK.ordinal = :ordinal"),
    @NamedQuery(name = "Logs.findByFecha", query = "SELECT l FROM Logs l WHERE l.logsPK.fecha = :fecha"),
    @NamedQuery(name = "Logs.findByMaquina", query = "SELECT l FROM Logs l WHERE l.logsPK.maquina = :maquina"),
    @NamedQuery(name = "Logs.findByUser", query = "SELECT l FROM Logs l WHERE l.user = :user"),
    @NamedQuery(name = "Logs.findByPermiso", query = "SELECT l FROM Logs l WHERE l.permiso = :permiso"),
    @NamedQuery(name = "Logs.findByDescripcion", query = "SELECT l FROM Logs l WHERE l.descripcion = :descripcion")})
public class Logs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LogsPK logsPK;
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "permiso")
    private String permiso;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public Logs() {
    }

    public Logs(LogsPK logsPK) {
        this.logsPK = logsPK;
    }

    public Logs(LogsPK logsPK, String permiso, String descripcion) {
        this.logsPK = logsPK;
        this.permiso = permiso;
        this.descripcion = descripcion;
    }

    public Logs(int accion, int ordinal, Date fecha, String maquina) {
        this.logsPK = new LogsPK(accion, ordinal, fecha, maquina);
    }

    public LogsPK getLogsPK() {
        return logsPK;
    }

    public void setLogsPK(LogsPK logsPK) {
        this.logsPK = logsPK;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logsPK != null ? logsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.logsPK == null && other.logsPK != null) || (this.logsPK != null && !this.logsPK.equals(other.logsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Logs[ logsPK=" + logsPK + " ]";
    }
    
}
