package fr.afpa.employees;

import java.util.ArrayList;

// import java.time.LocalDate;
// import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");
		// checkRegistrationNumber();

		// instanciez 4 objets de la classe "Employee" (une fois celle-ci implémentée)
		Employee employee1 = new Employee("11ABC22, ", "Sari", "Farah", 1500.50, "1985-02-25");
		Employee employee2 = new Employee("12ABC23, ", "Atmane", "Sara", 1300.20, "1996-02-05");
		Employee employee3 = new Employee("13ABC24, ", "Laurent", "Patrick", 1800.20, "1996-02-05");
		Employee employee4 = new Employee("14ABC25, ", "Prevoteau", "Jean-Pierre", 2000.0, "1996-02-05");

		// System.out.println(employee1);

		// afficher les informations des employés avec System.out.println
		// System.out.println(employee1.toString());
		// System.out.println(employee2.toString());
		// System.out.println(employee3.toString());
		// System.out.println(employee4.toString());
		
			 
		
 

System.out.println("Liste des employées: "); 
// employee.forEach((n) -> print(n)); 
for (Employee employee : employee) {
	System.out.println(employee);
}
		employee.add(employee1);
 		employee.add(employee2);
 		employee.add(employee3);
		employee.add(employee4);
 System.out.println("Les employee sont " + (employee)); 



		// pour gerer une exeption --> TRY..CATCH
		try {
			// Tentative de modification avec un matricule correctement formaté
			employee1.setRegistrationNumber("54AZE88");

			// test des matricules en erreur

			// employee1.setRegistrationNumber("EEAZE88");
			// employee1.setRegistrationNumber("6444433");
			// employee1.setRegistrationNumber("64AZ");
			// employee1.setRegistrationNumber("6");
			// employee1.setRegistrationNumber("");
			// employee1.setRegistrationNumber("987654");

		} catch (Exception e) {
			// CODE UTILISER POUR GERER L'EXEPTION
			System.out.println("Le matricule n'est pas bon");
		}
		try {
			employee1.setFirstName("Cloé");

		} catch (Exception e) {
			System.out.println("Le prénom n'est pas bon");

		}
		try {
			employee1.setBirthDay("199-06-28");

		} catch (Exception e) {
			System.out.println("La date de naissance n'est pas bonne");

		}
	}

	public static ArrayList<Employee> employee = new ArrayList<Employee>();

}