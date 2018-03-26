package test;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

import main.CalculerFacture;
import main.LireFichier;
import main.Verification;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFacture {
	
	private List<String> nom = new ArrayList<String>();
	private List<String> plat = new ArrayList<String>();
	private List<String> commande = new ArrayList<String>();
	private ArrayList<String> factureFinal = new ArrayList<String>();
	private boolean verifier;
	private LireFichier lireFichier = new LireFichier();
	private Verification verification;
	private CalculerFacture calculerFacture;
	
	@Before
	public void setUp() {
		nom.add("Bob");
		plat.add("Poutine");
		commande.add("Roger Poutine1 -10");
		verification = new Verification(nom, plat, commande);
		calculerFacture = new CalculerFacture(nom, plat, commande);
	}
	
	@After
	public void tearDown(){
		
		nom = null;
		plat = null;
		commande = null;
	}
	
	
	@Test
	public void testerNomClient() {
		
		verifier = verification.verifieNomCommande();
		assertFalse(verifier);
	}
	
	@Test
	public void testerPlat() {		
		verifier = verification.verifiePlatCommande();
		assertTrue(verifier);
	}

}
