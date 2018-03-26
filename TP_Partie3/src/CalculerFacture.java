import java.util.ArrayList;
import java.util.List;

public class CalculerFacture {

	private ArrayList<String> facture = new ArrayList<String>();
	private List<String> nom = new ArrayList<String>();
	private List<String> plat = new ArrayList<String>();
	private List<String> commande = new ArrayList<String>();

	public CalculerFacture(List<String> nom2, List<String> plat2,
			List<String> commande2) {

		this.nom = nom2;
		this.plat = plat2;
		this.commande = commande2;
	}

	public void calculer() {

		double montant = 0;
		List<String> nomCommande = new ArrayList<>();
		boolean factureAdded = false;

		for (int i = 0; i < commande.size(); i++) {
			for (int j = 0; j < plat.size(); j++) {

				if (plat.get(j).split(" ")[0]
						.equals(commande.get(i).split(" ")[1])) {

					montant = Double.parseDouble(plat.get(j).split(" ")[1])
							* Double.parseDouble(commande.get(i).split(" ")[2]);

					facture.add(commande.get(i).split(" ")[0] + " "
							+ String.valueOf(montant));
					factureAdded = true;
				}
			}
		}

		if (factureAdded) {

			for (int i = 0; i < facture.size(); i++) {
				for (int j = i + 1; j < facture.size(); j++) {
					if (facture.get(i).split(" ")[0].equals(facture.get(j)
							.split(" ")[0])) {

						double calcul = Double.parseDouble(facture.get(i)
								.split(" ")[1])
								+ Double.parseDouble(facture.get(j).split(" ")[1]);
						facture.set(i, facture.get(i).split(" ")[0] + " "
								+ String.valueOf(calcul));
						facture.remove(facture.get(j));
					}
				}
			}
		}

		for (int i = 0; i < commande.size(); i++) {

			nomCommande.add(commande.get(i).split(" ")[0]);
		}

		nom.removeAll(nomCommande);

		System.out.println("Bienvenue chez Barrette!\nFacture:");
		
		for (int i = 0; i < facture.size(); i++) {
			System.out.println(facture.get(i) + "$");
		}

		for (int i = 0; i < nom.size(); i++) {

			System.out.println(nom.get(i) + " 0.00$");
		}
	}
}
