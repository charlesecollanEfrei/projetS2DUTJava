package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

import baseDeDonnees.Categorie;

import controleurs.ControleurSemiMarathon;

import vues.VueSemiMarathon;

import modeles.ModeleSemimarathon;

public class MainSemiMarathon {
	
	public static void main(String args[]){
		Window fenetre = new Window("Semi-Marathon");
		
		ModeleSemimarathon modele = new ModeleSemimarathon();		
		VueSemiMarathon vue = new VueSemiMarathon(modele);
		ControleurSemiMarathon controleur = new ControleurSemiMarathon(modele, vue, fenetre);
		
		JPanel pnlPrincipal = new JPanel();
		
		pnlPrincipal.add(vue);
		pnlPrincipal.add(controleur);
		
		fenetre.getContentPane().add(pnlPrincipal);
		fenetre.pack();
		fenetre.setSize(800, 650);
		fenetre.setVisible(true);	
		
		
		//ControleurSemiMarathon controleur = new ControleurSemiMarathon();
		
//		JLabel j = new JLabel();
//		j.setText("Test");
//		j.setVisible(true);
//		
//		fenetre.add(j);
		
	}
}
