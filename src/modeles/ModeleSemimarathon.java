package modeles;
import baseDeDonnees.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;

public class ModeleSemimarathon {
	
	private ArrayList<Coureur> tabCoureurs; // Les coureurs
	private ArrayList<Categorie> tabCategories; // Les catégories de coureurs
	private ArrayList<Partenaire> tabPartenaires; // Les sponsors
	private ArrayList<Rue> tabRues; // Les rues parcourues (attention à l'ordre !), permet d'afficher le parcours de la course
	private ArrayList<Tarif> tabTarifs; // Les différents tarifs. Dépendent de la date d'inscription du coureur
	private Semi_Marathon semiMarathon;
	
	public ModeleSemimarathon() {
		tabCoureurs = new ArrayList<Coureur>();
		tabCategories = new ArrayList<Categorie>();
		tabPartenaires = new ArrayList<Partenaire>();
		tabRues = new ArrayList<Rue>();
		tabTarifs = new ArrayList<Tarif>();
		
		semiMarathon = new Semi_Marathon(1997, 40000, "Esplanade du Château de Vincennes", "http://www.marathon.com/semi/2015/fr", "ASO Challenges BP 18292, 135 Issy-les-Moulineaux cedex France", "Parc Floral - Route de la Pyramide - 75012 Paris",0, 0, "04/05/2015", "9h30", "6h00", "9h");
		
		// initialisation de la base de données (Categories, Partenaires, Rues, Tarifs)
		
		// Categories d'ages
		// Vétérans categorie speciale
		tabCategories.add(new Categorie("Vétérans","VE",0,1975));
			// Sous-categorie
		tabCategories.add(new Categorie("Vétérans","V1",1966,1975));
		tabCategories.add(new Categorie("Vétérans","V2",1956,1965));
		tabCategories.add(new Categorie("Vétérans","V3",1946,1955));
		tabCategories.add(new Categorie("Vétérans","V4",0,1945));
		
		tabCategories.add(new Categorie("Seniors","SE",1976,1992));
		tabCategories.add(new Categorie("Espoirs","ES",1993,1995));
		tabCategories.add(new Categorie("Juniors","JU",1996,1997));
		tabCategories.add(new Categorie("Cadets","CA",1998,1999));
		tabCategories.add(new Categorie("Minimes","MI",2000,2001));
		tabCategories.add(new Categorie("Benjamins","BE",2002,2003));
		tabCategories.add(new Categorie("Poussins","PO",2004,2005));
		tabCategories.add(new Categorie("Ecole d'Athletisme","EA",2006,2015));
		
		// Partenaires (Sponsors)
		tabPartenaires.add(new Partenaire("Ville de Paris ", "mailfictif@mail.fr"));
		
		// Rues
		tabRues.add(new Rue("Esplanade du Château de Vincennes", 0));
		tabRues.add(new Rue("Avenue Daumesnil", 1));
		tabRues.add(new Rue("Porte Dorée", 2));
		tabRues.add(new Rue("Boulevard Soult", 3));
		tabRues.add(new Rue("Cours de Vincennes", 4));
		tabRues.add(new Rue("Avenue du Trône", 5));
		tabRues.add(new Rue("Place de la Nation", 6));
		tabRues.add(new Rue("Rue du Faubourg Saint-Antoine", 7));
		tabRues.add(new Rue("Place de la Bastille", 8));
		tabRues.add(new Rue("Rue Saint-Antoine", 9));
		tabRues.add(new Rue("Rue de Rivoli", 10));
		tabRues.add(new Rue("Boulevard Sébastopol", 11));
		tabRues.add(new Rue("Avenue Victoria", 12));
		tabRues.add(new Rue("Place de l'Hôtel de Ville", 13));
		tabRues.add(new Rue("Quai de Gesvres", 14));
		tabRues.add(new Rue("Quai de l'Hôtel de Ville", 15));
		tabRues.add(new Rue("Quai des Célestins", 16));
		tabRues.add(new Rue("Quai Henri IV", 17));
		tabRues.add(new Rue("Voie Mazas", 18));
		tabRues.add(new Rue("Quai de la Râpée", 19));
		tabRues.add(new Rue("Quai de Bercy", 20));
		tabRues.add(new Rue("Pont de Tolbiac", 21));
		tabRues.add(new Rue("Rue Joseph Kessel", 22));
		tabRues.add(new Rue("Rue de Dijon", 23));
		tabRues.add(new Rue("Place de Lachambeaudie", 24));
		tabRues.add(new Rue("Rue de Proudhon", 25));
		tabRues.add(new Rue("Rue des Fonds Verts", 26));
		tabRues.add(new Rue("Rue de Charenton", 27));
		tabRues.add(new Rue("Avenue de la Porte de Charenton", 28));
		tabRues.add(new Rue("Avenue de Gravelle", 29));
		tabRues.add(new Rue("Route de Pesage", 30));
		tabRues.add(new Rue("Route Saint-Hubert", 31));
		tabRues.add(new Rue("Carrefour de Beauté", 32));
		tabRues.add(new Rue("Route de la Pyramide", 33));
		tabRues.add(new Rue("Esplanade du Château de Vincennes", 34));
		
		// Tarifs
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		tabTarifs.add(new Tarif("01/09/2014","20/12/2014",24));
		tabTarifs.add(new Tarif("21/12/2014","20/01/2015",27));
		tabTarifs.add(new Tarif("21/01/2015","10/02/2015",33));
		
		
		
//		tabTarifs.add(new Tarif(dateFormat.format(new Date(2014,9,01)), dateFormat.format(new Date(2014,12,20)), 24));
//		tabTarifs.add(new Tarif(dateFormat.format(new Date(2014,12,21)), dateFormat.format(new Date(2015,01,20)), 27));
//		tabTarifs.add(new Tarif(dateFormat.format(new Date(2015,01,11)), dateFormat.format(new Date(2015,02,10)), 33));
	}

	public ArrayList<Coureur> getTabCoureurs() {
		return tabCoureurs;
	}

	public ArrayList<Categorie> getTabCategories() {
		return tabCategories;
	}

	public ArrayList<Partenaire> getTabPartenaires() {
		return tabPartenaires;
	}

	public ArrayList<Rue> getTabRues() {
		return tabRues;
	}

	public ArrayList<Tarif> getTabTarifs() {
		return tabTarifs;
	}
	
	
}
