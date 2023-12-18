package epicode.dao;

import epicode.entities.Event;
import epicode.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();

        System.out.println("Persona " + persona.getNome() + " " + persona.getCognome() + " aggiunto correttamente!");
    }

    public Persona findById(long id) {
        return em.find(Persona.class, id);
    }

    public void findByIdAndDelete(long id) {
        Persona found = this.findById(id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();

            System.out.println("Event " + found.getNome() + " " + found.getCognome() + " removed successfully!");
        } else {
            System.out.println("Event with id:" + id + " not found!");
        }
    }
}
