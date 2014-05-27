package eu.muses.sim.riskman;

public class RiskTreatment {
	
	private String textualDescription;
	
	public RiskTreatment(String textualDescription) {
		this.textualDescription = textualDescription;
	}

	public static final RiskTreatment PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY = new RiskTreatment("Please provide a description of your opportunity");
	
	public static final RiskTreatment RECONNECT = new RiskTreatment("You have been disconnected too long. Please provide a description of your opportunity");

}
