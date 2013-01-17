/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "plazo_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlazoPagos.findAll", query = "SELECT p FROM PlazoPagos p"),
    @NamedQuery(name = "PlazoPagos.findByPlazopago", query = "SELECT p FROM PlazoPagos p WHERE p.plazopago = :plazopago")})
public class PlazoPagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "plazopago")
    private String plazopago;
    @OneToMany(mappedBy = "plazopago", fetch = FetchType.LAZY)
    private List<Facturas> facturasList;

    public PlazoPagos() {
    }

    public PlazoPagos(String plazopago) {
        this.plazopago = plazopago;
    }

    public String getPlazopago() {
        return plazopago;
    }

    public void setPlazopago(String plazopago) {
        this.plazopago = plazopago;
    }

    @XmlTransient
    public List<Facturas> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<Facturas> facturasList) {
        this.facturasList = facturasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plazopago != null ? plazopago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlazoPagos)) {
            return false;
        }
        PlazoPagos other = (PlazoPagos) object;
        if ((this.plazopago == null && other.plazopago != null) || (this.plazopago != null && !this.plazopago.equals(other.plazopago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.PlazoPagos[ plazopago=" + plazopago + " ]";
    }
    
}
