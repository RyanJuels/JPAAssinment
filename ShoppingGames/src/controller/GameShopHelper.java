/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Feb 10, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Game;

public class GameShopHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ShoppingGames");
	
	public void insertGame(Game game) {
		EntityManager em	 = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(game);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Game> showAllGames() {
		EntityManager em = emfactory.createEntityManager();
		List<Game> games = em.createQuery("SELECT i FROM Game i").getResultList();
		return games;
	}
	
	public void deleteGame(Game deleted) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery = em.createQuery("select game from Game game where game.publisher = :selectedPublisher and game.gameName = :selectedGameName", Game.class);
		typedQuery.setParameter("selectedPublisher", deleted.getPublisher());
		typedQuery.setParameter("selectedGameName", deleted.getGameName());
		typedQuery.setMaxResults(1);
		try {
		Game result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("That was not found in the database, please try again.\n");
		}
		em.close();
	}
	
	public Game searchForGameById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Game found = em.find(Game.class, idToEdit);
		em.close();
		return found;
	}
	public void updateItem(Game toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	public List<Game> searchForGameByPublisher(String pubName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery	= em.createQuery("select game from Game game where game.publisher = :selectedPublisher", Game.class);
		typedQuery.setParameter("selectedPublisher", pubName);
		List<Game> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
	}
	public List<Game> searchForGameByName(String gameName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Game> typedQuery	= em.createQuery("select game from Game game where game.gameName = :selectedGameName", Game.class);
		typedQuery.setParameter("selectedGameName", gameName);
		List<Game> foundGames = typedQuery.getResultList();
		em.close();
		return foundGames;
		
	}
	public void cleanUp() {
		emfactory.close();
	}
}
