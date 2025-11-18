package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int quantiteArgent;

	public Humain(String nom, String boisson, int quantiteArgent) {
		super();
		this.nom = nom;
		this.boisson = boisson;
		this.quantiteArgent = quantiteArgent;
	}

	public String getNom() {
		return nom;
	}

	public int getQuantiteArgent() {
		return quantiteArgent;
	}

	private String parler() {
		return "(" + nom + ")-";
	}

	private void gagnerArgent(int gain) {
		quantiteArgent += gain;
	}

	private void perdreArgent(int perte) {
		quantiteArgent -= perte;
	}

	public void direBonjour() {
		System.out.println(parler() + "Bonjour ! Je m’appelle  " + nom + " et j’aime boire du " + boisson);
	}

	public void boire() {
		System.out.println(parler() + "Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (quantiteArgent < prix) {
			System.out.println(parler() + " Je n'ai plus que " + quantiteArgent
					+ " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous");
		} else {
			System.out.println(parler() + "J'ai " + quantiteArgent + " sous en poche. Je vais pouvoir m'offrir " + bien
					+ " à " + prix + " sous");
			perdreArgent(prix);
		}
	}

}
