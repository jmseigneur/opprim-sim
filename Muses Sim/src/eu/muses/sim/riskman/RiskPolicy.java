package eu.muses.sim.riskman;

import eu.muses.sim.corporate.policy.CorporateSecurityPolicy;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.riskman.vulnerability.Vulnerability;



public class RiskPolicy {
	
	private Probability probability;
	
	private CostBenefit costBenefit;

	private CorporateSecurityPolicy corporateSecurityPolicy;
	
		
	public RiskPolicy(RiskValue noRisk, CorporateSecurityPolicy corporateSecurityPolicy) {
		// TODO Auto-generated constructor stub
		this.corporateSecurityPolicy = corporateSecurityPolicy;	
	}

		/**
		 */
		public double computeRisk(Vulnerability[] vulnerabilities, Threat[] threats, double[] assetsValues){
			return 0;
		}


		public Probability getProbability() {
			return probability;
		}


		public CostBenefit getCostBenefit() {
			return costBenefit;
		}
		
		

}
