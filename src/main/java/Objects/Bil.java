package Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse for å definere bil
 * @author vlads
 *
 */
public class Bil {

	private String regNr;
	private String merke;
	private String modell;
	private String farge;
	private BilKategori kat;
	private boolean ledig;
	private int km;
	private int pris;
	
	public Bil(String regNr, String merke, String modell, String farge, BilKategori kat, boolean ledig, int km) {
		super();
		this.regNr = regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.kat = kat;
		this.ledig = ledig;
		this.km = km;
		this.pris = prisPerDag(kat);
	}

	private int prisPerDag(BilKategori kategori) {
		int pris = 0;
		if(kategori == BilKategori.A) {
			pris = 100;
		} else if(kategori == BilKategori.B) {
			pris = 200;
		} else if(kategori == BilKategori.C) {
			pris = 250;
		} else if(kategori == BilKategori.D) {
			pris = 300;
		}
		return pris;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public BilKategori getKat() {
		return kat;
	}

	public void setKat(BilKategori kat) {
		this.kat = kat;
	}

	public boolean isLedig() {
		return ledig;
	}

	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return "regNr[" + regNr + "], merke [" + merke + "], modell[" + modell + "], farge[" + farge + "], kat[" + kat
				+ "], ledig[" + ledig + "], km[" + km + "]";
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}
	
}
