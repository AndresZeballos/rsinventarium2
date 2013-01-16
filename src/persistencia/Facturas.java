/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andres
 */
@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f"),
    @NamedQuery(name = "Facturas.findByNumero", query = "SELECT f FROM Facturas f WHERE f.numero = :numero"),
    @NamedQuery(name = "Facturas.findByFactura", query = "SELECT f FROM Facturas f WHERE f.factura = :factura"),
    @NamedQuery(name = "Facturas.findByFecha", query = "SELECT f FROM Facturas f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Facturas.findByMoneda", query = "SELECT f FROM Facturas f WHERE f.moneda = :moneda"),
    @NamedQuery(name = "Facturas.findByTipopago", query = "SELECT f FROM Facturas f WHERE f.tipopago = :tipopago"),
    @NamedQuery(name = "Facturas.findByPlazopago", query = "SELECT f FROM Facturas f WHERE f.plazopago = :plazopago"),
    @NamedQuery(name = "Facturas.findByIva", query = "SELECT f FROM Facturas f WHERE f.iva = :iva"),
    @NamedQuery(name = "Facturas.findByDescuentos", query = "SELECT f FROM Facturas f WHERE f.descuentos = :descuentos"),
    @NamedQuery(name = "Facturas.findByTotalSIva", query = "SELECT f FROM Facturas f WHERE f.totalSIva = :totalSIva")})
public class Facturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "factura")
    private String factura;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "moneda")
    private String moneda;
    @Column(name = "tipopago")
    private String tipopago;
    @Column(name = "plazopago")
    private String plazopago;
    @Basic(optional = false)
    @Column(name = "iva")
    private int iva;
    @Basic(optional = false)
    @Column(name = "descuentos")
    private int descuentos;
    @Basic(optional = false)
    @Column(name = "total_s_iva")
    private int totalSIva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas", fetch = FetchType.LAZY)
    private List<LineaFactura> lineaFacturaList;
    @JoinColumn(name = "proveedor", referencedColumnName = "nombre")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedores proveedor;

    public Facturas() {
    }

    public Facturas(Integer numero) {
        this.numero = numero;
    }

    public Facturas(Integer numero, Date fecha, String moneda, int iva, int descuentos, int totalSIva) {
        this.numero = numero;
        this.fecha = fecha;
        this.moneda = moneda;
        this.iva = iva;
        this.descuentos = descuentos;
        this.totalSIva = totalSIva;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public String getPlazopago() {
        return plazopago;
    }

    public void setPlazopago(String plazopago) {
        this.plazopago = plazopago;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(int descuentos) {
        this.descuentos = descuentos;
    }

    public int getTotalSIva() {
        return totalSIva;
    }

    public void setTotalSIva(int totalSIva) {
        this.totalSIva = totalSIva;
    }

    @XmlTransient
    public List<LineaFactura> getLineaFacturaList() {
        return lineaFacturaList;
    }

    public void setLineaFacturaList(List<LineaFactura> lineaFacturaList) {
        this.lineaFacturaList = lineaFacturaList;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Facturas[ numero=" + numero + " ]";
    }
    
}
