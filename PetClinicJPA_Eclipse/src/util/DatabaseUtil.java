package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omg.CORBA.PUBLIC_MEMBER;

import model.Animal;
import model.Appointment;
import model.Medic;

public class DatabaseUtil {
	// This variable will take care of the connection
	public static EntityManagerFactory entityManagerFactory; 
	// This variable will manage the transactions
	public static EntityManager entityManager;
	
	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("PetClinicJPA_Eclipse");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	// ANIMAL CLASS SECTION
	public void saveAnimal(Animal animal) {
		entityManager.persist(animal);
	}
	
	public void removeAnimal (int idAnimal) {
		Animal animal = entityManager.find(Animal.class, idAnimal);
		if (animal != null) entityManager.remove(animal);
	}
	
	// MEDIC CLASS SECTION
	public void saveMedic(Medic medic) {
		entityManager.persist(medic);
	}
	
	public void removeMedic (int idMedic) {
		Medic medic = entityManager.find(Medic.class, idMedic);
		if (medic != null) entityManager.remove(medic);
	}
	
	// APPOINTMENT CLASS SECTION
	public void saveAppointment(Appointment appointment) {
		entityManager.persist(appointment);
	}
	
	public void removeAppointment(int idAppointment) {
		Appointment appointment = entityManager.find(Appointment.class, idAppointment);
		if (appointment != null) entityManager.remove(appointment);
	}
	
	
	public void startTransaction() {
		entityManager.getTransaction().begin();
	}
	
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	public void stopEntityManager() {
		entityManager.close();
	}
	
	// PRINT ANIMALS
	public void printAllAnimalsFromDatabase () {
		List<Animal> animalResults = entityManager.createNativeQuery("SELECT * FROM petshop.animal", Animal.class).getResultList();
		
		for (Animal animal : animalResults) {
			System.out.println("Animal: " + animal.getNameOfAnimal() + " with the ID: " + animal.getIdanimal() + " with the owner " + animal.getNameOfOwner());
		}
	}
	
	public List<Animal> getAllAnimalsFromDatabase() {
		List<Animal> listOfAnimals = entityManager.createNativeQuery("SELECT * FROM petshop.animal", Animal.class).getResultList();
		return listOfAnimals;
	}
	
	// PRINT MEDICS
	public void printAllMedicsFromDatabase () {
		List<Medic> medicResults = entityManager.createNativeQuery("SELECT * FROM petshop.medic", Medic.class).getResultList();
		
		for (Medic medic : medicResults) {
			System.out.println("Medic: " + medic.getNameOfMedic() + " with the ID: " + medic.getIdmedic());
		}
	}
	
	public List<Medic> getAllMedicsFromDatabase() {
		List<Medic> listOfMedics = entityManager.createNativeQuery("SELECT * FROM petshop.medic", Medic.class).getResultList();
		return listOfMedics;
	}
	
	// PRINT APPOINTMENTS
	public void printAllAppointmentsFromDatabase () {
		List<Appointment> appointmentResults = entityManager.createNativeQuery("SELECT * FROM petshop.appointment", Appointment.class).getResultList();
		
		for (Appointment appointment : appointmentResults) {
			System.out.println("Appointment: " + appointment.getAppointmentName() + " with the ID: " + appointment.getIdappointment());
		}
	}
	
	public List<Appointment> getAllAppointmentsFromDatabase() {
		List<Appointment> listOfAppointments = entityManager.createNativeQuery("SELECT * FROM petshop.appointment", Appointment.class).getResultList();
		return listOfAppointments;
	}
	
}
