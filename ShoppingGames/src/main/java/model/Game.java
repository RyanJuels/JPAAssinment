/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Feb 10, 2022
 */
package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class Game {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="GAMENAME")
	private String gameName;
	@Column(name="PUBLISHER")
	private String publisher;
	
	public Game() {
		super();
	}
	public Game(String publisher, String game){
		super();
		this.publisher = publisher;
		this.gameName = game;
		}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the game
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param game the game to set
	 */
	public void setGameName(String game) {
		this.gameName = game;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String returnGameDetails() {
		return this.publisher + ", " + this.gameName;
	}
}
