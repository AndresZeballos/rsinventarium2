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
public class LineaFacturaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "factura")
    private int factura;
    @Basic(optional = false)
    @Column(name = "linea")
    private int linea;

    public LineaFacturaPK() {
    }

    public LineaFacturaPK(int factura, int linea) {
        this.factura = factura;
        this.linea = linea;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) factura;
        hash += (int) linea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaFacturaPK)) {
            return false;
        }
        LineaFacturaPK other = (LineaFacturaPK) object;
        if (this.factura != other.factura) {
            return false;
        }
        if (this.linea != other.linea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.LineaFacturaPK[ factura=" + factura + ", linea=" + linea + " ]";
    }
    
}
