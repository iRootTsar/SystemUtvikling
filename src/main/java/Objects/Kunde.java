package Objects;

/**
 * Klasse for å definere kunde
 * @author vlads
 *
 */
public class Kunde {

	private String fornavn;
	private String etternavn;
	private Adresse adresse;
	private int tlfnr;
	private Kredittkort kredittkort;

	public Kunde(String fornavn, String etternavn, Adresse adresse, int tlfnr) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.tlfnr = tlfnr;
		this.kredittkort = null;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getTlfnr() {
		return tlfnr;
	}

	public void setTlfnr(int tlfnr) {
		this.tlfnr = tlfnr;
	}

	public void setKredittKort(Kredittkort kort) {
		this.kredittkort = kort;
		
	}

	public Kredittkort getKredittKort() {
		// TODO Auto-generated method stub
		return kredittkort;
	}
	
}
