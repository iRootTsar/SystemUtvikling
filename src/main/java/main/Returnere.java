package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Objects.Bil;
import Objects.Kontor;
import Objects.Reservasjon;
import Objects.Selskap;

/**
 * Klasse for å definere retur av bilen og sending av fakturen
 * @author vlads
 *
 */
public class Returnere {

	/**
	 * metode for å levere inn en bil
	 * @param selskap
	 */
	public void returnere(Selskap selskap) {
		
		
		//Dato for innlevering
		
		LocalDate currDate = LocalDate.now();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Skriv inn telefonnummer: ");
		int tlfNr = sc.nextInt();
		
		List<Reservasjon> alleRes = selskap.getReservasjoner();
		
		Reservasjon res = alleRes.stream()
				.filter(r -> tlfNr == r.getKunde().getTlfnr())
				.findAny()
				.orElse(null);
		
		while(res == null) {
			System.out.println("Finne ikke reservasjon for dette tlf. nummer");
			System.out.println("Tast [ja] for å velge taste nytt numemr eller [nei] for å avbryte og gå til hovudmeny");
			String next = sc.next();
			
			if(next.equals("ja")) {
				System.out.println("Tast in tlf.nr");
				int nextt = sc.nextInt();
				res = alleRes.stream()
						.filter(r -> nextt == r.getKunde().getTlfnr())
						.findAny()
						.orElse(null);
			} else {

				Meny.valgMeny();
			}
		}
		
		
		//kmStand ved innlevering
		System.out.println("Hvor mange km viser km-teller i bilen?");
		int kmStand = sc.nextInt();
		
		//Setter ny kmStand på bil og setter bil som ledig
		Bil bil = res.getBil();
		bil.setKm(kmStand);
		bil.setLedig(true);
		
		//henter returkontor og legger til bil i deres billiste
		
		Kontor returKontor = res.getRetursted();
		returKontor.leggTilBiler(bil);
		
		//Sender regning og fjerner reservasjon
		
		System.out.println("Faktura på " + bil.getPris()*res.getAntDager() + ",- pluss fast retur gebyr " + Reservere.returGebyr + ",- ble nå sendt");
		alleRes.remove(res);
		
		System.out.println("Bilen er nå levert!");
		
		Meny.valgMeny();
		
	}

}
