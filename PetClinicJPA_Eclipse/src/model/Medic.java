package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medic database table.
 * 
 */
@Entity
@NamedQuery(name="Medic.findAll", query="SELECT m FROM Medic m")
public class Medic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idmedic;

	private String nameOfMedic;

	public Medic() {
	}

	public int getIdmedic() {
		return this.idmedic;
	}

	public void setIdmedic(int idmedic) {
		this.idmedic = idmedic;
	}

	public String getNameOfMedic() {
		return this.nameOfMedic;
	}

	public void setNameOfMedic(String nameOfMedic) {
		this.nameOfMedic = nameOfMedic;
	}

}