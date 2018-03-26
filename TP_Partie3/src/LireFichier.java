import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LireFichier {

	public static void main(String[] args) {

		ArrayList<String> texte = new ArrayList<String>();
		List<String> nom = new ArrayList<String>();
		List<String> plat = new ArrayList<String>();
		List<String> commande = new ArrayList<String>();
		int index1, index2, index3;
		boolean fic = true, nomCommande = true, platCommande = true;

		String fileName = "src/Facture.txt";

		String ligne = null;

		try {

			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((ligne = bufferedReader.readLine()) != null) {

				texte.add(ligne);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Le fichier n'existe pas.");
		} catch (IOException ex) {
			System.out.println("Pas capable de lire le fichier: '" + fileName + "'");
		}

		index1 = texte.indexOf("Plats :");
		index2 = texte.indexOf("Commandes :");
		index3 = texte.indexOf("Fin");

		nom = texte.subList(1, index1);
		plat = texte.subList(index1 + 1, index2);
		commande = texte.subList(index2 + 1, index3);

		Verification verifie = new Verification(nom, plat, commande);

		if (!verifie.verifieFichier()) {

			System.out.println("Le fichier ne respecte pas le format demandé!");
			fic = false;
		} else {
			if (!verifie.verifieNomCommande()) {
				System.out.println("Il y a un/des client(s) dans la commande qui n'est pas dans la liste des clients.");
				nomCommande = false;
			}
			if (!verifie.verifiePlatCommande()) {
				System.out.println("Il y a un/des plats dans la commande qui n'est pas dans la liste des plats.");
				platCommande = false;
			}
		}
		
		CalculerFacture facture = new CalculerFacture(nom, plat, commande);

		if (fic && nomCommande && platCommande) {

			facture.calculer();
		}
	}
}