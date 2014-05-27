package eu.muses.sim.corporate.policy;

import java.util.Date;

import eu.muses.sim.context.Contextable;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.corporate.policy.rule.Rule;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.sim.SimUser;

public class CorporateSecurityPolicy {
	
	private final Rule finalCombinedRuled;
	
	public CorporateSecurityPolicy(Rule finalCombinedRuled) {
		this.finalCombinedRuled = finalCombinedRuled;
	}
	
	public void setAcceptableRiskThreshold(Contextable contextable, RiskValue riskValueThresholdBeforeDeny) {
		//Implement acceptable risk threshold
	}

	public boolean fromAllowedLocation(Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean atAllowedTime(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onAllowedNetworkConnectionType(
			NetworkConnectionType currentNetworkType) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onAuthorizeddDevice(UserDevice device) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean byAuthorizedUser(SimUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onTrustedDevice(UserDevice device) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean byTrustedUser(SimUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onGoodEnoughEnvironmentalContext(
			EnvironmentalContext environmentalContext) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasAllowedRole(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInAllowedGroup(Group group) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasValidatedRulesCombination() {
		//TODO implement has validated rules combination
		return false;
	}

}
