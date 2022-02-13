package Objects;

import java.util.ArrayList;
import java.util.List;
/**
 * Bilparkering til hver kontor
 * @author vlads
 *
 */
public class BilPark {

	
	public static List<Bil> BergenPark(){
		
		/*
		 * Lage biler og legger til i en liste før retur
		 */
		Bil bil1 = new Bil("SV50501", "BMW", "M3", "svart", BilKategori.B, true, 0);
		Bil bil2 = new Bil("BS90105", "Audi", "A4", "blå", BilKategori.A, true, 0);
		Bil bil3 = new Bil("SV31567", "Mercedes", "A53", "hvit", BilKategori.C, true, 0);
		Bil bil4 = new Bil("AS57281", "MiniCooper", "Coop", "rød", BilKategori.D, true, 0);
		
		List<Bil> biler = new ArrayList<>();
		biler.add(bil1);
		biler.add(bil2);
		biler.add(bil3);
		biler.add(bil4);
		
		return biler;
	}
	
	public static List<Bil> OsloPark(){
		
		Bil bil1 = new Bil("SV50501", "BMW", "M3", "svart", BilKategori.B, true, 0);
		Bil bil2 = new Bil("BS90105", "Audi", "A4", "blå", BilKategori.A, true, 0);
		Bil bil3 = new Bil("SV31567", "Mercedes", "A53", "hvit", BilKategori.C, true, 0);
		Bil bil4 = new Bil("AS57281", "MiniCooper", "Coop", "rød", BilKategori.D, true, 0);
		
		List<Bil> biler = new ArrayList<>();
		biler.add(bil1);
		biler.add(bil2);
		biler.add(bil3);
		biler.add(bil4);
		
		return biler;
	}
}
