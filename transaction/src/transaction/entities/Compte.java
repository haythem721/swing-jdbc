package transaction.entities;

public class Compte {
	private int numCompte;
	private double solde;
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(int numCompte, double solde) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + "]";
	}
	

}
