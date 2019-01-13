package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the appointment database table.
 * 
 */
@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idappointment;

	private String appointmentName;

	private String dateOfAppointment;

	private int idAnimal;

	private int idMedic;

	private String issueOfAnimal;

	public Appointment() {
	}

	public int getIdappointment() {
		return this.idappointment;
	}

	public void setIdappointment(int idappointment) {
		this.idappointment = idappointment;
	}

	public String getAppointmentName() {
		return this.appointmentName;
	}

	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}

	public String getDateOfAppointment() {
		return this.dateOfAppointment;
	}

	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public int getIdAnimal() {
		return this.idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public int getIdMedic() {
		return this.idMedic;
	}

	public void setIdMedic(int idMedic) {
		this.idMedic = idMedic;
	}

	public String getIssueOfAnimal() {
		return this.issueOfAnimal;
	}

	public void setIssueOfAnimal(String issueOfAnimal) {
		this.issueOfAnimal = issueOfAnimal;
	}

}