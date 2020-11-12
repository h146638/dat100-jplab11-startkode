package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		
		// lager en komplett html streng v.h.a. HTMLPREFIX POSTFIX og toHTML() metoder.
		String s = HTMLPREFIX;
		for (int i = 0; i < this.getAntall(); i++) {
			s += this.innleggtabell[i].toHTML();
		}
		s += HTMLPOSTFIX;
		return s;
	}
}