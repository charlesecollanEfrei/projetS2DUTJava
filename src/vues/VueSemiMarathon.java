package vues;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.beans.FeatureDescriptor;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.table.DefaultTableModel;
import baseDeDonnees.*;
import modeles.ModeleSemimarathon;
import main.Window;

public class VueSemiMarathon extends JPanel{

	// Menu Course
	// Accueil
	private JPanel pnlAccueil;
	private JLabel lblAccueilImage;
	private JLabel lblAccueilDescription;

	// Informations
	private JTabbedPane jtpInfos;
	private JScrollPane scrollPaneInfos;
	private JTextArea textAreaInfos;
	private JScrollPane scrollPaneReglement;
	private JTextArea textAreaReglement;
	private JScrollPane scrollPaneParcours;
	private JTable tblParcours;
	private JTable tblTarifs;

	// Inscrits
	private JTable tblInscrits;

	// Menu Inscription
	private JLabel nom;
	private JLabel prenom;
	private JLabel sexe;
	private JLabel anneeNaissance;
	private JLabel adresse;
	private JLabel codePostal;
	private JLabel ville;
	private JLabel etat;
	private JLabel pays;
	private JLabel nationalite;
	private JLabel tel;
	private JLabel mail;
	private JLabel club;
	private JLabel numLicence;
	private JLabel entreprise;
	private JLabel ecole;

	private JLabel typePaiement;
	private JLabel numCB;
	private JLabel CB_CryptoVisuel;
	private JLabel moisFinCB;
	private JLabel anneeFinCB;

	private JTextField tNom;
	private JTextField tPrenom;
	private JTextField tSexe;
	private JTextField tAnneeNaissance;
	private JTextField tAdresse;
	private JTextField tCodePostal;
	private JTextField tVille;
	private JTextField tEtat;
	private JTextField tPays;
	private JTextField tNationalite;
	private JTextField tTel;
	private JTextField tMail;
	private JTextField tClub;
	private JTextField tNumLicence;
	private JTextField tEntreprise;
	private JTextField tEcole;

	private JComboBox cTypePaiement;
	private JTextField tNumCB;
	private JTextField tCB_CryptoVisuel;
	private JTextField tMoisFinCB;
	private JTextField tAnneeFinCB;

	private JPanel pnlInscription;
	private JPanel pnlButton;
	private JPanel pnlInfo;
	private JPanel pnlPaiement;

	// Menu Partenaire
	private JTable tblPartenaires;

	// Menu A Propos
	private JLabel lblAPropos;

	private ModeleSemimarathon modele;

	public VueSemiMarathon(ModeleSemimarathon modele){
		this.modele = modele;

		// Menu Course
		// Accueil
		pnlAccueil = new JPanel();
		lblAccueilImage = new JLabel();
		ImageIcon logo = new ImageIcon("image-semi-marathon.png");
		Image logoImg = logo.getImage();
		Image logoModif = logoImg.getScaledInstance(228, 194, java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(logoModif);
		lblAccueilImage.setIcon(logo);
		lblAccueilImage.setHorizontalAlignment(0);

		lblAccueilDescription = new JLabel();

		pnlAccueil.setLayout(new GridLayout(1,2));
		pnlAccueil.add(lblAccueilImage);
		pnlAccueil.add(lblAccueilDescription);
		lblAccueilImage.setVisible(true);
		lblAccueilDescription.setVisible(true);

		// Informations
		Information infos = new Information();

		textAreaInfos = new JTextArea();		
		scrollPaneInfos = new JScrollPane(textAreaInfos);
		textAreaInfos.setEditable(false);
		textAreaInfos.setLineWrap(true);
		textAreaInfos.setWrapStyleWord(true);
		textAreaInfos.setText(infos.getTextInfos());

		// Reglement
		textAreaReglement = new JTextArea();
		scrollPaneReglement = new JScrollPane(textAreaReglement);
		textAreaReglement.setEditable(false);
		textAreaReglement.setLineWrap(true);
		textAreaReglement.setWrapStyleWord(true);
		textAreaReglement.setText(infos.getTextReglement());

		// Parcours
		DefaultTableModel modelParcours = new DefaultTableModel(new Object[] { "Rue", "Ordre" },0){
			// Permet de mettre les cases de la Jtable en non éditable
			public boolean isCellEditable(int iRowIndex, int iColumnIndex)
		    {
		          return false;
		    }
		};
		modelParcours.addRow(new String[]{"Rue","Ordre de passage"});
		for(Rue r : modele.getTabRues()){
			modelParcours.addRow(new String[]{r.getNom(),r.getNumOrdre()});
		}
		tblParcours = new JTable(modelParcours);
		
		// Tarifs
		DefaultTableModel modelTarifs = new DefaultTableModel(new Object[] { "Date début", "Date fin", "Tarif" },0){
			public boolean isCellEditable(int iRowIndex, int iColumnIndex)
		    {
		          return false;
		    }
		};
		modelTarifs.addRow(new String[]{"Date Début","Date Fin","Prix"});
		for(Tarif t : modele.getTabTarifs()){
			modelTarifs.addRow(new String[]{t.getDateDebut(), t.getDateFin(), t.getPrix()});
		}
		tblTarifs = new JTable(modelTarifs);
		

		jtpInfos = new JTabbedPane();
		jtpInfos.addTab("Informations Générales",scrollPaneInfos);
		jtpInfos.addTab("Règlement",scrollPaneReglement);
		jtpInfos.addTab("Parcours", tblParcours);
		jtpInfos.addTab("Tarifs", tblTarifs);
		
		// Inscrits
			// Initialiser avec la procédure majTabCoureurs

		// Menu Inscription
			//Labels et TextFields
		nom = new JLabel("Nom : ");
		tNom = new JTextField(10);
		prenom = new JLabel("Prénom : ");
		tPrenom = new JTextField(10);
		sexe = new JLabel("Sexe : ");
		tSexe = new JTextField(10);
		anneeNaissance = new JLabel ("Année de naissance : ");
		tAnneeNaissance = new JTextField(10);
		adresse = new JLabel("Adresse : ");
		tAdresse = new JTextField(10);
		codePostal = new JLabel("Code postal : ");
		tCodePostal = new JTextField(10);
		ville = new JLabel("Ville : ");
		tVille = new JTextField(10);
		etat = new JLabel ("Etat : ");
		tEtat = new JTextField(10);
		pays = new JLabel("Pays : ");
		tPays = new JTextField(10);
		nationalite = new JLabel("Nationalité : ");
		tNationalite = new JTextField(10);
		tel = new JLabel("Telephone : ");
		tTel = new JTextField(10);
		mail = new JLabel ("Mail : ");
		tMail = new JTextField(10);
		club = new JLabel("Club : ");
		tClub = new JTextField(10);
		numLicence = new JLabel("N°licence : ");
		tNumLicence = new JTextField(10);
		entreprise = new JLabel ("Entreprise");
		tEntreprise = new JTextField(10);
		ecole = new JLabel ("Ecole");
		tEcole= new JTextField(10);

			//Panels
		pnlInscription = new JPanel();
		pnlButton = new JPanel();
		pnlInfo = new JPanel();
		pnlPaiement = new JPanel();

				//Panel Info
		pnlInfo.setLayout(new GridLayout(8,4));
		pnlInfo.add(nom);
		pnlInfo.add(tNom);
		pnlInfo.add(prenom);
		pnlInfo.add(tPrenom);
		pnlInfo.add(sexe);
		pnlInfo.add(tSexe);
		pnlInfo.add(anneeNaissance);
		pnlInfo.add(tAnneeNaissance);
		pnlInfo.add(adresse);
		pnlInfo.add(tAdresse);
		pnlInfo.add(codePostal);
		pnlInfo.add(tCodePostal);
		pnlInfo.add(ville);
		pnlInfo.add(tVille);
		pnlInfo.add(etat);
		pnlInfo.add(tEtat);
		pnlInfo.add(pays);
		pnlInfo.add(tPays);
		pnlInfo.add(nationalite);
		pnlInfo.add(tNationalite);
		pnlInfo.add(tel);
		pnlInfo.add(tTel);
		pnlInfo.add(mail);
		pnlInfo.add(tMail);
		pnlInfo.add(club);
		pnlInfo.add(tClub);
		pnlInfo.add(numLicence);
		pnlInfo.add(tNumLicence);
		pnlInfo.add(entreprise);
		pnlInfo.add(tEntreprise);
		pnlInfo.add(ecole);
		pnlInfo.add(tEcole);


				//Panel Paiement
		typePaiement = new JLabel("Type Paiement : ");
		cTypePaiement = new JComboBox();	
		numCB = new JLabel("Numéro de CB : ");
		tNumCB = new JTextField(10);
		moisFinCB = new JLabel("Mois Fin : ");
		tMoisFinCB = new JTextField(10);
		anneeFinCB = new JLabel("Année Fin : ");
		tAnneeFinCB = new JTextField(10);
		CB_CryptoVisuel = new JLabel("Cryptogramme : ");
		tCB_CryptoVisuel = new JTextField(10);

		cTypePaiement.setPreferredSize(new Dimension(100, 20));
		cTypePaiement.addItem("Visa");
		cTypePaiement.addItem("MasterCard");

		pnlPaiement.setLayout(new GridLayout(8,4));
		pnlPaiement.add(typePaiement);
		pnlPaiement.add(cTypePaiement);
		pnlPaiement.add(numCB);
		pnlPaiement.add(tNumCB);
		pnlPaiement.add(moisFinCB);
		pnlPaiement.add(tMoisFinCB);
		pnlPaiement.add(anneeFinCB);
		pnlPaiement.add(tAnneeFinCB);
		pnlPaiement.add(CB_CryptoVisuel);
		pnlPaiement.add(tCB_CryptoVisuel);

		//Ajout des sous-Panel dans le Panel Inscription
		pnlInscription.setLayout(new BorderLayout());
		pnlInscription.add(pnlInfo,BorderLayout.NORTH);
		pnlInscription.add(pnlPaiement,BorderLayout.CENTER);
		pnlInscription.add(pnlButton,BorderLayout.SOUTH);

		// Menu Partenaires
		DefaultTableModel modelPartenaires = new DefaultTableModel(0, 2){
			public boolean isCellEditable(int iRowIndex, int iColumnIndex)
		    {
		          return false;
		    }
		};
		modelPartenaires.addRow(new String[]{"colonne1","colonne2"});
		tblPartenaires = new JTable(modelPartenaires);

		// Menu A Propos
		lblAPropos = new JLabel();

		// On cache les composants
		majTabCoureurs();
		this.setInvisibleAll();

		// Ajout des composants à la vue
		this.add(pnlAccueil);
		this.add(jtpInfos);
		this.add(pnlInscription);
		this.add(tblPartenaires);
		this.add(lblAPropos);

	}

	public void setInvisibleAll(){
		pnlAccueil.setVisible(false);
		jtpInfos.setVisible(false);
		pnlInscription.setVisible(false);
		tblInscrits.setVisible(false);
		tblPartenaires.setVisible(false);
		lblAPropos.setVisible(false);
	}

	public void effacerInfos(){
		for(Component c : pnlInfo.getComponents()){
			if(c instanceof JTextField){
				((JTextField)c).setText("");
			}
		}

		for(Component c : pnlPaiement.getComponents()){
			if(c instanceof JTextField){
				((JTextField)c).setText("");
			}
		}
	}	

	public void ajouterCoureur(){
		char categorieAuto = 'c';
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String dateInscr = dateFormat.format(cal.getTime());
		System.out.println(dateFormat.format(cal.getTime()));
		

//		Coureur c = new Coureur(1, tNom.getText(), tPrenom.getText(), tSexe.getText().charAt(0), Integer.parseInt(tAnneeNaissance.getText()),
//				categorieAuto, tAdresse.getText(), Integer.parseInt(tCodePostal.getText()), tVille.getText(), "", tPays.getText(),
//				tNationalite.getText(), Integer.parseInt(tTel.getText()), tMail.getText(), tClub.getText(), Integer.parseInt(tNumLicence.getText()),
//				false, tEntreprise.getText(), cTypePaiement.getSelectedItem().toString(), Integer.parseInt(tNumCB.getText()),
//				Integer.parseInt(tCB_CryptoVisuel.getText()), Integer.parseInt(tMoisFinCB.getText()), Integer.parseInt(tAnneeFinCB.getText()), true, false, dateInscr,
//				false, 0.0, 0);

//		modele.getTabCoureurs().add(c);

	}

	public void majTabCoureurs(){
		DefaultTableModel modelInscrits = new DefaultTableModel(0, 3);
		modelInscrits.addRow(new String[]{"N°","Nom","Prenom"});
		for(Coureur c : modele.getTabCoureurs()){
			modelInscrits.addRow(new String[]{c.getNumDossard(),c.getNom(),c.getPrenom()});
		}
		tblInscrits = new JTable(modelInscrits);
		tblInscrits.setVisible(false);
		this.add(tblInscrits);

	}

	public JPanel getPnlAccueil() {
		return pnlAccueil;
	}

	public JLabel getLblAccueilImage() {
		return lblAccueilImage;
	}

	public JLabel getLblAccueilDescription() {
		return lblAccueilDescription;
	}

	public JPanel getPnlInscription() {
		return pnlInscription;
	}

	public JTable getTblInscrits() {
		return tblInscrits;
	}

	public JTable getTblPartenaires() {
		return tblPartenaires;
	}

	public JLabel getLblAPropos() {
		return lblAPropos;
	}
	public JTabbedPane getJtpInfos() {
		return jtpInfos;
	}

	public JTable getTblParcours() {
		return tblParcours;
	}
	public JScrollPane getScrollPaneInfos(){
		return scrollPaneInfos;
	}
	public JScrollPane getScrollPaneReglement(){
		return scrollPaneReglement;
	}
	public JScrollPane getScrollPaneParcours(){
		return scrollPaneParcours;
	}

	public JPanel getPnlButton() {
		return pnlButton;
	}
}
