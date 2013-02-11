/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Andres
 */
@Embeddable
public class GrupoPermisoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "grupo")
    private String grupo;
    @Basic(optional = false)
    @Column(name = "permiso")
    private String permiso;

    public GrupoPermisoPK() {
    }

    public GrupoPermisoPK(String grupo, String permiso) {
        this.grupo = grupo;
        this.permiso = permiso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupo != null ? grupo.hashCode() : 0);
        hash += (permiso != null ? permiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPermisoPK)) {
            return false;
        }
        GrupoPermisoPK other = (GrupoPermisoPK) object;
        if ((this.grupo == null && other.grupo != null) || (this.grupo != null && !this.grupo.equals(other.grupo))) {
            return false;
        }
        if ((this.permiso == null && other.permiso != null) || (this.permiso != null && !this.permiso.equals(other.permiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.GrupoPermisoPK[ grupo=" + grupo + ", permiso=" + permiso + " ]";
    }
    
}
