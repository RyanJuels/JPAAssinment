/**
 * @author Ryan Juelsgaard - rjuelsgaard
 * CIS175 - Spring 2022
 * Mar 10, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {
	@Id
	@GeneratedValue
	private int id;
	private String buyerName;

	public Buyer() {
		super();
// TODO Auto-generated constructor stub
	}

	public Buyer(int id, String buyerName) {
		super();
		this.id = id;
		this.buyerName = 	buyerName;
	}

	public Buyer(String buyerName) {
		super();
		this.buyerName = buyerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopperName() {
		return buyerName;
	}

	public void setShopperName(String buyerName) {
		this.buyerName = buyerName;
	}

	@Override
	public String toString() {
		return "Buyer [id=" + id + ", buyerName=" + buyerName + "]";
	}
}