package personnages;

public class Druide {
	private String nom;
	private int force;

	public Druide(String nom, int force) {
		this.force = force;
		this.nom = nom;
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		// TODO
	}

	public void booster(Gaulois gaulois) {
		// TODO
	}

	public String getNom() {
		return nom;
	}
}
