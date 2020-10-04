package main.java;

import java.util.Stack;

/** classe abstraite � �tendre pour permettre la resolution du compte est bon
 * @author emmanueladam
 * */
abstract class SolutionAbstraite {
	
	/** solution � trouver */
	int but;
	
	/** nombres a utiliser */
	int[] nombres;
	
	/** valeurs libres (valeurs pouvant �tre utilis�e pour le calcul) */
	Stack<Integer> valeursLibres;
	
	/** enchainement des etapes sous forme de chaines de caracteres*/
	StringBuilder etapes;
 
	//constantes pour optimiser la cr�ation de la chaine des �tapes
	static final String SPACE = " ";
	static final String EGAL = " = ";
	static final String SEP = " ; ";
 
	/**
	 *  initialise l'algorithme avec de nouveaux nombres et un nouveau but
	 *
	 * @param _nombres
	 *            nombres � utiliser pour le calcul
	 * @param _but
	 *            nombre � atteindre
	 */
	abstract void init(int[] _nombres, int _but);
 
	/**
	 * reinitialise les variables globales
	 * replace les 6 nombres de base dans la pile valeursLibres et
	 * efface la liste des �tapes
	 */
	abstract void reinit();
 
	/**
	 * fonction de calcul d'une solution par m�thode al�atoire <br>
	 * effectue au plus 5 cycles (pioche de 2 nb, pioche d'1 op)
	 * @return la meilleure solution trouv�e
 	*/
	abstract int calcule();
 
	/**choix au hasard d'un operateur applicable sur nb1 et nb2
	 * @param nb1 premier argument de l'operation
	 * @param nb2 second argument de l'operation
	 * @return nb entre 0 et 3 representant l'operateur dans (+, -, *, /)*/
	abstract Operateur choixOperateurApplicable(int nb1, int nb2);
 
	/**
	 * fonction  qui lance la recherche d'une solution
	 * jusqu'a ce que la solution exacte soit trouvee
	 * ou que le nombre de tests max a �t� atteint
	 * @param nbCalculsMax
	 *            nb max de tests de solution autoris�
	 * @return l'enchainement des etapes menant � la solution ou � la valeur la
	 *         plus proche trouv�e, s�par�es par des ';' le dernier �l�ment de la chaine est la valeur trouv�e
	 */
	abstract  String testDesSols( int nbCalculsMax);
	}
