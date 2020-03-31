package présentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.Etudiant;

public class TableModele extends AbstractTableModel {
	
	private List<Etudiant> listeetudiants=new ArrayList<>();
	private String[] titreColonnes= {"id","nom","prenom","filiere","sexe"};
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titreColonnes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listeetudiants.size();
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titreColonnes[column];
	}

	@Override
	public Object getValueAt(int ligne, int colonne) {
		switch(colonne) {
		case 0:return listeetudiants.get(ligne).getId();
		case 1:return listeetudiants.get(ligne).getNom();
		case 2:return listeetudiants.get(ligne).getPrenom();
		case 3:return listeetudiants.get(ligne).getFiliere();
		case 4:return listeetudiants.get(ligne).getSexe();
		
		}
		
		return null;
	}
	
	public void charger(List<Etudiant>l) {
		listeetudiants=l;
		fireTableDataChanged();
	}

}
