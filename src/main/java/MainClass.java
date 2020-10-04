package main.java;

import java.util.ArrayList;

public class MainClass {
	public static int nbIterationsCalcul = 3000 ;
	public static int but = 987;
	public static int[] nombres = new int[] {2, 4, 6, 8, 15, 75};
	public static Solution sol = new Solution();
	public static int nbThreads = 5;
	
	public static void main(String[] args) {
		
		/* 
		 * Dans une fonction main, lancez 5 résolutions du problème suivant :
		 * trouver 533, avec : [2, 3, 7, 9, 15, 75] avec une limite de 10000 tests par résolution
		 * 
		 * avec MainClass.nombres = [2, 3, 7, 9, 15, 75]
		 * MainClass.nbIterationsCalcul = 10000
		 * et MainClass.but = 533
		 * 
		sol.init(MainClass.nombres, MainClass.but);
		for (int i = 0; i < 5; i++) {
			String etapeRes = sol.testDesSols(MainClass.nbIterationsCalcul);
			System.out.print(etapeRes);
		}
		*/
		
		ArrayList<Thread> threadList = new ArrayList<>();
		ThreadGroup calcThreads = new ThreadGroup("calcThreads");
		for (int i = 0; i < nbThreads; i++) {
			Thread t = new Thread(calcThreads, () -> { // Pour chaque thread :
				Solution sol = new Solution(); // On creer un objet Solution
				sol.init(MainClass.nombres, MainClass.but); // On l'initialise avec les valeurs qu'il faut
				String etapesRes = sol.testDesSols(MainClass.nbIterationsCalcul); // On fait les calculs et on récupere le resultat le plus proche sous forme de String
				if (etapesRes.contains("Succès")) { // Si il y a le mot succès dans la réponse alors on a le bon resultat
					threadList.stream().forEach(Thread::interrupt); // On eteins tout les autres threads
					System.out.println(etapesRes); // On affiche les etapes
				}
			});
			
			// Ajouter le thread a la liste des threads
			threadList.add(t);
		}
		
		// Demarrer tout les threads
		threadList.stream().forEach(Thread::start);
	}
}
