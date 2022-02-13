package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Objects.Adresse;
import Objects.Bil;
import Objects.Kontor;
import Objects.Kunde;
import Objects.Reservasjon;
import Objects.Selskap;

/**
 * Klasse for å reservere en bil
 * @author vlads
 *
 */
public class Reservere {

	public final static int returGebyr = 250;
	public Reservere(Selskap selskap) {
		
		/**
		 * Taster inn alt info frå kunde
		 */
		System.out.println("Tast in ønsket utleiested");
		
		Scanner in = new Scanner(System.in);
		String utleieSted = in.next();
	
		System.out.println("Tast in ønsket retursted");
		String returSted = in.next();
		
		System.out.println("Tast inn ønsket dato for utleie, på format d/MM/yyyy");
			String date = in.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
			while(LocalDate.now().compareTo(LocalDate.parse(date, formatter)) > 0) {
				System.out.println("Dato du tastet inn er ugyldig prøv igjen på nytt");
				date = in.next();
			}
			LocalDate datoUtleie = LocalDate.parse(date, formatter);
				
		System.out.println("Tast in tid for henting, format 00:00");
		String time = in.next();
		LocalTime t = LocalTime.parse(time);
		
		System.out.println("Tast in antall dager ønsket leige");
		
		int antallDag = in.nextInt();
		
		/**
		 * Reservasjon
		 */
		
		//Resultat vise alle ledige biler for reservering
		
		List<Kontor> alleKontorer = selskap.getKontorer();
		
		Kontor utleieKont = alleKontorer.stream().filter(k->utleieSted.equals(k.getAdresse().getPoststed())).findAny().orElse(null);
		
		Kontor returKont = alleKontorer.stream().filter(k->returSted.equals(k.getAdresse().getPoststed())).findAny().orElse(null);
		
//		System.out.println(utleieKont.getAdresse().getPoststed());
		
		List<Bil> alleBil = utleieKont.getBiler();
				
		List<Bil> tilgjBil = alleBil.stream().filter(b->b.isLedig() == true).collect(Collectors.toList());
		
		/**
		 * Liste av tilgjengelige biler og pris per kategori for gitt antall dager
		 */
		System.out.println("Her er liste av tilgjengelige biler: ");
		
		tilgjBil.stream().forEach(e -> System.out.println(e.toString() + ", dette er pris for valgt periode [" + e.getPris()*antallDag + ",-]"));
		System.out.println("Pluss fast returgebyr på " + returGebyr);
		
		/**
		 * Registere reservasjon
		 */
		System.out.println("Skriv inn regnr for ønsket bil: ");
		in.nextLine();
		String regnr = in.nextLine();
		
		Bil bil = tilgjBil.stream().filter(b -> regnr.equals(b.getRegNr())).findAny().orElse(null);
		
		while(bil == null) {
			System.out.println("Bilen med registreringsnummer [" + regnr + "] finnes ikke eller er ikke ledig, prøv et annet bil?");
			System.out.println("Tast [ja] for å velge annet bil eller [nei] for avbryte reservasjon");
			String next = in.next();
			
			if(next.equals("ja")) {
				System.out.println("Tast in regnr");
				String nextt = in.next();
				bil = tilgjBil.stream().filter(b -> nextt.equals(b.getRegNr())).findAny().orElse(null);
			} else {

				Meny.valgMeny();
			}
		}
		
		System.out.println("Fullføre reservasjon til bil med regNr + " + bil.getRegNr() + " ved å oppgi dine opplysninger");
		
		System.out.println("Skriv inn fornavn: ");
		String fnavn = in.nextLine();
		System.out.println("Skriv inn etternavn: ");
		String enavn = in.nextLine();
		System.out.println("Skriv in tilfnr");
		int tlf = in.nextInt();
		System.out.println("Skriv inn gateadresse: ");
		in.nextLine();
		String gateadresse = in.next();
		System.out.println("Skriv inn postnr: ");
		in.nextLine();
		int postnr = in.nextInt();
		System.out.println("Skriv inn poststed: ");
		in.nextLine();
		String poststed = in.nextLine();
		
		/**
		 * Legge til kudne i reservasjon, reservere bilen ved åssette den til ledig = false, opprette reservasjon til selskapet
		 */
		Kunde k1 = new Kunde(fnavn, enavn, new Adresse(gateadresse, postnr, poststed), tlf);
		
		Reservasjon reservasjon = new Reservasjon(bil, utleieKont, returKont, datoUtleie, t, antallDag, k1, bil.getPris()*antallDag);
		
		reservasjon.reserver(bil);
		
		selskap.leggTilReservasjon(reservasjon);
		
		System.out.println("Reservasjon fullført");
		Meny.valgMeny();
	}
}
