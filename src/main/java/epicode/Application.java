package epicode;

import epicode.dao.EventsDAO;
import epicode.entities.Event;
import epicode.entities.EventType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO event = new EventsDAO(em);

        Event event1 = new Event("Event1", "2022-10-10", "this is an amazing event", EventType.PUBBLICO, 2000);
        Event event2 = new Event("Event2", "2022-12-11", "gretest disco event", EventType.PRIVATO, 100);
        Event event3 = new Event("Event3", "2022-02-03", "EDM festival Milano", EventType.PUBBLICO, 1000);

        // ******************* Save *************
        event.save(event1);
        event.save(event2);
        event.save(event3);

        // ****************** Find by id **************
        long id = 3;
        Event eventFromDB = event.findById(id);
        if(eventFromDB != null) {
            System.out.println(eventFromDB);
        } else {
            System.out.println("Event with " + id + " does not found! :(");
        }

        // ****************** Find by Id and remove ****************
        event.findByIdAndDelete(6);

        em.close();
        emf.close();
    }
}
