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
import javax.persistence.Lob;
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
@Table(name = "grupo_permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoPermiso.findAll", query = "SELECT g FROM GrupoPermiso g"),
    @NamedQuery(name = "GrupoPermiso.findByGrupo", query = "SELECT g FROM GrupoPermiso g WHERE g.grupoPermisoPK.grupo = :grupo"),
    @NamedQuery(name = "GrupoPermiso.findByPermiso", query = "SELECT g FROM GrupoPermiso g WHERE g.grupoPermisoPK.permiso = :permiso")})
public class GrupoPermiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoPermisoPK grupoPermisoPK;
    @Lob
    @Column(name = "negativo")
    private byte[] negativo;
    @JoinColumn(name = "permiso", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permisos permisos;
    @JoinColumn(name = "grupo", referencedColumnName = "nombre", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Grupos grupos;

    public GrupoPermiso() {
    }

    public GrupoPermiso(GrupoPermisoPK grupoPermisoPK) {
        this.grupoPermisoPK = grupoPermisoPK;
    }

    public GrupoPermiso(String grupo, String permiso) {
        this.grupoPermisoPK = new GrupoPermisoPK(grupo, permiso);
    }

    public GrupoPermisoPK getGrupoPermisoPK() {
        return grupoPermisoPK;
    }

    public void setGrupoPermisoPK(GrupoPermisoPK grupoPermisoPK) {
        this.grupoPermisoPK = grupoPermisoPK;
    }

    public byte[] getNegativo() {
        return negativo;
    }

    public void setNegativo(byte[] negativo) {
        this.negativo = negativo;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public Grupos getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoPermisoPK != null ? grupoPermisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPermiso)) {
            return false;
        }
        GrupoPermiso other = (GrupoPermiso) object;
        if ((this.grupoPermisoPK == null && other.grupoPermisoPK != null) || (this.grupoPermisoPK != null && !this.grupoPermisoPK.equals(other.grupoPermisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.GrupoPermiso[ grupoPermisoPK=" + grupoPermisoPK + " ]";
    }
    
}
