package main.java;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Solution extends SolutionAbstraite {
	int but;
	int[] nombre;
	Stack<Integer> valeursLibres;
	StringBuilder etapes;
	
	public void init(int[] _nombres, int _but) {
		this.setNombre(_nombres);
		this.setBut(_but);
		this.setEtapes(new StringBuilder());
		this.setValeursLibres(new Stack<Integer>());
		this.initValeursLibres();
	}
	
	public void reinit() {
		// Efface la liste des etapes
		this.getEtapes().setLength(0);
		
		// Reinitialise les valeurs libres
		this.initValeursLibres();
	}
	
	// Methode privée qui copie les nombres dans la Stack valeursLibres
	private void initValeursLibres() {
		this.getValeursLibres().clear();
		for(int n : this.getNombre()) 
			this.getValeursLibres().add(n);
	}
	
	public int calcule() {
		Random rand = new Random();
		int a;
		int b;
		
		// Valeur de base
		int resultat = 0;
		Operateur op;
		
		for (int i = 0; i < 5; i++) {
			//Choix de deux nombres aléatoires dans la liste
			a = this.getValeursLibres().size() > 0 ? this.getValeursLibres().remove(rand.nextInt(this.getValeursLibres().size())) : 0;
			b = this.getValeursLibres().size() > 0 ? this.getValeursLibres().remove(rand.nextInt(this.getValeursLibres().size())) : 0;
			
			// Choix de l'operateur
			op = this.choixOperateurApplicable(a, b);
			
			// On execute le calcul
			resultat = op.calcul.apply(a, b);
			
			// Ajout dans l'historique des calculs
			this.getEtapes().append(a).append(SPACE).append(op).append(SPACE).append(b).append(EGAL).append(resultat).append('\n'	);
			
			// On ajoute le resultat dans la Stack valeursLibres
			this.getValeursLibres().add(resultat);
			
			// Permet d'arreter de faire des calculs inutiles
			if(resultat == this.getBut())
				break;
		}
		
		return resultat;
	}
	
    Operateur choixOperateurApplicable(int nb1, int nb2) {
    	
    	// ArrayList d'Operateurs
        ArrayList<Operateur> listeOp = new ArrayList<Operateur>();
        
        // Pour chaque operateur de l'Enum
        for (Operateur op : Operateur.values()) {
        	
        	// Si l'operateur est viable pour l'operation nb1 (op) nb2
            if (op.test.apply(nb1, nb2)) {
            	
            	// On l'ajoute a la liste des operateurs viables
                listeOp.add(op);
            }
        }
        
        // On choisit un operateur aleatoirement parmis les operateurs viables
        int randIndex = new Random().nextInt(listeOp.size());
        return listeOp.get(randIndex);
    }
    
    public String testDesSols(int nbCalculsMax) {
    	int nbCalculs;
    	int calc;
    	Integer procheBut = null; // Integer pour pouvoir mettre la reference a null
    	
    	StringBuilder resolutionLocal = new StringBuilder();
    	
    	// String temporaire pour stocker les etapes de calculs
    	String resolvTemp = "";
    	
    	resolutionLocal.append("\nListe des nombres initiaux : ").append(this.getNombreString()).append('\n');
    	resolutionLocal.append("Nombre a trouver : ").append(this.getBut()).append("\n\n");
    	
    	for(nbCalculs = 0; nbCalculs < nbCalculsMax; nbCalculs++) {
    		calc = this.calcule(); // On effectue le calcul
    		if(this.getBut() == calc) { // Si on a le bon resultat
    			procheBut = calc; // Le nombre le plus proche du but est egal au but (litteralement)
				resolvTemp = this.getEtapes().toString(); // On ecrase les anciennes etapes et on mets les nouvelles
    			break;
    		} else { // Si le nombre est pas 
    			if (null == procheBut) {
    				resolvTemp = this.getEtapes().toString(); // On ecrase les anciennes etapes et on mets les nouvelles
    				procheBut = calc; // Initialise procheBut
    			}
    			
    			// Si la difference entre le calcul actuel et la valeur trouvé la plus proche du but est suppérieur
    			// A la difference entre le nombre le plus proche du but et du but :
    			if (Math.abs(calc - this.getBut()) < Math.abs(procheBut - this.getBut())) {
    				resolvTemp = this.getEtapes().toString(); // On ecrase les anciennes etapes et on mets les nouvelles
                    		procheBut = calc; // On actualise la valeur la plus proche
                	}
    		}
    		
    		this.reinit(); // On reinitialise la Stack de nombres et le StringBuilder d'etapes
    	}
    	
    	resolutionLocal.append(resolvTemp); // A la fin on mets les etapes menant au resultat trouvé dans le SB.
    	
    	if (nbCalculs != nbCalculsMax) // Si on a trouvé le bon resultat
    		resolutionLocal.append("\nSuccès ! Nombre ").append(this.getBut()).append(" trouvé en ").append(nbCalculs).append(" iterations.");
    	else // Sinon
    		resolutionLocal.append("\nNombre le plus proche trouvé est le : ").append(procheBut).append(" trouvé en ").append(nbCalculs).append(" iterations.\n");
    	
    	return resolutionLocal.toString();
    }
	// ------------------------- Getteurs / Setters --------------------------- //
	
	public int getBut() {
		return but;
	}

	public void setBut(int but) {
		this.but = but;
	}

	public int[] getNombre() {
		return nombre;
	}
	
	// Pour l'affichage
	public String getNombreString() {
		StringBuilder sb = new StringBuilder();
		for(int n : this.getNombre())
			sb.append(n).append(SPACE);
		
		return sb.toString();
	}

	public void setNombre(int[] nombre) {
		this.nombre = nombre;
	}

	public Stack<Integer> getValeursLibres() {
		return valeursLibres;
	}

	public void setValeursLibres(Stack<Integer> valeursLibres) {
		this.valeursLibres = valeursLibres;
	}

	public StringBuilder getEtapes() {
		return etapes;
	}

	public void setEtapes(StringBuilder etapes) {
		this.etapes = etapes;
	}
}
