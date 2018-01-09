package baseDeDonnees;

import java.util.Date;


public class Tarif {
	String dateDebut;
	String dateFin;
	double prix;
	
	public Tarif(String dateDebut, String dateFin, double prix) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public String getPrix() {
		return String.valueOf(prix) + "€";
	}
	
	
}
