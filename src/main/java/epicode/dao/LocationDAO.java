package epicode.dao;

import epicode.entities.Event;
import epicode.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
	private final EntityManager em;

	public LocationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Location location) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(location);
		transaction.commit();

		System.out.println("Location " + location.getNome() + " aggiunto correttamente!");
	}

	public Location findById(long id) {
		return em.find(Location.class, id);
	}

	public void findByIdAndDelete(long id) {
		Location found = this.findById(id);

		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();

			System.out.println("Event " + found.getNome() + " removed successfully!");
		} else {
			System.out.println("Event with id:" + id + " not found!");
		}
	}


}
