/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Andres
 */
public class Ejemplo4 {

    public static void main(String[] args) {
        Ejemplo4();
    }

    public static void Ejemplo4() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List<Meses> l = listEventoss2(s);
        System.out.println("Antes de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        System.out.println("");
        
        createAndStoreEventos("02/2013", s);
        l = listEventoss2(s);
        System.out.println("\nDespues de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        
        System.out.println("");
        delete(s, "02/2013");
        System.out.println("");
        l = listEventoss2(s);
        System.out.println("\nDespues del delete \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        
        s.getTransaction().commit();        
    }
    
    private static List<Meses> listEventoss2(Session session) {
        List<Meses> result = session.createCriteria(Meses.class).list();
        return result;
    }
    

    private static void createAndStoreEventos(String mes, Session session) {
        Meses m = new Meses();
        m.setMes(mes);
        m.setActualizacion(new Date());
        session.save(m);
    }

    private static void delete(Session session, String mes) {
        Meses m = (Meses) session.createCriteria(Meses.class).add(Restrictions.eq("mes", mes)).list().get(0);
        session.delete(m);
    }
    
}