package epicode.dao;

import epicode.entities.Event;
import epicode.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {

    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();

        System.out.println("utente: " + partecipazione.getPersona() + ", partecipazione: " + " aggiunto correttamente!");
    }

    public Partecipazione findById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void addEventToPartecipazione(long partecipazioneId, long eventId) {
        EntityTransaction transaction =  em.getTransaction();
        transaction.begin();

        // find entities
        Event event = em.find(Event.class, eventId);
        Partecipazione partecipazione = em.find(Partecipazione.class, partecipazioneId);

        // add event
        partecipazione.addEvent(event);
        em.persist(partecipazione);
        transaction.commit();
    }

    public void findByIdAndDelete(long id) {
        Partecipazione found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();

            System.out.println("Participation " + " of " + found.getPersona() + " removed successfully!");
        } else {
            System.out.println("partecipation with id:" + id + " not found!");
        }
    }
}
