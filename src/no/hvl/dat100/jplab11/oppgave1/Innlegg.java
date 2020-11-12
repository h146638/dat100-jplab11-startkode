package no.hvl.dat100.jplab11.oppgave1;

import no.hvl.dat100.jplab11.common.TODO;

public abstract class Innlegg {
	
	// Setter objektvariablene som protected slik at subklasser også kan bruke dem.
	protected int id;
	protected String bruker;
	protected String dato;
	protected int likes;
	
	public Innlegg() {
		
	}
	
	
	
	public Innlegg(int id, String bruker, String dato) {

		// Initsialiserer objektvariablene med de argumentene som er gitt i konstruktøren
		// Likes settes til null siden det ikke er noe tilsvarende argument.
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes  = 0;
				
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		// Initsialiserer objektvariablene med de argumentene som er gitt i konstruktøren
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
		
	}
	
	// Lager get metoder for alle objektvariabler og set metoder for dato og bruker.
	public String getBruker() {
		return bruker;
	}

	public void setBruker(String bruker) {
		this.bruker = bruker;	
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getId() {
		return id;
	}

	public int getLikes() {
		return likes;
	}
	
	// metode for å like et innlegg
	public void doLike () {
		this.likes += 1;
	}
	
	// Metode for å sjekke om et innlegg er likt / har samme id som et annet innlegg.
	public boolean erLik(Innlegg innlegg) {
		
		// oppretter en boolean og setter den i utgangspunktet for false.
		boolean erLik = false;
		
		// Sjekker om objektets ID stemmer med argumentets ID.
		if (this.id == innlegg.getId()) {
			// Dersom de er like oppdateres boolean variabelen til true
			erLik = true;
		}
		// Returnerer til slutt boolean variabelen.
		return erLik;
	}
	
	@Override
	public String toString() {
		//Bygger opp strengen på formatet som kreves ved hjelp av objektvariablenes verdier.
		String s = id + "\n" + bruker + "\n" + dato +"\n" + likes + "\n";
		//returnerer strengen.
		return s;		
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		String s = "\t\t<h2>" + bruker + "@" + dato + " [" + likes + "]<h2>\n";
		
		return s;
				
	}
}