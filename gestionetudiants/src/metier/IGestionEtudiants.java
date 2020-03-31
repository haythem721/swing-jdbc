package metier;

import java.util.List;

public interface IGestionEtudiants {
	
	void ajouterEtudiant (Etudiant e);
	List<Etudiant> rechercherPMC(String mc);
	void trierListeEtudiantsParNom();
	List<Etudiant> listeDesEtudiants();

}
