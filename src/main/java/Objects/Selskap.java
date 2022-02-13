package Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse for å definere selskap
 * @author vlads
 *
 */
public class Selskap {

	private String navn;
	private int tlfnr;
	private Adresse firmAdresse;
	private List<Kontor> kontorer;
	private List<Reservasjon> reservasjoner;
	private List<Utleie> utlevering;
	
	public Selskap(String navn, int tlfnr, Adresse firmAdresse) {
		this.navn = navn;
		this.tlfnr = tlfnr;
		this.firmAdresse = firmAdresse;
		this.kontorer = new ArrayList<Kontor>();
		this.reservasjoner = new ArrayList<Reservasjon>();
		this.utlevering = new ArrayList<Utleie>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTlfnr() {
		return tlfnr;
	}

	public void setTlfnr(int tlfnr) {
		this.tlfnr = tlfnr;
	}

	public Adresse getFirmAdresse() {
		return firmAdresse;
	}

	public void setFirmAdresse(Adresse firmAdresse) {
		this.firmAdresse = firmAdresse;
	}

	public List<Kontor> getKontorer() {
		return this.kontorer;
	}

	public void setKontorer(List<Kontor> kontorer) {
		this.kontorer = kontorer;
	}

	
	public List<Reservasjon> getReservasjoner() {
		return reservasjoner;
	}

	public void setReservasjoner(List<Reservasjon> reservasjoner) {
		this.reservasjoner = reservasjoner;
	}
	
	public void leggTilReservasjon(Reservasjon reservasjon) {
		reservasjoner.add(reservasjon);
	}

	public void leggTilUtleverteBil(Utleie utleveringen) {
		utlevering.add(utleveringen);
		
	}

}
