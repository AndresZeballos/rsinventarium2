package hibernate;

import java.util.List;
import org.hibernate.Session;

public class Ejemplo1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Ejemplo1();
    }

    public static void Ejemplo1() {
        List<Event> l = listEvents();
        System.out.println("Antes de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        System.out.println("");
        createAndStoreEvent(10L, "El Event");
        l = listEvents2();
        System.out.println("\nDespues de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        HibernateUtil.getSessionFactory().close();
    }

    private static Long createAndStoreEvent(Long id, String title) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setId(id);
        session.save(theEvent);
        session.getTransaction().commit();
        return theEvent.getId();
    }

    @SuppressWarnings("unchecked")
    private static List<Event> listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    @SuppressWarnings("unchecked")
    private static List<Event> listEvents2() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Event> result = session.createCriteria(Event.class)
                .list();
        session.getTransaction().commit();
        return result;
    }
}