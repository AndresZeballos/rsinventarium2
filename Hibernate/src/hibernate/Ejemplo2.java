package hibernate;

import java.util.List;
import org.hibernate.Session;

public class Ejemplo2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Ejemplo2();
    }

    public static void Ejemplo2() {
        List<Eventos> l = listEventoss2();
        System.out.println("Antes de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        System.out.println("");
        createAndStoreEventos("El Eventos", "Que eventoooo");
        l = listEventoss2();
        System.out.println("\nDespues de la inserccion \n");
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i).toString());
        }
        HibernateUtil.getSessionFactory().close();
    }

    private static Long createAndStoreEventos(String name, String taste) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Eventos theEventos = new Eventos();
        theEventos.setTaste(taste);
        theEventos.setName(name);
        session.save(theEventos);
        session.getTransaction().commit();
        return theEventos.getId();
    }

    @SuppressWarnings("unchecked")
    private static List<Eventos> listEventoss2() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Eventos> result = session.createCriteria(Eventos.class).list();
        session.getTransaction().commit();
        return result;
    }
}