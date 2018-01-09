package main;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Window extends JFrame {
	private JMenuBar menuBar = new JMenuBar();
	
	// Menus
	private JMenu course = new JMenu("Course");
	private JMenu inscription = new JMenu("Inscription");
	private JMenu partenaires = new JMenu("Partenaires");
	private JMenu aPropos = new JMenu("A Propos");
	
	// Items
	// Course
	private JMenuItem course_btn1 = new JMenuItem("Accueil");
	private JMenuItem course_btn2 = new JMenuItem("Infos");
	private JMenuItem course_btn3 = new JMenuItem("Inscrits");
	
	// Inscription
	private JMenuItem inscription_btn1 = new JMenuItem("S'incrire");
	
	// Partenaires (Sponsors)
	private JMenuItem partenaires_btn1 = new JMenuItem("Consulter");
	
	// A propos
	private JMenuItem aPropos_btn1 = new JMenuItem("?");
	
	public Window(String name){
		this.setTitle(name); // Titre de la fenêtre
		this.setMinimumSize(800,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(new Point(100, 100)); // position fenetre par rapport au coin nord-ouest de l'ecran
		
		// On initialise nos menus
		// Course
		this.course.add(course_btn1);
		this.course.add(course_btn2);
		this.course.add(course_btn3);
		
		// Inscription
		this.inscription.add(inscription_btn1);
		
		// Partenaires (Sponsors)
		this.partenaires.add(partenaires_btn1);
		
		// A propos
		this.aPropos.add(aPropos_btn1);


//		//Ajout d'un séparateur
//		this.course.addSeparator();
		
		
		
//		item2.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent arg0) {
//				System.exit(0);
//			}
//		});
		
		//Ajout des menus dans le bon ordre
		this.menuBar.add(course);
		this.menuBar.add(inscription);
		this.menuBar.add(partenaires);
		this.menuBar.add(aPropos);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}


	private void setMinimumSize(int width, int height) {
		Dimension d = new Dimension(width, height);
		this.setMinimumSize(d);		
	}


	public JMenuItem getCourse_btn1() {
		return course_btn1;
	}


	public JMenuItem getCourse_btn2() {
		return course_btn2;
	}


	public JMenuItem getCourse_btn3() {
		return course_btn3;
	}


	public JMenuItem getInscription_btn1() {
		return inscription_btn1;
	}


	public JMenuItem getPartenaires_btn1() {
		return partenaires_btn1;
	}


	public JMenuItem getaPropos_btn1() {
		return aPropos_btn1;
	}
	
	

}
