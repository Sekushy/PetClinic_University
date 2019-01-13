package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idanimal;

	private String nameOfAnimal;

	private String nameOfOwner;

	public Animal() {
	}

	public int getIdanimal() {
		return this.idanimal;
	}

	public void setIdanimal(int idanimal) {
		this.idanimal = idanimal;
	}

	public String getNameOfAnimal() {
		return this.nameOfAnimal;
	}

	public void setNameOfAnimal(String nameOfAnimal) {
		this.nameOfAnimal = nameOfAnimal;
	}

	public String getNameOfOwner() {
		return this.nameOfOwner;
	}

	public void setNameOfOwner(String nameOfOwner) {
		this.nameOfOwner = nameOfOwner;
	}

}