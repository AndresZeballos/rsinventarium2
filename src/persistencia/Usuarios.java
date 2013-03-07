/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUser", query = "SELECT u FROM Usuarios u WHERE u.user = :user"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByExpirPass", query = "SELECT u FROM Usuarios u WHERE u.expirPass = :expirPass"),
    @NamedQuery(name = "Usuarios.findByErroresPermitidos", query = "SELECT u FROM Usuarios u WHERE u.erroresPermitidos = :erroresPermitidos"),
    @NamedQuery(name = "Usuarios.findByUltimoLogin", query = "SELECT u FROM Usuarios u WHERE u.ultimoLogin = :ultimoLogin")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Lob
    @Column(name = "pass")
    private byte[] pass;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "expir_pass")
    @Temporal(TemporalType.DATE)
    private Date expirPass;
    @Column(name = "errores_permitidos")
    private Integer erroresPermitidos;
    @Column(name = "ultimo_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoLogin;
    @ManyToMany(mappedBy = "usuariosList", fetch = FetchType.LAZY)
    private List<Grupos> gruposList;

    public Usuarios() {
    }

    public Usuarios(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public byte[] getPass() {
        return pass;
    }

    public void setPass(byte[] pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getExpirPass() {
        return expirPass;
    }

    public void setExpirPass(Date expirPass) {
        this.expirPass = expirPass;
    }

    public Integer getErroresPermitidos() {
        return erroresPermitidos;
    }

    public void setErroresPermitidos(Integer erroresPermitidos) {
        this.erroresPermitidos = erroresPermitidos;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @XmlTransient
    public List<Grupos> getGruposList() {
        return gruposList;
    }

    public void setGruposList(List<Grupos> gruposList) {
        this.gruposList = gruposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (user != null ? user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Usuarios[ user=" + user + " ]";
    }
    
}
