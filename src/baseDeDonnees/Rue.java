package baseDeDonnees;

public class Rue {
	String nom;
	int numOrdre;
	
	public Rue(String nom, int numOrdre) {
		this.nom = nom;
		this.numOrdre = numOrdre;
	}

	public String getNom() {
		return nom;
	}

	public String getNumOrdre() {
		String numString = Integer.toString(numOrdre);
		return numString;
	}
	
	
	
	

}
