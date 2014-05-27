package eu.muses.sim.riskman;


public class RiskCommunication {

	/** 
	 * @uml.property name="riskTreatment"
	 * @uml.associationEnd multiplicity="(0 -1)" dimension="1" ordering="true" inverse="riskCommunication:eu.muses.sim.riskman.RiskTreatment"
	 * @uml.association name="proposes"
	 */
	private RiskTreatment[] riskTreatments;
	
	private String textualDescription;

	public RiskCommunication(RiskTreatment[] riskTreatments,
			String textualDescription) {
		super();
		this.riskTreatments = riskTreatments;
		this.textualDescription = textualDescription;
	}

	/** 
	 * Setter of the property <tt>riskTreatment</tt>
	 * @param riskTreatment  The riskTreatments to set.
	 * @uml.property  name="riskTreatment"
	 */
	public void setRiskTreatment(RiskTreatment[] riskTreatment) {
		riskTreatments = riskTreatment;
	}

	public boolean hasRiskTreatment(
			RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub
		return false;
	}

	public RiskTreatment[] getRiskTreatments() {
		return riskTreatments;
	}

	public String getTextualDescription() {
		return textualDescription;
	}
	
	

}
