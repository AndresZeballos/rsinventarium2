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
public class CostosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "talle")
    private String talle;

    public CostosPK() {
    }

    public CostosPK(String codigo, String talle) {
        this.codigo = codigo;
        this.talle = talle;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        hash += (talle != null ? talle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CostosPK)) {
            return false;
        }
        CostosPK other = (CostosPK) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        if ((this.talle == null && other.talle != null) || (this.talle != null && !this.talle.equals(other.talle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.CostosPK[ codigo=" + codigo + ", talle=" + talle + " ]";
    }
    
}
