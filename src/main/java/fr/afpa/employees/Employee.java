package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee {
	/**
	 * Matricule de l'employé
	 */
	// Definir les attribut
	private String registrationNumber;
	private String lastName;
	private String firstName;
	private double salary;
	private LocalDate birthDay;
	private final int socialRate = 30;

	// compléter les attributs comme présenté dans le PDF
	// Appeler les objet
	// compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDay) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthDay = LocalDate.parse(birthDay);

	}

	// implémenter les setters et getters de la classe (permet d'accéder aux
	// attributs privés)
	// decalare les getters
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	// declare les setters
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	// implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee { "
				+ " \nMatricule " + getRegistrationNumber()
				+ " \nNom " + getLastName()
				+ " \nPrenom " + getFirstName()
				+ " \nSalaire " + getSalary()
				+ " \nDate d'anniversaire " + getBirthDay()
				+ "\nSalaire net " + netSalary()
				+ '}';

	}

	// methode pour calcul salire net
	public double netSalary() {
		
		return this.salary - this.salary * (this.socialRate/100.0);
	}
	public long  daysBeforeBirthday() {
		LocalDate currentDate = LocalDate.now();
		newDate = (LocalDate.now() - birthDay)
		return ChronoUnit.DAYS.between(LocalDate.now(), birthDay-LocalDate.now());  ;
	}
}
