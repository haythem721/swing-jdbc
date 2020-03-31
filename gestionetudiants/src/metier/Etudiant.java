package metier;

public class Etudiant {
	private int id;
	private String nom,prenom,filiere,sexe;
	private static int cpt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Etudiant(int id, String nom, String prenom, String filiere, String sexe) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.sexe = sexe;
	}
	public Etudiant(String nom, String prenom, String filiere, String sexe) {
		id=++cpt;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.sexe = sexe;
	}
	
	
	
	public static int getCpt() {
		return cpt;
	}
	public static void setCpt(int cpt) {
		Etudiant.cpt = cpt;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", filiere=" + filiere + ", sexe=" + sexe
				+ "]";
	}
	

}
