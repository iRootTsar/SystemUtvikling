package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Objects.Kredittkort;
import Objects.Kunde;
import Objects.Reservasjon;
import Objects.Selskap;
import Objects.Utleie;

/**
 * Klasse som definerer utleie for en bil
 * @author vlads
 *
 */
public class Utlevering {

	/**
	 * metode for å leie ut bil 
	 * @param selskap
	 */
	public void leieUt(Selskap selskap) {
		
		Scanner in = new Scanner(System.in);
		
		LocalDate currDate = LocalDate.now();
		
		/**
		 * Søke for reservasjon ved hjelp av telefonnummeret
		 */
		System.out.println("Skriv inn telefonnummer: ");
		int tlfNr = in.nextInt();
		
		List<Reservasjon> alleReservasjoner = selskap.getReservasjoner();
		
		Reservasjon res = alleReservasjoner.stream()
				.filter(r -> tlfNr == r.getKunde().getTlfnr())
				.findAny()
				.orElse(null);
		
		while(res == null) {
			System.out.println("Finnes ikke en reservasjon med dette telefonnummeret, prøv igjen");
			
			System.out.println("Tast [ja] for å taste nytt nummer eller [nei] for å gå til hovud meny");
			String next = in.next();
			
			if(next.equals("ja")) {
				System.out.println("Tast in tlfNr");
				int tlfNrNy = in.nextInt();
				res = alleReservasjoner.stream()
						.filter(r -> tlfNrNy == r.getKunde().getTlfnr())
						.findAny()
						.orElse(null);
			} else {
				Meny.valgMeny();
			}
		}
		
		Kunde kunde = res.getKunde();
		
		System.out.println("Skriv inn kredittkortnummer: ");
		long kortNummer = in.nextLong();
		
		Kredittkort kort = new Kredittkort(kortNummer);
		Boolean gyldigKort = kort.validereKort();
		
		while(!gyldigKort) {
			System.out.println("Kortnummer ikke gyldig, må ha en lengde på 16 siffer. Prøv igjen: ");
			int nyttKortNummer = in.nextInt();
			
			kort.setKortNummer(nyttKortNummer);
			gyldigKort = kort.validereKort();
		}
		
		/**
		 * Registrere utleie ved bruk av kredittkortnummer
		 */
		kunde.setKredittKort(kort);
		String regNr = res.getBil().getRegNr();
		int kmStand = res.getBil().getKm();
	
		Utleie utlevering = new Utleie(kunde.getKredittKort(), regNr, kmStand, currDate, res.getUtleieDato().plusDays(res.getAntDager()));
		selskap.leggTilUtleverteBil(utlevering);
		
		System.out.println("Utlevering er registrert, her er bilen din!");
		
		Meny.valgMeny();
		
	}

}
