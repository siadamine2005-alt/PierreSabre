package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boisson, int quantiteArgent) {
		super(nom, boisson, quantiteArgent);
	}

	public void donner(Commercant beneficiaire) {
		int argent = (getQuantiteArgent() * 10) / 100;
		System.out.println(parler() + beneficiaire.getNom() + " prend ces " + argent + " sous.");
		perdreArgent(argent);
		beneficiaire.recevoir(argent);
	}

	public void provoquer(Yakuza adversaire) {
		System.out.println(parler() + "Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		int force = 2 * honneur;
		if (force >= adversaire.getReputation()) {
			System.out.println(parler() + "Je t’ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			honneur++;
		} else {
			System.out.println(parler() + "J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			int argent = getQuantiteArgent();
			perdreArgent(argent);
			adversaire.gagner(argent);
		}
	}

}
