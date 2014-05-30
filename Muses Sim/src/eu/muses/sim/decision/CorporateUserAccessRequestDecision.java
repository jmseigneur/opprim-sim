package eu.muses.sim.decision;

public class CorporateUserAccessRequestDecision extends Decision {

	private String textualDecisionDescription;
	
	public CorporateUserAccessRequestDecision(String textualDecisionDescription) {
		this.textualDecisionDescription = textualDecisionDescription;
	}

	public String getTextualDecisionDescription() {
		return textualDecisionDescription;
	}

	public void setTextualDecisionDescription(String textualDecisionDescription) {
		this.textualDecisionDescription = textualDecisionDescription;
	}

}
