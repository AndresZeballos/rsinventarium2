/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.Logs;
import persistencia.LogsPK;

/**
 *
 * @author Andres
 */
public class Logger {
    
    private static int accion;
    private static int ordinal;
    private static Date fecha;
    private static String maquina = ControladorConfiguracion.leerDato("local");
    
    public static void log(Session s, String permiso, String descripcion){
        Logs l = new Logs(new LogsPK(accion, ordinal, fecha, maquina), permiso, descripcion);
        s.save(l);
        ordinal++;
    }
    
    public static void begin(){
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Query q = s.createSQLQuery("select count(*) from (select count(accion) from logs group by accion) as aux");
            Object o = q.uniqueResult();
            accion = Integer.parseInt(o.toString());
            ordinal = 0;
            fecha = new Date();
            Logs l = new Logs(new LogsPK(accion, ordinal, fecha, maquina), "", "Comienzo de transaccion.");
            s.save(l);
            ordinal++;
            s.getTransaction().commit();
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
            }
        } finally {
            s.close();
        }
    }
    
    public static void end(){
        Session s = persistencia.HibernateUtil.getSessionFactory().openSession();
        try {
            s.beginTransaction();
            Logs l = new Logs(new LogsPK(accion, ordinal, fecha, maquina), "", "Fin de transaccion.");
            s.save(l);
            s.getTransaction().commit();
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
            }
        } finally {
            s.close();
        }
    }
    
    
}
