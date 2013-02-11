/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.GrupoPermiso;
import persistencia.GrupoPermisoPK;
import persistencia.Grupos;
import persistencia.Usuarios;

/**
 *
 * @author Andres
 */
public class ControladorGrupos {

    public ControladorGrupos() {
    }

    public boolean crear(String nombre, String descripcion, ArrayList<String[]> permisos, ArrayList<String> usuarios) {
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        Logger.begin();
        String permiso = "Alta de grupo";
        boolean result = false;
        try {
            s.beginTransaction();
            Grupos grupo = new Grupos(nombre);
            grupo.setDescripcion(descripcion);
            ArrayList<Usuarios> users = new ArrayList<Usuarios>();
            for (String u : usuarios) {
                Query query = s.getNamedQuery("Usuarios.findByUser");
                query.setString("user", u);
                Usuarios user = (Usuarios) query.uniqueResult();
                users.add(user);
                Logger.log(s, permiso, "Se asocia el Usuario:" + user.toString());
            }
            grupo.setUsuariosList(users);
            ArrayList<GrupoPermiso> perms = new ArrayList<GrupoPermiso>();
            for (String[] a : permisos) {
                GrupoPermiso gp = new GrupoPermiso(new GrupoPermisoPK(nombre, a[0]));
                byte[] vOut = new byte[]{(byte) (a[1].equals("true") ? 1 : 0)};
                gp.setNegativo(vOut);
                perms.add(gp);
                Logger.log(s, permiso, "Se asocia el GrupoPermiso:" + gp.toString());
            }
            grupo.setGrupoPermisoList(perms);
            s.save(grupo);
            Logger.log(s, permiso, "Se crea el grupo:" + grupo.toString());
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

    public String cargar(String grupo) {
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Grupos.findByNombre");
        query.setString("nombre", grupo);
        Grupos g = (Grupos) query.uniqueResult();
        s.getTransaction().commit();
        return g.getDescripcion();
    }

    public List<String> cargarUsuarios(String grupo) {
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("Grupos.findByNombre");
        query.setString("nombre", grupo);
        Grupos g = (Grupos) query.uniqueResult();
        s.getTransaction().commit();
        List<Usuarios> users = g.getUsuariosList();
        ArrayList<String> u = new ArrayList<String>();
        for (Usuarios user : users) {
            u.add(user.getUser());
        }
        return u;
    }

    public List<String[]> cargarPermisos(String grupo) {
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query query = s.getNamedQuery("GrupoPermiso.findByGrupo");
        query.setString("grupo", grupo);
        List<GrupoPermiso> g = query.list();
        s.getTransaction().commit();
        ArrayList<String[]> u = new ArrayList<String[]>();
        for (GrupoPermiso gp : g) {
            u.add(new String[]{gp.getPermisos().getNombre(), (gp.getNegativo()[0] == 1 ? "true" : "false")});
        }
        return u;
    }

    public boolean eliminar(String grupo) {
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        Logger.begin();
        String permiso = "Baja de grupo";
        boolean result = false;
        try {
            s.beginTransaction();
            Query query = s.getNamedQuery("Grupos.findByNombre");
            query.setString("nombre", grupo);
            Grupos g = (Grupos) query.uniqueResult();
            Logger.log(s, permiso, "Imagen anterior: " + grupo.toString());
            for(Usuarios u : g.getUsuariosList()){
                Logger.log(s, permiso, "Usuario asociado: " + u.toString());
            }
            for(GrupoPermiso gp : g.getGrupoPermisoList()){
                Logger.log(s, permiso, "GrupoPermiso asociado: " + gp.toString());
            }
            s.delete(g);
            Logger.log(s, permiso, "Se baja el grupo: " + g.toString());
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
    
    public boolean modificar(String nombre, String descripcion, ArrayList<String[]> permisos, ArrayList<String> usuarios) {
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        Logger.begin();
        String permiso = "Modificar grupo";
        boolean result = false;
        try {
            s.beginTransaction();
            Query query = s.getNamedQuery("Grupos.findByNombre");
            query.setString("nombre", nombre);
            Grupos grupo = (Grupos) query.uniqueResult();
            Logger.log(s, permiso, "Imagen anterior: " + grupo.toString());
            for(Usuarios u : grupo.getUsuariosList()){
                Logger.log(s, permiso, "Usuario asociado: " + u.toString());
            }
            for(GrupoPermiso gp : grupo.getGrupoPermisoList()){
                Logger.log(s, permiso, "GrupoPermiso asociado: " + gp.toString());
            }
            s.delete(grupo);
            grupo.setDescripcion(descripcion);
            ArrayList<Usuarios> users = new ArrayList<Usuarios>();
            for (String u : usuarios) {
                query = s.getNamedQuery("Usuarios.findByUser");
                query.setString("user", u);
                Usuarios l = (Usuarios) query.uniqueResult();
                users.add(l);
                Logger.log(s, permiso, "Se asocia el Usuario:" + l.toString());
            }
            grupo.setUsuariosList(users);
            ArrayList<GrupoPermiso> perms = new ArrayList<GrupoPermiso>();
            for (String[] a : permisos) {
                GrupoPermiso gp = new GrupoPermiso(new GrupoPermisoPK(nombre, a[0]));
                byte[] vOut = new byte[]{(byte) (a[1].equals("true") ? 1 : 0)};
                gp.setNegativo(vOut);
                perms.add(gp);
                Logger.log(s, permiso, "Se asocia el GrupoPermiso:" + gp.toString());
            }
            grupo.setGrupoPermisoList(perms);
            s.save(grupo);
            Logger.log(s, permiso, "Se modifico el grupo:" + grupo.toString());
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
