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
@Table(name = "tipo_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPagos.findAll", query = "SELECT t FROM TipoPagos t"),
    @NamedQuery(name = "TipoPagos.findByTipopago", query = "SELECT t FROM TipoPagos t WHERE t.tipopago = :tipopago")})
public class TipoPagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipopago")
    private String tipopago;

    public TipoPagos() {
    }

    public TipoPagos(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipopago != null ? tipopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPagos)) {
            return false;
        }
        TipoPagos other = (TipoPagos) object;
        if ((this.tipopago == null && other.tipopago != null) || (this.tipopago != null && !this.tipopago.equals(other.tipopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TipoPagos[ tipopago=" + tipopago + " ]";
    }
    
}
