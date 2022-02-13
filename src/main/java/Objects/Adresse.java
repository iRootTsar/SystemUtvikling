package Objects;

/**
 * Klasse som definere adresse
 * @author vlads
 *
 */
public class Adresse {

	private String gate;
	private int postNr;
	private String poststed;
	
	public Adresse(String gate, int postNr, String poststed) {
		super();
		this.gate = gate;
		this.postNr = postNr;
		this.poststed = poststed;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public int getPostNr() {
		return postNr;
	}

	public void setPostNr(int postNr) {
		this.postNr = postNr;
	}

	public String getPoststed() {
		return poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}
	
	
	
}
