package main;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Objects.Adresse;
import Objects.Bil;
import Objects.BilKategori;
import Objects.BilPark;
import Objects.Kontor;
import Objects.Kunde;
import Objects.Reservasjon;

/**
 * Test klasse for logikk
 * @author vlads
 *
 */
public class Test {

	@org.junit.Test
	public void erBilReservert() {
		Bil bil = new Bil("SV50501", "BMW", "M3", "svart", BilKategori.B, false, 0);
		Kunde kunde = new Kunde("Vlad", "Civilgin", new Adresse("Mindeveien 91", 5073, "Bergen"), 48642470);
		Kontor kontorBergen = new Kontor(1, new Adresse("Olav Kyrres Gate 7", 5073, "Bergen"), 90905152, BilPark.BergenPark());
		Reservasjon r1 = new Reservasjon(bil, kontorBergen, kontorBergen, LocalDate.parse("23/02/2022", DateTimeFormatter.ofPattern("d/MM/yyyy")), LocalTime.parse("15:30"), 15, kunde, 300);
		
		r1.reserver(bil);
		
		assertFalse(bil.isLedig());
	}

}
