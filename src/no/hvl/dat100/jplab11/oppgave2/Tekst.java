package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {

	// Oppretter en ny objektvariabel for tekst og setter den som protected slik at bilde klassen
	// også kan bruke den.
	protected String tekst;
	
	public Tekst () {
		
	}
	
	// Oppretter to konstruktører på samme måte som i innlegg klassen.
	public Tekst(int id, String bruker, String dato, String tekst) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = 0;
		this.tekst = tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
		this.tekst = tekst;
	}
	
	// Legger til get og set metoder for den nye objektvariabelen.
	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		//Oppdaterer  toString metoden fra Innlegg klassen slik at den nye objektvariabelen er med.
		String s = "TEKST\n" + id + "\n" + bruker + "\n" + dato +"\n" + likes + "\n" + tekst + "\n";
		return s;
	}
	
	
	public String toHTML() {
			
		String s = "\t\t<h2>" + bruker + "@" + dato + " [" + likes + "]<h2>\n" +
				   "\t\t<p>" + tekst + "<p>\n" + 
				   "\t\t<hr>";
		return s;
				
	}
}