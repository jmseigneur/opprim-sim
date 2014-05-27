package eu.muses.sim.riskman;

public class RiskValue {

	public final static RiskValue FULL_RISK = new RiskValue(0.0);
	
	public final static RiskValue NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY = new RiskValue(0.0);
	
	public final static RiskValue NO_RISK = new RiskValue(1.0);
	
	private double value;

	public RiskValue(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
}
