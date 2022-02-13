package Objects;

/**
 * Klasse for å definere kredittkort
 * @author vlads
 *
 */
public class Kredittkort {

	private long kortNummer;
	
	public Kredittkort(long kortNummer) {
		this.kortNummer = kortNummer;
	}

	public Boolean validereKort() {
		boolean ok = false;
		
		if(String.valueOf(kortNummer).length() == 16) {
			ok = true;
		}
		return ok;
	}

	public void setKortNummer(int nyttKortNummer) {
		this.kortNummer = nyttKortNummer;
	}

}
