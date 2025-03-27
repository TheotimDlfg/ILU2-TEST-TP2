package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					StringBuilder question1 = new StringBuilder();
					question1.append("Quelle est votre force ?");
					int force = Clavier.entrerEntier(question1.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int forceDruide = -1;
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide " + nomVisiteur);
		question.append("Quelle est votre force ?");
		forceDruide = Clavier.entrerEntier(question.toString());
		int effetPotionMax;
		int effetPotionMin;
		StringBuilder question1 = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		do {
			question1.append("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(question1.toString());
			question2.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(question2.toString());
			if( effetPotionMin > effetPotionMax ) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		}while(effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
