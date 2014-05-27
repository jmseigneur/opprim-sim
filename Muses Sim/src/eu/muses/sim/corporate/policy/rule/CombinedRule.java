package eu.muses.sim.corporate.policy.rule;

public class CombinedRule extends Rule {

	private final Rule rule1;
	private final Rule rule2;
	private final CombinedRuleOperator combinedRuleOperator;
	
	public CombinedRule(Rule rule1, Rule rule2, CombinedRuleOperator combinedRuleOperator) {
		this.rule1 = rule1;
		this.rule2 = rule2;
		this.combinedRuleOperator = combinedRuleOperator;
	}

	@Override
	public boolean isValidated() {
		boolean validated = false;
		if (combinedRuleOperator.equals(CombinedRuleOperator.AND)) {
			validated = rule1.isValidated() && rule2.isValidated();
		} else {
			if (combinedRuleOperator.equals(CombinedRuleOperator.OR)) {
				validated = rule1.isValidated() || rule2.isValidated();
			} else {
				if (combinedRuleOperator.equals(CombinedRuleOperator.NOT)) {
					validated = !rule1.isValidated();
				} else {
					System.out.println("Unknown rule combiner operator : exiting");
					System.exit(-1);
				}
			}
		}
		return validated;
	}
	
	
}
