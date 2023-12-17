package epicode;

import com.github.javafaker.Faker;
import epicode.dao.EventsDAO;
import epicode.dao.LocationDAO;
import epicode.dao.PersonaDao;
import epicode.entities.Event;
import epicode.entities.EventType;
import epicode.entities.Location;
import epicode.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.Supplier;
import java.util.logging.SimpleFormatter;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO event = new EventsDAO(em);
        PersonaDao person = new PersonaDao(em);
        LocationDAO location = new LocationDAO(em);

        Faker faker = new Faker();

        Event event1 = new Event("Event1", "2022-10-10", "this is an amazing event", EventType.PUBBLICO, 2000);
        Event event2 = new Event("Event2", "2022-12-11", "gretest disco event", EventType.PRIVATO, 100);
        Event event3 = new Event("Event3", "2022-02-03", "EDM festival Milano", EventType.PUBBLICO, 1000);

        Supplier<String> email = () -> faker.name().fullName().replaceAll("\\s", "") + "@example.com";
        Supplier<LocalDate> birthDate = () -> {
            Date bd = faker.date().birthday();
            int day = bd.getDay() + 1;
            int month = bd.getMonth() + 1;
            int year = bd.getYear();
            return LocalDate.of(year, month, day);
        };

        Persona p1 = new Persona(faker.name().firstName(), faker.name().lastName(), email.get(), birthDate.get(), "M");
        person.save((p1));

        Location l1 = new Location("nice event", "somewhere");
        location.save(l1);

        // ******************* Save *************
//        event.save(event1);
//        event.save(event2);
//        event.save(event3);

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
