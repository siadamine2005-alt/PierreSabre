package personnages;

public class Samourai extends Humain {

	private String seigneur;

	public Samourai(String seigneur, String nom, String boisson, int quantiteArgent) {
		super(nom, boisson, quantiteArgent);
		this.seigneur = seigneur;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		System.out.println(parler() + "Je suis fier de servir le seigneur " + seigneur);
	}

	public void boire(String boisson) {
		System.out.println(parler() + " Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson + ".");
	}

}
