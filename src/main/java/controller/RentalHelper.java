package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Rental;

public class RentalHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("carrental");
	
	public void insertItem(Rental li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	public List<Rental> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Rental> allItems = em.createQuery("SELECT i from Rental i").getResultList();
		return allItems;
		
	}

	public void deleteItem(Rental toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Rental> typedQuery = em.createQuery("select li from Rental li where li.make = :selectedMake and li.model = :selectedModel", Rental.class);
		
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		
		typedQuery.setMaxResults(1);
		
		Rental result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Rental searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Rental found = em.find(Rental.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Rental toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
