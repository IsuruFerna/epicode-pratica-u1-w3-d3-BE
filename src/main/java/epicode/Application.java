package epicode;

import com.github.javafaker.Faker;
import epicode.dao.EventsDAO;
import epicode.dao.LocationDAO;
import epicode.dao.PartecipazioneDAO;
import epicode.dao.PersonaDAO;
import epicode.dao.PersonaDAO;
import epicode.entities.*;
import org.hibernate.mapping.Array;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.SimpleFormatter;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventsDAO event = new EventsDAO(em);
        PersonaDAO person = new PersonaDAO(em);
        LocationDAO location = new LocationDAO(em);
        PartecipazioneDAO partecipazione = new PartecipazioneDAO(em);

        Faker faker = new Faker();

        Supplier<String> email = () -> faker.name().fullName().replaceAll("\\s", "") + "@example.com";
        Supplier<LocalDate> birthDate = () -> {
            Date bd = faker.date().birthday();
            int day = bd.getDay() + 1;
            int month = bd.getMonth() + 1;
            int year = bd.getYear();
            return LocalDate.of(year, month, day);
        };

        Persona p1 = new Persona(faker.name().firstName(), faker.name().lastName(), email.get(), birthDate.get(), "M");
//        person.save((p1));

        Persona p2 = new Persona("name", "surname", "name@example.com", LocalDate.of(2000, 03, 23), "M");
//        person.save(p2);


//        save location
//        Event e1 = event.findById(3);
//        Location l1 = new Location("nice event", "somewhere", e1);
//        location.save(l1);
//
//        Event e5 = event.findById(5);
//        Persona pd = person.findById(29);
//        Partecipazione partecipa = new Partecipazione(PartecipazioneStato.CONFERMATA, pd, e5);
//        partecipazione.save(partecipa);


        // ******************* Save *************
//        Event event1 = new Event("Event1", "2022-10-10", "this is an amazing event", EventType.PUBBLICO, 2000);
//        Event event2 = new Event("Event2", "2022-12-11", "gretest disco event", EventType.PRIVATO, 100);
//        Event event3 = new Event("Event3", "2022-02-03", "EDM festival Milano", EventType.PUBBLICO, 1000);

//        event.save(event1);
//        event.save(event2);
//        event.save(event3);

        // ****************** Find by id **************
//        long id = 3;
//        Event eventFromDB = event.findById(id);
//        if(eventFromDB != null) {
//            System.out.println(eventFromDB);
//        } else {
//            System.out.println("Event with " + id + " does not found! :(");
//        }

        // ****************** Find by Id and remove ****************
//        event.findByIdAndDelete(6);


        // ***********************  Create concerti  ****************************
//        Concerto c1 = new Concerto("summerHot",
//                "2024-06-03",
//                "greated music festival in Miami",
//                EventType.PRIVATO, 1000,
//                GenreMusic.ROCK,
//                true);
//
//        Concerto c2 = new Concerto("summerHot",
//                "2023-09-12",
//                "classic music in Ams",
//                EventType.PRIVATO, 800,
//                GenreMusic.CLASSICO,
//                false);
//
//        event.save(c1);
//        event.save(c2);


        List<Concerto> eventsInStreaming = event.getConcertiInStreaming(false);
        eventsInStreaming.forEach(System.out::println);

        List<Concerto> concertoGenere = event.getConcertiPerGenere(GenreMusic.ROCK);
        concertoGenere.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
