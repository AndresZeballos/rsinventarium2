/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "linea_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LineaFactura.findAll", query = "SELECT l FROM LineaFactura l"),
    @NamedQuery(name = "LineaFactura.findByFactura", query = "SELECT l FROM LineaFactura l WHERE l.lineaFacturaPK.factura = :factura"),
    @NamedQuery(name = "LineaFactura.findByLinea", query = "SELECT l FROM LineaFactura l WHERE l.lineaFacturaPK.linea = :linea"),
    @NamedQuery(name = "LineaFactura.findByCantidad", query = "SELECT l FROM LineaFactura l WHERE l.cantidad = :cantidad"),
    @NamedQuery(name = "LineaFactura.findByPrecio", query = "SELECT l FROM LineaFactura l WHERE l.precio = :precio")})
public class LineaFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LineaFacturaPK lineaFacturaPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private String precio;
    @JoinColumn(name = "talle", referencedColumnName = "talle")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Talles talle;
    @JoinColumn(name = "factura", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Facturas facturas;
    @JoinColumn(name = "color", referencedColumnName = "Color")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colores color;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descripciones codigo;

    public LineaFactura() {
    }

    public LineaFactura(LineaFacturaPK lineaFacturaPK) {
        this.lineaFacturaPK = lineaFacturaPK;
    }

    public LineaFactura(LineaFacturaPK lineaFacturaPK, int cantidad, String precio) {
        this.lineaFacturaPK = lineaFacturaPK;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public LineaFactura(int factura, int linea) {
        this.lineaFacturaPK = new LineaFacturaPK(factura, linea);
    }

    public LineaFacturaPK getLineaFacturaPK() {
        return lineaFacturaPK;
    }

    public void setLineaFacturaPK(LineaFacturaPK lineaFacturaPK) {
        this.lineaFacturaPK = lineaFacturaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Talles getTalle() {
        return talle;
    }

    public void setTalle(Talles talle) {
        this.talle = talle;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public Descripciones getCodigo() {
        return codigo;
    }

    public void setCodigo(Descripciones codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineaFacturaPK != null ? lineaFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaFactura)) {
            return false;
        }
        LineaFactura other = (LineaFactura) object;
        if ((this.lineaFacturaPK == null && other.lineaFacturaPK != null) || (this.lineaFacturaPK != null && !this.lineaFacturaPK.equals(other.lineaFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.LineaFactura[ lineaFacturaPK=" + lineaFacturaPK + " ]";
    }
    
}
