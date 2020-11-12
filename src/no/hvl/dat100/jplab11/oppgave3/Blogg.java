package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// Oppretter objektvariabler.
	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	// definerer to konstruktører for klassen, en med spesifisert lengde og en uten.
	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	// Definerer en metode for å finne antall element i samlingen av innlegg.
	public int getAntall() {
		// Returnerer nesteledig variabelen da den tilsvarer antallet element.
		return nesteledig;
	}
	
	// Definerer en get metode for innleggtabellen.
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	// Definerer en metode for å finne indeksen til et innlegg.
	public int finnInnlegg(Innlegg innlegg) {
		// Starter med å sette indeksen til -1, siden det er verdien som skal returneres dersom
		// innlegget ikke er med i innleggtabellen.
		int indeks = -1;
		
		// kjører en løkke som går gjennom alle elementene i tabellen som peker på et objekt.
		for (int i = 0; i < nesteledig; i++) {
			
			// Dersom innlegget har samme id som innlegget som det letes etter så endres
			// indeksvariabelen til innleggets indeks i samlingen.
			if (innleggtabell[i].erLik(innlegg)) {
				indeks = i;
			}
		}
		// Returnerer til slutt indeksen.
		return indeks;
	}

	// Definerer en metode som sjekker om et innlegg finnes i samlingen og returnerer en boolean.
	public boolean finnes(Innlegg innlegg) {
		// antar først at innlegget ikke finnes i listen og setter boolean til false
		boolean finnes = false;
		
		// går gjennom alle element i samlingen som peker på et objekt og dersom innlegget er likt
		// så oppdateres boolean til true
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				finnes = true;
			}
		}
		// Returnerer til slutt boolean.
		return finnes;
	}
	
	// Definerer en metode som sjekker om det er plass til flere element i samlingen.
	public boolean ledigPlass() {
		// Starter med å sette boolean til false.
		boolean ledigPlass = false;
		
		// dersom neste ledig er mindre enn samlingens totale lengde så er det plass
		if (nesteledig < innleggtabell.length) {
			// Opdaterer boolean til true
			ledigPlass = true;
		}
		// returnerer til slutt boolean.
		return ledigPlass;
	}
	
	// Definerer en metode som legger til et element i samlingen og returnerer en boolean.
	public boolean leggTil(Innlegg innlegg) {
		
		// starter med å sette en boolean til false
		boolean lagtTil = false;
		
		// dersom det ikke finnes it likt innlegg, og det er ledig plass.
		if (!finnes(innlegg) && ledigPlass()) {
			
			// Setter neste element til å peke på innsatt innlegg.
			innleggtabell[nesteledig] = innlegg;
			// Oppdaterer boolean til true
			lagtTil = true;
			// Inkrementerer neste ledig.
			nesteledig += 1;
		}
		// returnerer boolean.
		return lagtTil;
	}
	
	// Definerer en metode toString som lager en streng med all innformasjon.
	public String toString() {
		// Starter med å legge til samlingens lengde.
		String s = nesteledig + "\n";
		
		// Går så igjennom alle element som peker på et objekt og skriver dem med toString metoden
		// i de forskjellige klassene, og legger dem til strengen.
		for (int i = 0; i < nesteledig; i++) {
			s += innleggtabell[i].toString();
		}
		// Returnerer strengen.
		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		// Finner ny lengde ved å doble gammel lengde
		int nyLengde = innleggtabell.length*2;
		// Lager en ny tabell med ny lengde
		Innlegg[] utvidetTabell = new Innlegg[nyLengde];
		// Går gjennom alle elementer i den gamle tabellen og flytter dem over i den nye
		for (int i = 0; i < nesteledig; i++) {
			utvidetTabell[i] = innleggtabell[i];
		}
		// Oppdaterer objektvariabelen til den nye tabellen.
		innleggtabell = utvidetTabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		// Lager en boolean som starter som falsk
		boolean lagtTil = false;
		// Sjekker om innlegget er i tabellen fra før og om det er ledig plass
		if (!finnes(innlegg) && ledigPlass()) {
			// Dersom det er plass legges innlegget til listen, booleanen endres til true og nesteledig inkrementeres.
			innleggtabell[nesteledig] = innlegg;
			lagtTil = true;
			nesteledig += 1;
		}
		// Hvis innlegget finnes i tabellen, eller dersom det ikke er ledig plass så sjekker vi kun om innlegget finnes i tabellen fra før.
		else if (!finnes(innlegg)) {
			// Dersom innlegget ikke finnes i listen utvider vi tabellen.
			utvid();
			// sjekker så på nytt om det er ledig plass og om innlegget allerede er i tabellen
			if 	(!finnes(innlegg) && ledigPlass()) {
				// Dersom det er ledig plass og innlegget ikke fins fra før, legges det til i listen, boolean endres til true og neste ledig inkrementeres.
				innleggtabell[nesteledig] = innlegg;
				lagtTil = true;
				nesteledig += 1;
			}
		}
		// returnerer boolean
		return lagtTil;
	}
	
	public boolean slett(Innlegg innlegg) {
		// Oppretter en boolean med verdien false
		boolean slettet = false;
		// finner indeksen til innlegget.
		int indeks = finnInnlegg(innlegg);
		// Oppretter en teller
		int teller = 0;
		// Dersom indeksten er større eller lik 0 og innlegget finnes i tabellen
		if (indeks >= 0 && finnes(innlegg)) {
			// Oppretter en ny tabell
			Innlegg[] nySamling = new Innlegg[innleggtabell.length];
			// Går gjennom alle elementer i den gamle tabellen
			for (int i = 0; i < nesteledig; i++) {
				// Dersom indeksen ikke stemmer med innlegget som skal slettes sin indeks så kopieres innlegget over i den nye listen og telleren inkrementeres.
				if (i != indeks) {
					nySamling[teller] = innleggtabell[i];
					teller++;
				}
			}
			// Oppdaterer objektvariabelen til den nye listen og trekker fra en fra neste ledig siden et innlegg har blitt slettet, oppdaterer boolean til true
			innleggtabell = nySamling;
			nesteledig--;
			slettet = true;
		}
		// Returnerer boolean.
		return slettet;
	}
	
	public int[] search(String keyword) {
		// Lager en ny liste med lengde lik tabbelens lengde
		int[] indekser = new int[innleggtabell.length];
		// Lager en variabel som holder styr på neste ledige plass.
		int nesteLedigeInt = 0;
		// Går gjennom alle elementene i tabellen.
		for (int i = 0; i < nesteledig; i++) {
			// oppretter en streng med all infoen til objektet.
			String s = innleggtabell[i].toString();
			// Splitter strengen slik at infoen er separert.
			String[] tabell = s.split("\n");
			// Sjekker om 5. elemetet i den splittede strengen (som inneholder teksten) inneholder keyword.
			if (tabell[5].contains(keyword)) {
				// legger ii så fall til indeksen i listen over indekser og inkremeterer nesteLedigeInt.
				indekser[nesteLedigeInt] = i;
				nesteLedigeInt++;
			}
		}
		// Dersom listen inneholder et element eller flere
		if (nesteLedigeInt > 0) {
			// Oppretter en ny liste med like mange element som det er indekser.
			int[] indeksListe = new int[nesteLedigeInt];
			// Legger til indeksene i den nye tabellen
			for (int i = 0; i < nesteLedigeInt; i++) {
				indeksListe[i] = indekser[i];
			}
			// Oppdaterer indeks variabelen med den oppdaterte listen
			indekser = indeksListe;
		}
		// Returnerer listen med indekser.
		return indekser;

	}
}