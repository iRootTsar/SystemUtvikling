package Objects;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Klasse for å definere reservasjon objekt
 * @author vlads
 *
 */
public class Reservasjon {

	private Kontor utleiested;
	private Kontor retursted;
	private LocalDate utleieDato;
	private LocalTime klokke;
	private int antDager;
	private Kunde kunde;
	private Bil bil;
	private int pris;
	
	public Reservasjon(Bil bil, Kontor utleiested, Kontor retursted, LocalDate utleieDato, LocalTime klokke, int antDager, Kunde kunde, int pris) {
		super();
		this.bil = bil;
		this.utleiested = utleiested;
		this.retursted = retursted;
		this.utleieDato = utleieDato;
		this.klokke = klokke;
		this.antDager = antDager;
		this.kunde = kunde;
		this.pris = pris;
		
		reserver(bil);
	}


	public LocalDate getUtleieDato() {
		return utleieDato;
	}

	public void setUtleieDato(LocalDate utleieDato) {
		this.utleieDato = utleieDato;
	}

	public LocalTime getKlokke() {
		return klokke;
	}

	public void setKlokke(LocalTime klokke) {
		this.klokke = klokke;
	}

	public int getAntDager() {
		return antDager;
	}

	public void setAntDager(int antDager) {
		this.antDager = antDager;
	}

	public Kontor getUtleiested() {
		return utleiested;
	}

	public void setUtleiested(Kontor utleiested) {
		this.utleiested = utleiested;
	}

	public Kontor getRetursted() {
		return retursted;
	}

	public void setRetursted(Kontor retursted) {
		this.retursted = retursted;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	/**
	 * metode for å reservere bil
	 * @param bil
	 */
	public void reserver(Bil bil) {
		LocalDate currDate = LocalDate.now();
		LocalDate sluttDato = utleieDato.plusDays(antDager);
		
		while (currDate.isAfter(utleieDato) && currDate.isBefore(sluttDato)) {
			bil.setLedig(false);
		}
		
	}

	public Bil getBil() {
		// TODO Auto-generated method stub
		return bil;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}
	
	
	
}
