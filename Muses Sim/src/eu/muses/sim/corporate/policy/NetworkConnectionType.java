package eu.muses.sim.corporate.policy;

public class NetworkConnectionType {
	
	private String name;
	
	public final static NetworkConnectionType COMPANY_INTRANET = new NetworkConnectionType("Company Intranet");
	public final static NetworkConnectionType VPN = new NetworkConnectionType("VPN");
	public final static NetworkConnectionType EXTERNAL = new NetworkConnectionType("External");

	public NetworkConnectionType(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
			
			
}
