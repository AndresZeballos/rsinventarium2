/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.Grupos;
import persistencia.Usuarios;

/**
 *
 * @author Andres
 */
public class ControladorUsuarios {
    
    
    public boolean crear(String user, char[] pass, String nombre, String fexp, int errores, ArrayList<String> grupos) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Logger.begin();
        String permiso = "Alta de usuario";
        boolean result = false;
        try {
            s.beginTransaction();
            Usuarios usuario = new Usuarios(user);
            String aux = "";
            for(char foo : pass){
                aux += foo;
            }
            byte[] bytepass = Cifrador.encrypt(aux);
            usuario.setPass(bytepass);
            usuario.setNombre(nombre);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(fexp);
            usuario.setExpirPass(fecha);
            
            usuario.setErroresPermitidos(errores);
            ArrayList<Grupos> groups = new ArrayList<Grupos>();
            for (String g : grupos) {
                Query query = s.getNamedQuery("Grupos.findByNombre");
                query.setString("nombre", g);
                Grupos group = (Grupos) query.uniqueResult();
                List<Usuarios> bar = group.getUsuariosList();
                bar.add(usuario);
                group.setUsuariosList(bar);
                groups.add(group);
                Logger.log(s, permiso, "Se asocia el Grupo:" + group.toString());
            }
            usuario.setGruposList(groups);
            s.save(usuario);
            Logger.log(s, permiso, "Se crea el usuario:" + usuario.toString());
            s.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
            }
        } finally {
            s.close();
        }
        Logger.end();
        return result;
    }
    
    public Hashtable<String, String> cargar(String usuario) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Usuarios.findByUser");
        query.setString("user", usuario);
        Usuarios u = (Usuarios) query.uniqueResult();
        Hashtable<String, String> datos = new Hashtable<String, String>();
        datos.put("nombre", u.getNombre());
        try{
            String pass = Cifrador.decrypt(u.getPass());
            datos.put("pass", pass);
        } catch(Exception e){
            datos.put("pass", "");
        }
        Date date = u.getExpirPass(); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        datos.put("fexp", sdf.format(date));
        datos.put("errores", u.getErroresPermitidos().toString());
        s.getTransaction().commit();
        return datos;
    }
    
    public List<String> cargarGrupos(String usuario) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Usuarios.findByUser");
        query.setString("user", usuario);
        Usuarios u = (Usuarios) query.uniqueResult();
        s.getTransaction().commit();
        List<Grupos> groups = u.getGruposList();
        ArrayList<String> g = new ArrayList<String>();
        for (Grupos group : groups) {
            g.add(group.getNombre());
        }
        return g;
    }
    
    public boolean eliminar(String usuario) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Logger.begin();
        String permiso = "Baja de usuario";
        boolean result = false;
        try {
            s.beginTransaction();
            Query query = s.getNamedQuery("Usuarios.findByUser");
            query.setString("user", usuario);
            Usuarios u = (Usuarios) query.uniqueResult();
            Logger.log(s, permiso, "Imagen anterior: " + u.toString());
            for(Grupos g : u.getGruposList()){
                Logger.log(s, permiso, "Grupo asociado: " + g.toString());
            }
            s.delete(u);
            Logger.log(s, permiso, "Se baja el usuario: " + u.toString());
            s.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
            }
        } finally {
            s.close();
        }
        Logger.end();
        return result;
    }
    
    public boolean modificar(String user, char[] pass, String nombre, String fexp, int errores, ArrayList<String> grupos) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Logger.begin();
        String permiso = "Modificar usuario";
        boolean result = false;
        try {
            s.beginTransaction();
            Query query = s.getNamedQuery("Usuarios.findByUser");
            query.setString("user", user);
            Usuarios u = (Usuarios) query.uniqueResult();
            Logger.log(s, permiso, "Imagen anterior: " + u.toString());
            for(Grupos g : u.getGruposList()){
                Logger.log(s, permiso, "Grupo asociado: " + g.toString());
                g.getUsuariosList().remove(u);
                s.update(g);
            }
            String aux = "";
            for(char foo : pass){
                aux += foo;
            }
            byte[] bytepass = Cifrador.encrypt(aux);
            u.setPass(bytepass);
            u.setNombre(nombre);
            u.setExpirPass(new Date(fexp));
            u.setErroresPermitidos(errores);
            ArrayList<Grupos> groups = new ArrayList<Grupos>();
            for (String g : grupos) {
                query = s.getNamedQuery("Grupos.findByNombre");
                query.setString("nombre", g);
                Grupos group = (Grupos) query.uniqueResult();
                List<Usuarios> bar = group.getUsuariosList();
                bar.add(u);
                group.setUsuariosList(bar);
                s.update(group);
                groups.add(group);
                Logger.log(s, permiso, "Se asocia el Grupo:" + group.toString());
            }
            u.setGruposList(groups);
            s.saveOrUpdate(u);
            Logger.log(s, permiso, "Se modifica el usuario:" + u.toString());
            s.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
            }
        } finally {
            s.close();
        }
        Logger.end();
        return result;
    }
}