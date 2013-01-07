/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

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
        HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
        List<Eventos> l = listEventoss2(false);
        System.out.println("Antes de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        System.out.println("");
        createAndStoreEventos("El Eventos", "Que eventoooo", false);
        l = listEventoss2(false);
        System.out.println("\nDespues de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        System.out.println("");
        delete(false);
        System.out.println("");
        l = listEventoss2(false);
        System.out.println("\nDespues del delete \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        HibernateUtil.getSessionFactory().close();
    }

    private static Long createAndStoreEventos(String name, String taste, boolean transaccional) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (transaccional) {
            session.beginTransaction();
        }
        Eventos theEventos = new Eventos();
        theEventos.setTaste(taste);
        theEventos.setName(name);
        session.save(theEventos);
        if (transaccional) {
            session.getTransaction().commit();
        }
        return theEventos.getId();
    }

    private static Long delete(boolean transaccional) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (transaccional) {
            session.beginTransaction();
        }
        Eventos theEventos = (Eventos) session.createCriteria(Eventos.class).add(Restrictions.eq("name", "El Eventos")).list().get(0);
        session.delete(theEventos);
        if (transaccional) {
            session.getTransaction().commit();
        }
        return theEventos.getId();
    }

    @SuppressWarnings("unchecked")
    private static List<Eventos> listEventoss2(boolean transaccional) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (transaccional) {
            session.beginTransaction();
        }
        List<Eventos> result = session.createCriteria(Eventos.class).list();
        if (transaccional) {
            session.getTransaction().commit();
        }
        return result;
    }
}