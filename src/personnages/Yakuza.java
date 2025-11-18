package personnages;

public class Yakuza extends Humain {

	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boisson, int quantiteArgent, String clan) {
		super(nom, boisson, quantiteArgent);
		this.clan = clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		System.out.println(parler() + "Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		System.out.println(parler() + victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int argent = victime.seFaireExtorquer();
		gagnerArgent(argent);
		reputation++;
		System.out.println(parler() + "J’ai piqué les " + argent + " sous de " + victime.getNom() + ", ce qui me fait "
				+ getQuantiteArgent() + "sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int argent = getQuantiteArgent();
		perdreArgent(argent);
		reputation--;
		System.out.println(parler() + "J’ai perdu mon duel et mes " + argent
				+ " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		return argent;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		System.out.println(parler() + "Ce ronin pensait vraiment battre " + getNom() + "du clan de " + clan + ".");
	}
}
