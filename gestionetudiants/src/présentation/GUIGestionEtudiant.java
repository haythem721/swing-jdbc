package présentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import metier.Etudiant;
import metier.GestionEtudiants;
import metier.IGestionEtudiants;

public class GUIGestionEtudiant extends JFrame {

	JLabel lnom = new JLabel("Nom:");
	JLabel lprenom = new JLabel("Prenom:");
	JLabel lfiliere = new JLabel("Filiere:");
	JLabel lsexe = new JLabel("Sexe:");
	JLabel lrecherche = new JLabel("Chercher par mot clé:");
	JTextField tnom = new JTextField(10);
	JTextField tprenom = new JTextField(10);
	JTextField trecherche = new JTextField(10);
	JComboBox<String> combofiliere = new JComboBox<String>(new String[] { "Telecom", "Multimédia", "réseau" });
	JRadioButton femme = new JRadioButton("F");
	JRadioButton homme = new JRadioButton("H");
	JButton ajouter = new JButton("Ajouter");
	JButton annuler = new JButton("Annuler");
	JButton rechercher = new JButton("Rechercher");
	JPanel pnom = new JPanel();
	JPanel pprnom = new JPanel();
	JPanel pfiliere = new JPanel();
	JPanel psexe = new JPanel();
	JPanel precherche = new JPanel();
	JPanel pinfo = new JPanel(new GridLayout(2, 2));
	JPanel phaut = new JPanel(new BorderLayout());
	JPanel pbas = new JPanel(new BorderLayout());
    JPanel paction=new JPanel();
	TableModele tm = new TableModele();
	JTable tableau = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tableau);
	IGestionEtudiants gestion=new GestionEtudiants();

	public GUIGestionEtudiant() {
		setTitle("Gestion Etudiants");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		//setLayout(new GridLayout(2, 1));
		pnom.add(lnom);
		pnom.add(tnom);

		pprnom.add(lprenom);
		pprnom.add(tprenom);

		pfiliere.add(lfiliere);
		pfiliere.add(combofiliere);

		ButtonGroup bg = new ButtonGroup();
		bg.add(homme);
		bg.add(femme);
		
		psexe.add(lsexe);
		psexe.add(femme);
		psexe.add(homme);
		
		pinfo.add(pnom);
		pinfo.add(pprnom);
		pinfo.add(pfiliere);
		pinfo.add(psexe);
		pinfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"Informations Etudiants"));
		phaut.add(pinfo,BorderLayout.CENTER);
		
		paction.add(ajouter);
		paction.add(annuler);
		phaut.add(paction,BorderLayout.SOUTH);
		 this.add(phaut,BorderLayout.NORTH);
		 
		 precherche.add(lrecherche);
		 precherche.add(trecherche);
		 precherche.add(rechercher);
		 pbas.add(precherche,BorderLayout.NORTH);
		 pbas.add(jsp,BorderLayout.CENTER);
		 pbas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),"liste des étudiants"));
		 this.add(pbas,BorderLayout.CENTER);
		 
		 annuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tnom.setText("");
				tprenom.setText("");
				bg.clearSelection();
				
			}
		});
		 
		ajouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirmation=0;
				String nom=tnom.getText();
				String prenom=tprenom.getText();
				String sexe=homme.isSelected()?homme.getText():femme.isSelected()?femme.getText():"";
				String filiere=(String)combofiliere.getSelectedItem();
				
				if(nom.equals("")||prenom.equals("")||sexe.equals(""))
					JOptionPane.showMessageDialog(GUIGestionEtudiant.this,"remplir les champs SVP!!!");
				else
				{Etudiant et=new Etudiant(nom, prenom, filiere, sexe);
				if(gestion.listeDesEtudiants().contains(et))
					confirmation=JOptionPane.showConfirmDialog(GUIGestionEtudiant.this, "cet etudiant existe déja, voulez vous l'ajouter","Confirmation",JOptionPane.OK_CANCEL_OPTION);
				 if(confirmation==0)
				  {gestion.ajouterEtudiant(et);
				  tm.charger(gestion.listeDesEtudiants());
				  }
				 else
					 Etudiant.setCpt(Etudiant.getCpt()-1);
				
				}
				
			}
		}); 
		rechercher.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tm.charger(gestion.rechercherPMC(trecherche.getText()));
				
				
			}
		});
		 
		 pack();

	}
	
	public static void main(String[] args) {
		new GUIGestionEtudiant();
	}

}
