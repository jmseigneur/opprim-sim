package eu.muses.wp5;

public class Clue {

	String id;
	
	public final static Clue antivirusClue = new Clue("ANTIVIRUS");
	public final static Clue vpnClue = new Clue("VPN");
	public final static Clue firewallClue = new Clue ("FIREWALL");

	public Clue() {
		super();
	}

	public Clue(String clueId) {
		super();
		this.id = clueId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
