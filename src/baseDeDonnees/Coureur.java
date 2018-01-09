package baseDeDonnees;

import java.util.Date;


public class Coureur {
	int numDossard;
	String nom;
	String prenom;
	char sexe;
	int anneeNaissance;
	char categorie;
	String adresse;
	int codePostal;
	String ville;
	String etat;
	String pays;
	String nationalite;
	int tel;
	String mail;
	String club;
	int numLicence;
	boolean licenceCopie;
	String entreprise;
	String typePaiement;
	int numCB;
	int CB_CryptoVisuel;
	int moisFinCB;
	int anneeFinCB;
	boolean paiement;
	boolean certificatMedical;
	Date dateInscr = new Date();
	boolean dossardRetire;
	double tempsReel;
	int position;
	
	public Coureur(int numDossard, String nom, String prenom, char sexe,
			int anneeNaissance, char categorie, String adresse, int codePostal,
			String ville, String etat, String pays, String nationalite,
			int tel, String mail, String club, int numLicence,
			boolean licenceCopie, String entreprise, String typePaiement,
			int numCB, int cB_CryptoVisuel, int moisFinCB, int anneeFinCB,
			boolean paiement, boolean certificatMedical, Date dateInscr,
			boolean dossardRetire, double tempsReel, int position) {
		this.numDossard = numDossard;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.anneeNaissance = anneeNaissance;
		this.categorie = categorie;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.etat = etat;
		this.pays = pays;
		this.nationalite = nationalite;
		this.tel = tel;
		this.mail = mail;
		this.club = club;
		this.numLicence = numLicence;
		this.licenceCopie = licenceCopie;
		this.entreprise = entreprise;
		this.typePaiement = typePaiement;
		this.numCB = numCB;
		CB_CryptoVisuel = cB_CryptoVisuel;
		this.moisFinCB = moisFinCB;
		this.anneeFinCB = anneeFinCB;
		this.paiement = paiement;
		this.certificatMedical = certificatMedical;
		this.dateInscr = dateInscr;
		this.dossardRetire = dossardRetire;
		this.tempsReel = tempsReel;
		this.position = position;
	}

	public String getNumDossard() {
		return String.valueOf(numDossard);
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}	
	
}
