package transaction.Dao;

import java.util.List;

import transaction.entities.Compte;

public interface IGestionCompte {
	
	public Compte getCompte(int id);
	public List<Compte> getAllComptes();
	public void virer(Compte c1,Compte c2,double montant);
	

}
