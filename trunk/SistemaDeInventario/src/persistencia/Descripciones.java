/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "descripciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descripciones.findAll", query = "SELECT d FROM Descripciones d"),
    @NamedQuery(name = "Descripciones.findByCodigo", query = "SELECT d FROM Descripciones d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Descripciones.findByDescripcion", query = "SELECT d FROM Descripciones d WHERE d.descripcion = :descripcion")})
public class Descripciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "marca", referencedColumnName = "marca")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Marcas marca;
    @JoinColumn(name = "categoria", referencedColumnName = "categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categorias categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripciones", fetch = FetchType.LAZY)
    private List<Composiciones> composicionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripciones", fetch = FetchType.LAZY)
    private List<Articulos> articulosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripciones", fetch = FetchType.LAZY)
    private List<Costos> costosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo", fetch = FetchType.LAZY)
    private List<LineaFactura> lineaFacturaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripciones", fetch = FetchType.LAZY)
    private List<Precios> preciosList;

    public Descripciones() {
    }

    public Descripciones(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Marcas getMarca() {
        return marca;
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public List<Composiciones> getComposicionesList() {
        return composicionesList;
    }

    public void setComposicionesList(List<Composiciones> composicionesList) {
        this.composicionesList = composicionesList;
    }

    @XmlTransient
    public List<Articulos> getArticulosList() {
        return articulosList;
    }

    public void setArticulosList(List<Articulos> articulosList) {
        this.articulosList = articulosList;
    }

    @XmlTransient
    public List<Costos> getCostosList() {
        return costosList;
    }

    public void setCostosList(List<Costos> costosList) {
        this.costosList = costosList;
    }

    @XmlTransient
    public List<LineaFactura> getLineaFacturaList() {
        return lineaFacturaList;
    }

    public void setLineaFacturaList(List<LineaFactura> lineaFacturaList) {
        this.lineaFacturaList = lineaFacturaList;
    }

    @XmlTransient
    public List<Precios> getPreciosList() {
        return preciosList;
    }

    public void setPreciosList(List<Precios> preciosList) {
        this.preciosList = preciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripciones)) {
            return false;
        }
        Descripciones other = (Descripciones) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Descripciones[ codigo=" + codigo + " ]";
    }
    
}
