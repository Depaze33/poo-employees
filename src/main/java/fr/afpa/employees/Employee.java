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
	private String birthDay;
	private final int socialRate = 30;

	// compléter les attributs comme présenté dans le PDF
	// Appeler les objet
	// compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String firstName, double salary, String birthDay) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.salary = salary;
		this.birthDay = birthDay;// LocalDate.parse(birthDay);

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

	public String getBirthDay() {
		return birthDay;
	}

	// declare les setters
	public void setRegistrationNumber(String registrationNumber) throws Exception {
		// definir les exeptions
		boolean isRegistrationNumber = checkRegistrationNumber(registrationNumber);

		if (isRegistrationNumber == true) {

			this.registrationNumber = registrationNumber;

		} else {
			throw new Exception("Le paramètre d'entrée n'est pas correctement formaté.");
		}

	}

	public void setLastName(String lastName) throws Exception {
		boolean isLastName = checklastName(lastName);
		if (isLastName == true) {
			this.lastName = lastName;

		} else {
			throw new Exception("Le nom n'est pas correctement rentré");
		}

	}

	public void setFirstName(String firstName) throws Exception {
		boolean isFirstName = checkFirstName(firstName);
		if (isFirstName == true) {

			this.firstName = firstName;
		} else {
			throw new Exception("Le prenom n'est pas correctement rentré");
		}

	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBirthDay(String birthDay) throws Exception {
		boolean isDate = checkBirthDay(birthDay);
		if (isDate == true) {
			this.birthDay = birthDay;
		} else {
			throw new Exception("La date d'n'est pas correctement rentré");
		}

	}

	// implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring

	@Override
	public String toString() {

		return "Employee { "
				+ " \nMatricule " + getRegistrationNumber()
				+ " \nNom " + getLastName()
				+ " \nPrenom " + getFirstName()
				+ " \nSalaire " + getSalary()
				+ " \nDate d'anniversaire " + getBirthDay()
				+ "\nSalaire net " + netSalary()
				+ "\nJours avant prochain anniversaire " + daysBeforeBirthday()
				+ '}';

	}

	// methode pour calcul salire net
	public double netSalary() {

		return this.salary - this.salary * (this.socialRate / 100.0);
	}

	// methode pour trouver le nombre de jour avant le prochain anniversaire
	public long daysBeforeBirthday() {
		LocalDate currentDate = LocalDate.now();
		LocalDate nextBirthday = LocalDate.parse(this.birthDay).withYear(currentDate.getYear());

		if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
			nextBirthday = nextBirthday.plusYears(1);
		}
		return ChronoUnit.DAYS.between(currentDate, nextBirthday);
	}

	/**
	 * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel
	 * correctement formaté ou non
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un matricule, FAUX sinon
	 */
	private boolean checkRegistrationNumber(String inputToCheck) {

		// Vérification de la taille de la chaîne de caractères
		if (inputToCheck.length() != 7) {
			return false;
		}

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isRegistrationNumber = false;

		// Cette première boucle permet de passer en revue TOUS les caractères de la
		// chaîne
		for (int index = 0; index < inputToCheck.length(); index++) {
			// index = longueur de intupToCheck - 1 = 6
			char ch = inputToCheck.charAt(index);
			if (index == 0 || index == 1 || index == 5 || index == 6) {

				// vérification du caractère, s'agit-il d'un chiffre ?
				if (Character.isDigit(ch) == true) {
					isRegistrationNumber = true;
				} else { // attention, ce n'est pas un chiffre
					return false;
				}

			} else { // cas de la position 2, 3 ou 4 -> vérification de letter

				// Quelle opération dois-je faire ?
				if (Character.isLetter(ch)) {
					isRegistrationNumber = true;
				} else {
					return false;
				}
			}
		} // fin du FOR, BRAVO !

		return isRegistrationNumber;
	}

	private boolean checklastName(String inputToCheck) {
		if (inputToCheck.length() > 15 || (inputToCheck.length() < 2)) {
			return false;

		}
		boolean isLastName = false;
		for (int i = 0; i < inputToCheck.length(); i++) {
			char ch = inputToCheck.charAt(i);
			if (Character.isLetter(ch) || ch == '-') {

				isLastName = true;
			} else {
				return false;
			}
		}

		return isLastName;
	}

	private boolean checkFirstName(String inputToCheck) {
		if (inputToCheck.length() > 10 || (inputToCheck.length() < 2)) {
			return false;

		}
		boolean isFirstName = false;
		for (int i = 0; i < inputToCheck.length(); i++) {
			char ch = inputToCheck.charAt(i);
			if (Character.isLetter(ch)) {

				isFirstName = true;
			} else {
				return false;
			}
		}

		return isFirstName;
	}

	private boolean checkBirthDay(String dateToCheck) {
		// Check if the length of the date string is exactly 10
		if (dateToCheck.length() != 10) {
			return false;
		}

		// Check each character of the date string
		for (int index = 0; index < dateToCheck.length(); index++) {
			char ch = dateToCheck.charAt(index);

			// Positions 0-3, 5-6, 8-9 should be digits
			if ((index == 0 || index == 1 || index == 2 || index == 3 ||
					index == 5 || index == 6 || index == 8 || index == 9) && !Character.isDigit(ch)) {
				return false;
			}

			// Positions 4 and 7 should be '-'
			if ((index == 4 || index == 7) && ch != '-') {
				return false;
			}
		}
		return true;
	}
}