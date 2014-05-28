package eu.muses.sim.sim;

import java.security.Certificate;
import java.util.Collection;
import java.util.Vector;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.context.location.PublicAccessPoint;
import eu.muses.sim.corporate.CorporateOffice;
import eu.muses.sim.corporate.Corporation;
import eu.muses.sim.corporate.policy.CorporateSecurityPolicy;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.PersonalUserDevice;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.CorporateAsset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.riskman.vulnerability.Vulnerability;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.sim.userman.Credential;
import eu.muses.wp5.EventProcessor;

public class TestMusesConfiguration {
	
	static Corporation s2 = new Corporation();
	static EventProcessor s2EventCorrelator;
	static RealTimeRiskTrustAnalysisEngine s2Rt2ae;
	
	static MusesServerApp s2MusesServerApp;
	static MusesClientApp s2MusesClientApp;
	
	static SimUser userCso = new SimUser("userCSO", 300); 

	static SimUser user1 = new SimUser("user1", 120);
	static UserDevice user1Laptop = new PersonalUserDevice();
//	static RealTimeRiskTrustAnalysisEngine s2MobileRt2aeForUser1;
	
	static Asset materialForPublicMarketingPoster;
	static Asset materialForBid;
	static Asset newPatentProposal;
	static Asset materialForPatentProposal;
	
	public static void main(String[] args) {
					
		s2.setCso(userCso);
		
		musesUsersDevicesAndAssetsConfigurationsSteps();
		
	//	PublicAccessPoint genevaAirportGateAPublicWiFi = new PublicAccessPoint("genevaAirportGateAPublicWiFiAP", 0.0, 0.0);
	//	PublicAccessPoint genevaAirportSecuredCorporateLoungeWiFi = new PublicAccessPoint("genevaAirportSecureCorporateLoungeWiFiAP", 0.0, 0.0);
	//	user1.movesTo(genevaAirportGateAPublicWiFi);	
			
		//"user1 has two hours to work on a marketing poster at an airport that will be public with public material otherwise two hours of her working time will be lost"					
		//"user1 must access documents for a 150 000 kEuros bid to win a new project to submit it now or it will be too late because the deadline will have passed" 	
		//"user1 wants to work on a patent with confidential material"	
		AccessRequest accessRequest = user1.requestsAccessToAsset(materialForPatentProposal);
		
		//XXX //user1Laptop is for example inferred by the sensed MUSES WP6 context observation and their events correlation with MUSES WP5			
		
					
		Decision decision = s2Rt2ae.decidesBasedOnConfiguredRiskPolicy(accessRequest);	
		if (!decision.equals(Decision.STRONG_DENY_ACCESS)) {
			if (!decision.equals(Decision.ALLOW_ACCESS)) {
				user1.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(decision
						.getRiskCommunication()); //including some potential other behaviours, risk treatments that would allow the user to access the asset with less risk, such as going to a company lounge with secure WiFi	
			}
			while (decision.equals(Decision.MAYBE_ACCESS)
					&& user1.isStillMakingRequest(accessRequest)) {
				if (user1.givesUpRequestDueToRisk(accessRequest)) {
					user1.setStillMakingRequest(accessRequest, false);
				} else {
					if (decision
							.getRiskCommunication()
							.hasRiskTreatment(
									RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
						if (user1.acceptsToRefineOpportunity()) {
							OpportunityDescriptor opportunityDescriptor = user1
									.refinesOpportunity(); //in our example it corresponds to refinesOpportunity() below
							accessRequest
									.setOpportunityDescriptor(opportunityDescriptor);
							s2EventCorrelator
									.logsSuccessfullyAppliedRiskTreatment(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY);
						}
					}
					for (RiskTreatment riskTreatment : decision
							.getRiskCommunication().getRiskTreatments()) {
						if (!riskTreatment
								.equals(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
							if (user1
									.appliesSuccessfullyRiskTreatment(riskTreatment)) {
								//e.g. user1.movesTo(genevaAirportSecuredCorporateLoungeWiFi); //this risk treatment allows her to access the asset
								user1.isInformedOfSuccessfullyAppliedRiskTreatment(riskTreatment);
								s2EventCorrelator
										.logsSuccessfullyAppliedRiskTreatment(riskTreatment);
							} else {
								user1.isInformedOfUnsuccessfullRiskTreatmentApplication();
							}
						}
					}
					decision = s2Rt2ae
							.decidesBasedOnConfiguredRiskPolicy(accessRequest);
					user1.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(decision
							.getRiskCommunication()); //including some potential other behaviours, risk treatments that would allow the user to access the asset with less risk, such as going to a company lounge with secure WiFi
				}
			}
			while (decision.equals(Decision.ON_YOUR_RISK_ACCESS)
					&& user1.isStillMakingRequest(accessRequest)) {
				if (user1.givesUpRequestDueToRisk(accessRequest)) {
					user1.setStillMakingRequest(accessRequest, false);
					s2EventCorrelator
							.logsAccessRequestUserDecisionInMusesCompanyInstance(); //It may be important to also log when a user decides not taking the opportunity due to risk, e.g., to avoid never taking opportunities even when there is no risk due to laziness or risk aversion... 
				} else {
					if (user1.decidesAccessingAssetInSpiteOfRisk(accessRequest)) {
						user1.setStillMakingRequest(accessRequest, false);
						Asset[] corporateAssets = user1
								.getCorporateAssets(accessRequest);
						s2EventCorrelator
								.logsAccessRequestUserDecisionInMusesCompanyInstance();
						s2EventCorrelator
								.logsUserUsesAssetInMusesCompanyInstance();
						user1.usesCorporateAssets(corporateAssets);
						if (user1
								.successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(accessRequest
										.getOpportunityDescriptor())) {
							s2EventCorrelator
									.logsPositiveOutcomeBasedOnTheAchievedOpportunity(accessRequest);
							s2Rt2ae.updatesTrustInUserGivenPositiveOutcome(
									user1,
									accessRequest.getOpportunityDescriptor());
						} else {
							s2EventCorrelator
									.logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(accessRequest);
							s2Rt2ae.updatesTrustInUserGivenNegativeOutcome(
									user1,
									accessRequest.getOpportunityDescriptor());
						}
					} else {
						if (decision
								.getRiskCommunication()
								.hasRiskTreatment(
										RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
							if (user1.acceptsToRefineOpportunity()) {
								OpportunityDescriptor opportunityDescriptor = user1
										.refinesOpportunity(); //in our example it corresponds to refinesOpportunity() below
								accessRequest
										.setOpportunityDescriptor(opportunityDescriptor);
								s2EventCorrelator
										.logsSuccessfullyAppliedRiskTreatment(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY);
							}
						}
						for (RiskTreatment riskTreatment : decision
								.getRiskCommunication().getRiskTreatments()) {
							if (!riskTreatment
									.equals(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
								if (user1
										.appliesSuccessfullyRiskTreatment(riskTreatment)) {
									//e.g. user1.movesTo(genevaAirportSecuredCorporateLoungeWiFi); //this risk treatment allows her to access the asset
									user1.isInformedOfSuccessfullyAppliedRiskTreatment(riskTreatment);
									s2EventCorrelator
											.logsSuccessfullyAppliedRiskTreatment(riskTreatment);
								}
							} else {
								user1.isInformedOfUnsuccessfullRiskTreatmentApplication();
							}
						}
						decision = s2Rt2ae
								.decidesBasedOnConfiguredRiskPolicy(accessRequest);
						user1.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(decision
								.getRiskCommunication()); //including some potential other behaviours, risk treatments that would allow the user to access the asset with less risk, such as going to a company lounge with secure WiFi
					}
				}
			}
			if (decision.equals(Decision.ALLOW_ACCESS)) {
				user1.setStillMakingRequest(accessRequest, false);
				Asset[] corporateAssets = user1
						.getCorporateAssets(accessRequest);
				s2EventCorrelator.logsUserUsesAssetInMusesCompanyInstance();
				user1.usesCorporateAssets(corporateAssets);
				if (user1
						.successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(accessRequest
								.getOpportunityDescriptor())) {
					s2EventCorrelator
							.logsPositiveOutcomeBasedOnTheAchievedOpportunity(accessRequest);
					s2Rt2ae.updatesTrustInUserGivenPositiveOutcome(user1,
							accessRequest.getOpportunityDescriptor());
				} else {
					s2EventCorrelator
							.logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(accessRequest);
					s2Rt2ae.updatesTrustInUserGivenNegativeOutcome(user1,
							accessRequest.getOpportunityDescriptor());
				}
			}
			//Much later assuming there is a security incident on the asset
			SecurityIncident securityIncidentOnPatent = new SecurityIncident(
					"Patent is invalidated", newPatentProposal.getValue()); //the MUSES WP5 event correlator would detect this incident
			s2EventCorrelator.reportsSecurityIncident(securityIncidentOnPatent);
			if (s2EventCorrelator.seemsUserInvolvedInSecurityIncident(user1) > 0.8) {
				s2MusesClientApp.warnsUserResponsibleForSecurityIncident(user1,
						securityIncidentOnPatent);
				s2Rt2ae.decreasesTrustInUser(user1, securityIncidentOnPatent);
			}
		} else {
			s2EventCorrelator.logDeniedRequest(accessRequest);
		}
		
		//CorporateSecurityPolicy noAccessOutsideOfCorporatePremices = new CorporateSecurityPolicy();
		
		//noAccessOutsideOfCorporatePremices.setAcceptableRiskThreshold(Location.EVERYWHERE, RiskValue.NO_RISK); // Equivalent to deny access everywhere
		
		//CorporateOffice corporateOffice  = new CorporateOffice("Corporate Office", 0.0, 0.0);
		
		//noAccessOutsideOfCorporatePremices.setAcceptableRiskThreshold(corporateOffice, RiskValue.FULL_RISK); // Equivalent to allow access even under attack
		
	}
	
	public static void musesUsersDevicesAndAssetsConfigurationsSteps() {
		
		RiskPolicy riskPolicy = userCso.configureRiskPolicy(RiskValue.NO_RISK); //The risk policy would be specified as risk probability curves ponderated with costs and benefits
		s2EventCorrelator = userCso.configureEventCorrelator();
		s2Rt2ae = userCso.configureRt2ae(s2EventCorrelator, riskPolicy);
		s2MusesServerApp = userCso.configureMusesServerApp(s2Rt2ae);
	
		s2MusesClientApp = userCso.configureMusesClientApp(s2MusesServerApp);
		
		if(userCso.hasCsoConfiguredAssets()) {
			materialForPublicMarketingPoster = s2Rt2ae.getAsset("materialForPublicMarketingPoster");
			materialForBid = s2Rt2ae.getAsset("materialForBid");
			newPatentProposal = s2Rt2ae.getAsset("newPatentProposal");
			materialForPatentProposal = s2Rt2ae.getAsset("materialForPatentProposal");		
		} else {
			newPatentProposal = userCso.addsNewAssetToRt2ae(s2Rt2ae, new Asset("newPatentProposal", 600000));
//			Vulnerability patentInvalidationTrial = new Vulnerability();
//			Vector<Vulnerability> vulnerabilitiesNewPatent = new Vector<Vulnerability>();
//			vulnerabilitiesNewPatent.add(patentInvalidationTrial);
//			newPatentProposal.setVulnerabilities(vulnerabilitiesNewPatent);

			materialForPatentProposal = userCso.addsNewAssetToRt2ae(s2Rt2ae, new Asset("materialForPatentProposal", newPatentProposal.getValue()));
//			Collection<Vulnerability> vulnerabilitiesPatentMaterial = s2EventCorrelator.getVulnerabilities(materialForPatentProposal);
//			Vulnerability materialInterceptedOverTheNetwork = new Vulnerability();
//			vulnerabilitiesPatentMaterial.add(materialInterceptedOverTheNetwork);
//			materialForPatentProposal.setVulnerabilities(vulnerabilitiesPatentMaterial);
				
			materialForBid = userCso.addsNewAssetToRt2ae(s2Rt2ae, new Asset("materialForBid", 150000));
//			Collection<Vulnerability> vulnerabilitiesBidMaterial = s2EventCorrelator.getVulnerabilities(materialForPatentProposal);
//			Vulnerability materialOfBidInterceptedOverTheNetwork = new Vulnerability();
//			vulnerabilitiesPatentMaterial.add(materialOfBidInterceptedOverTheNetwork);
//			materialForPatentProposal.setVulnerabilities(vulnerabilitiesBidMaterial);

			materialForPublicMarketingPoster = userCso.addsNewAssetToRt2ae(s2Rt2ae, new Asset("materialForPublicMarketingPoster", 0));
		}
				
		userCso.enrollsUserInCompanyInformationSystem(user1);
		
		user1Laptop = new PersonalUserDevice();
		
		if (userCso.checksIfDeviceIsTrustworthyEnough()) {
			user1Laptop.installOnClient(s2MusesClientApp);
			String userLogin = user1.getNickname();
			String password = user1.typePassword();
			if (user1.authenticateWihMusesCredentials(userLogin, password)) {
				user1Laptop.setOwner(user1.getNickname());
				Credential[] credentials = user1.authenticates();
				Certificate deviceKeyPairMusesCertificate = s2EventCorrelator.logNewDevice(user1Laptop.getCryptoId(), user1Laptop.getOwner(), user1Laptop.getCertificateSignatureRequest());
				user1Laptop.setCertificate(deviceKeyPairMusesCertificate);
			} else {
				System.exit(-1);
			}
		}

	}
	
	public static void refinesOpportunity() {
		Vector<Asset> requestedAssestsByUser1 = new Vector<Asset>();
		requestedAssestsByUser1.add(materialForPublicMarketingPoster);
		requestedAssestsByUser1.add(materialForPatentProposal);
			
		//"user1 has two hours to work on a marketing poster at an airport that will be public with public material otherwise two hours of her working time will be lost"					
		Outcome gainedTwoHoursWorkOfUser1 = new Outcome("Gained two hours work of user1", 2 * user1.getHourlyCost());
		Outcome lostTwoHoursWorkOfUser1 = new Outcome("Lost two hours work of user1", -1 * 2 * user1.getHourlyCost());
		//"user1 must access documents for a 150 000 kEuros bid to win a new project to submit it now or it will be too late because the deadline will have passed" 	
		Outcome gainedSubmittedBid = new Outcome("Gained submitted bid", 150000);
		Outcome lostBid = new Outcome("Lost bid", 150000);		
	}
	
/*	public static void computesThreats(OpportunityDescriptor opportunityDescriptor) {
		Collection<Asset> requestedAssestsByUser1 = opportunityDescriptor.getRequestedAssets();
			
		//"user1 has two hours to work on a marketing poster at an airport that will be public with public material otherwise two hours of her working time will be lost"					
		Outcome gainedTwoHoursWorkOfUser1 = new Outcome("Gained two hours work of user1", 2 * user1.getHourlyCost());
		Outcome lostTwoHoursWorkOfUser1 = new Outcome("Lost two hours work of user1", -1 * 2 * user1.getHourlyCost());
		//"user1 must access documents for a 150 000 kEuros bid to win a new project to submit it now or it will be too late because the deadline will have passed" 	
		Outcome gainedSubmittedBid = new Outcome("Gained submitted bid", 150000);
		Outcome lostBid = new Outcome("Lost bid", 150000);
		//"user1 works on a patent with confidential material
		Outcome materialForPatentProposalIsStolen = new Outcome("Material for patent proposal is stolen and invalidates patent", -1 * materialForPatentProposal.getValue());
		Outcome newPatentProposalIsNotInvalidated = new Outcome("New patent is NOT invalidate", newPatentProposal.getValue());
		
		
		Vector<Outcome> outcomesUser1WorksTwoHoursAtTheAirport = new Vector<Outcome>();
		outcomesUser1WorksTwoHoursAtTheAirport.add(gainedTwoHoursWorkOfUser1);
		outcomesUser1WorksTwoHoursAtTheAirport.add(gainedSubmittedBid);
		
		Vector<Outcome> outcomesPatentMaterialIsStolen = new Vector<Outcome>();

		Probability probabilityGainedTwoHoursWorkOfUser1 = s2Rt2ae.callEventCorrelatorForProbability(gainedTwoHoursWorkOfUser1, s2Rt2ae.getTrustValue(user1));		
		
		Probability probabilityMaterialForPatentProposalIsStolen = s2Rt2ae.callEventCorrelatorForProbability(materialForPatentProposalIsStolen, s2Rt2ae.getTrustValue(user1));
		
		Opportunity opportunityUser1WorksTwoHoursAtTheAirport = new Opportunity("user1 works two hours at the airport", probabilityGainedTwoHoursWorkOfUser1, outcomesUser1WorksTwoHoursAtTheAirport); 
		
		Threat threatAttackerStealsMaterialForPatentProposal = new Threat("Attacker steals material for patent proposal", probabilityMaterialForPatentProposalIsStolen, outcomesPatentMaterialIsStolen);
		Threat[] newPatentProposalThreats = s2EventCorrelator.getThreats(newPatentProposal);
		Threat[] materialForPatentProposalThreats = s2EventCorrelator.getThreats(materialForPatentProposal);
		Threat[] materialForBidThreats = s2EventCorrelator.getThreats(materialForBid);
		Threat[] materialForPublicMarketingPosterThreats = s2EventCorrelator.getThreats(materialForPublicMarketingPoster);

		Vector<RiskEvent> riskEvents = new Vector<RiskEvent>();
		riskEvents.add(opportunityUser1WorksTwoHoursAtTheAirport);
		riskEvents.add(threatAttackerStealsMaterialForPatentProposal);
		for (RiskEvent riskEvent : newPatentProposalThreats) {
			riskEvents.add(threatAttackerStealsMaterialForPatentProposal);
		}
		
		AccessRequest accessRequest = user1.requestsAccessToAssetsForOpportunity(requestedAssestsByUser1, opportunityUser1WorksTwoHoursAtTheAirport, genevaAirportGateAPublicWiFi, user1Laptop); //user1Laptop is for example inferred by the sensed MUSES WP6 context observation and their events correlation with MUSES WP5			
		
		return accessRequest;
	} */

	
	

	
}
