package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int quantiteArgent;
	protected int nbConnaissance;
	private static final int NBMAX_CONNAISSANCE = 30;
	protected Humain[] memoire = new Humain[NBMAX_CONNAISSANCE];

	public Humain(String nom, String boisson, int quantiteArgent) {
		this.nom = nom;
		this.boisson = boisson;
		this.quantiteArgent = quantiteArgent;
	}

	public int getNbConnaissance() {
		return nbConnaissance;
	}

	public String getNom() {
		return nom;
	}

	public int getQuantiteArgent() {
		return quantiteArgent;
	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ")-" + texte);
	}

	protected void gagnerArgent(int gain) {
		quantiteArgent += gain;
	}

	protected void perdreArgent(int perte) {
		quantiteArgent -= perte;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m’appelle  " + nom + " et j’aime boire du " + boisson);
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (quantiteArgent < prix) {
			parler(" Je n'ai plus que " + quantiteArgent
					+ " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous");
		} else {
			parler("J'ai " + quantiteArgent + " sous en poche. Je vais pouvoir m'offrir " + bien
					+ " à " + prix + " sous");
			perdreArgent(prix);
		}
	}

	public void faireConnaissanceAvec(Humain humain) {
		this.direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}

	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);

	}

	private void memoriser(Humain humain) {
		if (nbConnaissance < NBMAX_CONNAISSANCE) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		} else {
			for (int i = 1; i < NBMAX_CONNAISSANCE; i++) {
				memoire[i - 1] = memoire[i];
			}
			memoire[NBMAX_CONNAISSANCE - 1] = humain;
		}
	}

	public void listerConnaissance() {
		parler(" Je connais beaucoup de monde dont :");
		for (int i = 0; i < nbConnaissance - 1; i++) {
			System.out.print(memoire[i].getNom() + ",");
		}
		System.out.println(memoire[nbConnaissance - 1].getNom());
	}
}
