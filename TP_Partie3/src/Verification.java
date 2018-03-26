import java.util.ArrayList;
import java.util.List;

public class Verification {

	List<String> nom = new ArrayList<String>();
	List<String> plat = new ArrayList<String>();
	List<String> commande = new ArrayList<String>();

	public Verification(List<String> nom, List<String> plat,
			List<String> commande) {

		this.nom = nom;
		this.plat = plat;
		this.commande = commande;
	}

	public boolean verifieFichier() {

		boolean fichierRespect = false;
		String[] mot = null;

		for (int i = 0; i < commande.size(); i++) {

			mot = commande.get(i).split("\\s+");
		}
		if (mot.length == 3) {
			fichierRespect = true;
		}

		return fichierRespect;
	}

	public boolean verifieNomCommande() {

		List<String> nomCommande = new ArrayList<>();
		boolean verifie = true;

		for (int i = 0; i < commande.size(); i++) {

			nomCommande.add(commande.get(i).split(" ")[0]);
		}

		nomCommande.removeAll(nom);

		if (!nomCommande.isEmpty()) {

			for (int i = 0; i < nomCommande.size(); i++) {

				verifie = false;
			}
		}

		return verifie;

	}

	public boolean verifiePlatCommande() {

		List<String> nomCommande2 = new ArrayList<>();
		List<String> platCommande = new ArrayList<String>();
		boolean verifie = true;

		for (int i = 0; i < commande.size(); i++) {

			nomCommande2.add(commande.get(i).split(" ")[1]);
		}

		for (int i = 0; i < plat.size(); i++) {

			platCommande.add(commande.get(i).split(" ")[1]);
		}

		nomCommande2.removeAll(platCommande);

		if (!nomCommande2.isEmpty()) {

			for (int i = 0; i < nomCommande2.size(); i++) {

				verifie = false;
			}
		}
		return verifie;

	}
}
