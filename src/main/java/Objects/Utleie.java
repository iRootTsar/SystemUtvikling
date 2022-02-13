package Objects;

import java.time.LocalDate;

/**
 * Klasse for å definere utleie
 * @author vlads
 *
 */
public class Utleie {

	private Kredittkort kredittkort;
	private String regnr;
	private int kmStand;
	private LocalDate utleieDato;
	private LocalDate returDato;
	
	
	public Utleie(Kredittkort kredittkort, String regnr, int kmStand, LocalDate utleieDato, LocalDate returDato) {
		super();
		this.kredittkort = kredittkort;
		this.regnr = regnr;
		this.kmStand = kmStand;
		this.utleieDato = utleieDato;
		this.returDato = returDato;
	}
	
	public Kredittkort getKredittkort() {
		return kredittkort;
	}
}
