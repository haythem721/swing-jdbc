package metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionEtudiants implements IGestionEtudiants {
	private List<Etudiant>liste=new ArrayList<Etudiant>();

	@Override
	public void ajouterEtudiant(Etudiant e) {
		//if(!liste.contains(e))
			 liste.add(e);
				
		
	}

	@Override
	public List<Etudiant> rechercherPMC(String mc) {
		// TODO Auto-generated method stub
		List<Etudiant>l=new ArrayList<Etudiant>();
		for(Etudiant e:liste)
			if(e.getNom().contains(mc))
				l.add(e);
		return l;
	}

	@Override
	public void trierListeEtudiantsParNom() {
		Collections.sort(liste,(x,y)->{return x.getNom().compareTo(y.getNom());});

	}

	@Override
	public List<Etudiant> listeDesEtudiants() {
		// TODO Auto-generated method stub
		return liste;
	}

}
