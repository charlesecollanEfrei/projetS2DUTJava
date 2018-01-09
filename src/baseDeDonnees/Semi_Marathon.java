package baseDeDonnees;

import java.util.Date;


public class Semi_Marathon {
	final static char ville = 'P';
	final static double longueur = 21.1;
	int anneeNaissanceMin;
	int nbreMaxPart;
	String lieuDepArr;
	String url;
	String adrInscr;
	String lieuRemiseDossard;
	int nbreInscrits;
	int nbrePlacesDisponibles;
	
	// Dates
	Date date;
	Date heureDep ;
	Date tempsMax;
	Date heureDossard;
	
	
	public Semi_Marathon(int anneeNaissanceMin, int nbreMaxPart,
			String lieuDepArr, String url, String adrInscr,
			String lieuRemiseDossard, int nbreInscrits,
			int nbrePlacesDisponibles, String date, String heureDep,
			String tempsMax, String heureDossard) {
		this.anneeNaissanceMin = anneeNaissanceMin;
		this.nbreMaxPart = nbreMaxPart;
		this.lieuDepArr = lieuDepArr;
		this.url = url;
		this.adrInscr = adrInscr;
		this.lieuRemiseDossard = lieuRemiseDossard;
		this.nbreInscrits = nbreInscrits;
		this.nbrePlacesDisponibles = nbrePlacesDisponibles;	
	}
	
	
	
	
	
	
//	try {
//		String myDate = "08/03/2015";
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = sdf.parse(myDate);
//		
//		
//		//Date date = new Date(2015,03,8);
//		
//		String heureDep = "10";
//		//SimpleDateFormat sdf = new SimpleDateFormat("hh");
//		Date myDateObject = sdf.parse(heureDep);
//		
//		int tempsMaxMinute = 170;
//		String heureDossard = "";
//	}
//	catch {
//		
//	}
	
	
}
