package main.java;

import java.util.function.BiFunction;

public enum Operateur {
	ADDITION("+", (a, b) -> (int) a + b, (a, b) -> ((a + b) > 0)),
	SOUSTRACTION("-", (a, b) -> (int) a - b, (a, b) -> ((a - b) > 0)),
	MULTIPLICATION("*", (a, b) -> (int) a * b, (a, b) -> ((a * b) > 0)),
	DIVISION("/", (a, b) -> (int) a / b, (a, b) -> (b != 0 && (a / b) > 0));

    public String signe;
    
    // Fonction prenant 2 nombres entiers et retournant le résultat de l’opération
	public BiFunction<Integer, Integer, Integer> calcul;
	
	// Fonction prenant 2 nombres entiers et retournant vrai si l’opération retournée un nb entier strictement positif
    public BiFunction<Integer, Integer, Boolean> test;
    
    // Constructeur paramétré
	private Operateur(String signe, BiFunction<Integer, Integer, Integer> calcul, BiFunction<Integer, Integer, Boolean> test) {
		this.calcul = calcul;
		this.test = test;
		this.signe = signe;
    }
	// ------------------------- Overrides --------------------------- //
	
	@Override
	public String toString() {
		return this.getSigne();
	}
	
	// ------------------------- Getteurs / Setters --------------------------- //
	
	public String getSigne() {
		return signe;
	}

	public void setSigne(String signe) {
		this.signe = signe;
	}

	public BiFunction<Integer, Integer, Integer> getCalcul() {
		return calcul;
	}

	public void setCalcul(BiFunction<Integer, Integer, Integer> calcul) {
		this.calcul = calcul;
	}

	public BiFunction<Integer, Integer, Boolean> getTest() {
		return test;
	}

	public void setTest(BiFunction<Integer, Integer, Boolean> test) {
		this.test = test;
	}
    
    

}
