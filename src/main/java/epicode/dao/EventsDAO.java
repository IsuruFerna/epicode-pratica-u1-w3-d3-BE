package epicode.dao;

import epicode.entities.Concerto;
import epicode.entities.Event;
import epicode.entities.EventType;
import epicode.entities.GenreMusic;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventsDAO {

    private final EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event);
        transaction.commit();

        System.out.println("Event " + event.getTitolo() + " aggiunto correttamente!");
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        Event found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();

            System.out.println("Event " + found.getTitolo() + " removed successfully!");
        } else {
            System.out.println("Event with id:" + id + " not found!");
        }
    }

    public List<Concerto> getConcertiInStreaming(boolean isStreaming) {
        TypedQuery<Concerto> getIsStreaming = em.createNamedQuery("getConcertiInStreaming", Concerto.class);
        getIsStreaming.setParameter("is_streaming", isStreaming);
        return getIsStreaming.getResultList();
    };

    public List<Concerto> getConcertiPerGenere(GenreMusic genreMusic) {
        TypedQuery<Concerto> getGenere = em.createNamedQuery("getConcertiPerGenre", Concerto.class);
        getGenere.setParameter("genere", genreMusic);
        return getGenere.getResultList();
    }
}
