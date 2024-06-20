package fr.afpa.employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// instanciez 4 objets de la classe "Employee" (une fois celle-ci implémentée)
		Employee employee1 = new Employee("11ABC22, ", "Sari", "Farah", 1500.50, "1985-02-25" );
		Employee employee2 = new Employee("12ABC23, ", "Atmane", "Sara", 1300.20, "1996-02-05");
		Employee employee3 = new Employee("13ABC24, ", "Laurent", "Patrick", 1800.20, "1996-02-05");
		Employee employee4 = new Employee("14ABC25, ", "Prevoteau", "Jean-Pierre", 2000.0, "1996-02-05");

		System.out.println(employee1);
		 
		// afficher les informations des employés avec System.out.println
		 System.out.println(employee1.toString());
		 System.out.println(employee2.toString());
		 System.out.println(employee3.toString());
		 System.out.println(employee4.toString());
		 
	}
}

