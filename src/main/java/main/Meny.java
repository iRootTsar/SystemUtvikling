package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import Objects.Adresse;
import Objects.BilPark;
import Objects.Kontor;
import Objects.Selskap;

/**
 * Meny klasse der alt magi skjer
 * @author vlads
 *
 */
public class Meny {
		static String firmaNavn = "NaboBil";
		 /**
		  * Lage selskap
		  */
		private static Selskap selskap = new Selskap(firmaNavn, 90905151, new Adresse("Strømgate 53", 5070, "Bergen"));
	        
	    /**
	     * lage kontorer
	     */
	    private static Kontor kontorBergen = new Kontor(1, new Adresse("Olav Kyrres Gate 7", 5073, "Bergen"), 90905152, BilPark.BergenPark());
	    private static Kontor kontorOslo = new Kontor(2, new Adresse("Harald Hårfagre gate 31", 0050, "Oslo"), 90905153, BilPark.OsloPark());
	    static List<Kontor> kontorer = new ArrayList<Kontor>();
	    
    public static void main( String[] args ){
       
    	
       /**
        * legger til kontorer i liste
        */
        kontorer.add(kontorBergen);
        kontorer.add(kontorOslo);
        
        /**
         * Legge til kontorer liste til selskap
         */
        selskap.setKontorer(kontorer);
        
        /**
         * Opprette start meny
         */
        
        valgMeny();
       
    }


	public static void valgMeny() {
		 
		 
		String oppstartTekst = "Tast inn \n" + 
 				"[1] for å reservere en bil\n" +
 				"[2] for å leie ut\n" +
 				"[3] for å levere bil tilbake\n"+
 				"[4] for å avslutte programmet.";
		
		System.out.println(oppstartTekst);
		Scanner scan = new Scanner(System.in);
		
		String inp = scan.next();
		int in = Integer.parseInt(inp);
		 
		 switch(in){
		 case 1:
			 System.out.println("Liste av ledige kontorer [" + kontorer.stream().map(e -> e.getAdresse().getPoststed()).collect(Collectors.joining(", ")) + "]");
			 new Reservere(selskap);
			 break;
		 case 2:
			 System.out.println("Hente reservert bil");
			 new Utlevering().leieUt(selskap);
			 break;
		 case 3:
			 System.out.println("Levere bil tilbake");
			 new Returnere().returnere(selskap);
			 break;
		 case 4:
			 System.out.println("Avslutte");
			 break;
		 }
		 scan.close();
	}
}
