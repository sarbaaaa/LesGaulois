package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
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
	
	public void sEquiper(Equipement equipement) {
	    switch (nbEquipement) {
	        case 2:
	            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
	            break;
	        case 1:
	            if (equipements[0] == equipement) {
	                System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
	            } else {
	                ajouterEquipement(equipement);
	            }
	            break;
	        case 0:
	            ajouterEquipement(equipement);
	            break;
	    }
	}

	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	    System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
}
