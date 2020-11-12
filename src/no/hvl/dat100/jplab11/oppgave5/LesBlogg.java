package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.*;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab11/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		
		// oppretter et nytt filobjekt ved hjelp av filnavn og mappestruktur.
		File fil = new File(MAPPE + filnavn);
		// Definerer en blogg objektvariabel.
		Blogg samling;
		
		// Bruker Try-catch for å håndtere FileNotFoundException
		try {
			// Oppretter et scanner objekt.
			Scanner leser = new Scanner(fil);
			// Leser første linje i filen som inneholder antallet innlegg
			String linje = leser.nextLine();
			// parser strengen til int.
			int antallInnlegg = parseInt(linje);
			// Opretter et nytt bloggobjekt med riktig antall element.
			samling = new Blogg(antallInnlegg);
			// Går gjennom en løkke like mange ganger som det er innlegg i filen.
			for (int i = 0; i < antallInnlegg; i++) {
				// Leser infoen inn i forskjellige variabler.
				String type = leser.nextLine();
				int id = parseInt(leser.nextLine());
				String bruker = leser.nextLine();
				String dato = leser.nextLine();
				int likes = parseInt(leser.nextLine());
				String tekst = leser.nextLine();
				System.out.println(type  + " " + TEKST);
				// Sjekker hvilken type innlegg det er og opretter et korresponderende objekt.
				// Legger så det nye objektet til i bloggen.
				if (type.contentEquals(TEKST)) {
					Tekst innlegg = new Tekst(id, bruker, dato, likes, tekst);
					samling.leggTil(innlegg);
					
				}
				if (type.contentEquals(BILDE)) {
					String url = leser.nextLine();
					Bilde innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					samling.leggTil(innlegg);
				}
			}
			// Lukker scanner obkjektet.
			leser.close();
		}
		// Dersom filen ikke finnes
		catch (FileNotFoundException e) {
			// Skriver ut en melding om at filen ikke finnes og opretter et tomt blogg objekt som kan returners.
			System.out.println("Filen som ble forsøkt lest, finnes ikke");
			samling = new Blogg(0);
		}
		//Returnerer bloggen.
		return samling;
	}
}