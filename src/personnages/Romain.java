package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		
		assert isInvariantVerified() : "La force d'un Romain doit toujours être positive.";
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int coup) {
		
		assert coup > 0 : "Précondition non respectée : la force du coup doit être positive";
		
		int forceInitiale = force;
		
		force = force - coup;
		if (force < 1) {
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		
		assert force < forceInitiale : "Postcondition non respectée : la force du romain n'a pas diminué";
		
		assert isInvariantVerified() : "La force d'un Romain doit toujours être positive.";
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}
