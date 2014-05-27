package eu.muses.sim.corporate.policy.rule;

public class CombinedRuleOperator {
	
	public static final CombinedRuleOperator AND = new CombinedRuleOperator("AND");
	public static final CombinedRuleOperator OR = new CombinedRuleOperator("OR");
	public static final CombinedRuleOperator NOT = new CombinedRuleOperator("NOT");
	
	private final String operatorName;
	
	public CombinedRuleOperator(String operatorName) {
		this.operatorName = operatorName;
	}

}
