package controleurs;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import vues.VueSemiMarathon;
import modeles.ModeleSemimarathon;
import main.Window;;

public class ControleurSemiMarathon extends JPanel implements ActionListener  {
	
	// Action Menu Course
	static public final String ACTION_ACCUEIL = "ACCUEIL";
	static public final String ACTION_INFOS = "INFOS";
	static public final String ACTION_INSCRITS = "INSCRITS";
	
	// Action Menu Inscription
	static public final String ACTION_INSCRIRE = "INSCRIRE";
	
	// Action Menu Partenaires
	static public final String ACTION_PARTENAIRES = "PARTENAIRES";
	
	// Action Menu A Propos
	static public final String ACTION_APROPOS = "APROPOS";
	
	// Action Bouton Effacer Inscription
	static public final String ACTION_RECOMMENCER = "RECOMMANCER";
	
	// Action Bouton Valider Inscription
	static public final String ACTION_VALIDER = "VALIDER";
	
	
	private ModeleSemimarathon modele;
	private VueSemiMarathon vue;
	private Window fenetre;
	
	private JButton btnValider;
	private JButton btnRemiseAZero;
	
	public ControleurSemiMarathon(ModeleSemimarathon modele, VueSemiMarathon vue, Window win){
		this.modele = modele;
		this.vue = vue;
		this.fenetre = win;
		
		// Ecouteurs
		// Menu Course
			// Accueil
		fenetre.getCourse_btn1().setActionCommand(ACTION_ACCUEIL);
		fenetre.getCourse_btn1().addActionListener(this);
			// infos
		fenetre.getCourse_btn2().setActionCommand(ACTION_INFOS);
		fenetre.getCourse_btn2().addActionListener(this);
			// Inscrits
		fenetre.getCourse_btn3().setActionCommand(ACTION_INSCRITS);
		fenetre.getCourse_btn3().addActionListener(this);
		
		// Menu Inscription
		fenetre.getInscription_btn1().setActionCommand(ACTION_INSCRIRE);
		fenetre.getInscription_btn1().addActionListener(this);
		
		// Menu Partenaires
		fenetre.getPartenaires_btn1().setActionCommand(ACTION_PARTENAIRES);
		fenetre.getPartenaires_btn1().addActionListener(this);
		
		// Menu APropos
		fenetre.getaPropos_btn1().setActionCommand(ACTION_APROPOS);
		fenetre.getaPropos_btn1().addActionListener(this);
		
		
		// Boutons Inscription
		btnValider = new JButton ("Valider");
		btnRemiseAZero = new JButton("Recommencer");
		
		//Panel Bouton
		vue.getPnlButton().add(btnValider);
		vue.getPnlButton().add(btnRemiseAZero);
		
		btnValider.setActionCommand(ACTION_VALIDER);
		btnRemiseAZero.setActionCommand(ACTION_RECOMMENCER);
		btnValider.addActionListener(this);
		btnRemiseAZero.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String test = e.getActionCommand();
		
		vue.setInvisibleAll();
		if(test.equals(ACTION_ACCUEIL)){
			vue.getPnlAccueil().setVisible(true);
			vue.getLblAccueilDescription().setText("Accueil");				
		}
		if(test.equals(ACTION_INFOS)){
			vue.getScrollPaneInfos().setPreferredSize(new Dimension(fenetre.getWidth()-20,fenetre.getHeight()-100));
			vue.getScrollPaneReglement().setPreferredSize(new Dimension(fenetre.getWidth()-20,fenetre.getHeight()-100));
			vue.getJtpInfos().setVisible(true);
		}
		if(test.equals(ACTION_INSCRITS)){
			vue.majTabCoureurs();
			vue.getTblInscrits().setVisible(true);
		}
		if(test.equals(ACTION_INSCRIRE)){
			vue.getPnlInscription().setVisible(true);
		}
		if(test.equals(ACTION_PARTENAIRES)){
			vue.getTblPartenaires().setVisible(true);
		}
		if(test.equals(ACTION_VALIDER)){
			vue.ajouterCoureur();
		}
		if(test.equals(ACTION_RECOMMENCER)){
			vue.getPnlInscription().setVisible(true);
			vue.effacerInfos();
		}
		
		
	}
	

}
