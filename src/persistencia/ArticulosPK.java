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
public class ArticulosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "talle")
    private String talle;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "local")
    private String local;

    public ArticulosPK() {
    }

    public ArticulosPK(String codigo, String talle, String color, String local) {
        this.codigo = codigo;
        this.talle = talle;
        this.color = color;
        this.local = local;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        hash += (talle != null ? talle.hashCode() : 0);
        hash += (color != null ? color.hashCode() : 0);
        hash += (local != null ? local.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticulosPK)) {
            return false;
        }
        ArticulosPK other = (ArticulosPK) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        if ((this.talle == null && other.talle != null) || (this.talle != null && !this.talle.equals(other.talle))) {
            return false;
        }
        if ((this.color == null && other.color != null) || (this.color != null && !this.color.equals(other.color))) {
            return false;
        }
        if ((this.local == null && other.local != null) || (this.local != null && !this.local.equals(other.local))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.ArticulosPK[ codigo=" + codigo + ", talle=" + talle + ", color=" + color + ", local=" + local + " ]";
    }
    
}
