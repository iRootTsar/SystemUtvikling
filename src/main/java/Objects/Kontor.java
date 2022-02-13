package Objects;

import java.util.List;
/**
 * Klasse for å definere Kontor
 * @author vlads
 *
 */
public class Kontor {

	private int kontorNr;
	private Adresse adresse;
	private int tlfNr;
	private List<Bil> biler;
	
	public Kontor(int kontorNr, Adresse adresse, int tlfNr, List<Bil> biler) {
		super();
		this.kontorNr = kontorNr;
		this.adresse = adresse;
		this.tlfNr = tlfNr;
		this.biler = biler;
	}
	public int getKontorNr() {
		return kontorNr;
	}
	public void setKontorNr(int kontorNr) {
		this.kontorNr = kontorNr;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public int getTlfNr() {
		return tlfNr;
	}
	public void setTlfNr(int tlfNr) {
		this.tlfNr = tlfNr;
	}
	public List<Bil> getBiler() {
		return biler;
	}
	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}
	/**
	 * metode for å legge til biler
	 */
	public void leggTilBiler(Bil bil) {
		biler.add(bil);
	}
	
}
