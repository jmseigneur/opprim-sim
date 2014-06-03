/*
 * Copyright Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.test;

import java.security.cert.Certificate;
import java.util.Vector;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.corporate.Corporation;
import eu.muses.sim.decision.CorporateUserAccessRequestDecision;
import eu.muses.sim.decision.Decision;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.PersonalUserDevice;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.EventProcessor;

/**
 * The Class TestMusesConfiguration.
 */
public class TestMusesConfiguration {

    /** The s2. */
    static Corporation s2 = new Corporation();

    /** The s2 event correlator. */
    static EventProcessor s2EventCorrelator;

    /** The s2 rt2ae. */
    static RealTimeRiskTrustAnalysisEngine s2Rt2ae;

    /** The s2 muses server app. */
    static MusesServerApp s2MusesServerApp;

    /** The s2 muses client app. */
    static MusesClientApp s2MusesClientApp;

    /** The user cso. */
    static SimUser userCso = new SimUser("userCSO", 300);

    /** The user1. */
    static SimUser user1 = new SimUser("user1", 120);

    /** The user1 laptop. */
    static UserDevice user1Laptop = new PersonalUserDevice();
    // static RealTimeRiskTrustAnalysisEngine s2MobileRt2aeForUser1;

    /** The material for public marketing poster. */
    static Asset materialForPublicMarketingPoster;

    /** The material for bid. */
    static Asset materialForBid;

    /** The new patent proposal. */
    static Asset newPatentProposal;

    /** The material for patent proposal. */
    static Asset materialForPatentProposal;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {

    	userCso.setTrustValue(new TrustValue(0.5));
        TestMusesConfiguration.s2.setCso(TestMusesConfiguration.userCso);
        TestMusesConfiguration.musesUsersDevicesAndAssetsConfigurationsSteps();
        try {
            TestMusesConfiguration.s2Rt2ae.initCluesThreatTable();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // PublicAccessPoint genevaAirportGateAPublicWiFi = new PublicAccessPoint("genevaAirportGateAPublicWiFiAP", 0.0,
        // 0.0);
        // PublicAccessPoint genevaAirportSecuredCorporateLoungeWiFi = new
        // PublicAccessPoint("genevaAirportSecureCorporateLoungeWiFiAP", 0.0, 0.0);
        // user1.movesTo(genevaAirportGateAPublicWiFi);

        // "user1 has two hours to work on a marketing poster at an airport that will be public
        // with public material otherwise two hours of her working time will be lost"
        // "user1 must access documents for a 150 000 kEuros bid to win a new project to submit
        // it now or it will be too late because the deadline will have passed"
        // "user1 wants to work on a patent with confidential material"
        AccessRequest accessRequest = SimUser.requestsAccessToAsset(TestMusesConfiguration.materialForPatentProposal);
        OpportunityDescriptor opportunityDescriptor = new OpportunityDescriptor();
        opportunityDescriptor
                .setDescription("user1 must access documents for a 150 000 kEuros bid to win a new project to submit it"
                        + " now or it will be too late because the deadline will have passed");
        opportunityDescriptor.addOutcome(new Outcome("150k eur can be won if the material is used and submitted", 150.0));
        opportunityDescriptor.addRequestedAsset(TestMusesConfiguration.materialForPatentProposal);
        accessRequest.setOpportunityDescriptor(opportunityDescriptor);
        accessRequest.setUser(userCso);

        // XXX //user1Laptop is for example inferred by the sensed MUSES WP6 context observation and their events
        // correlation with MUSES WP5

        Decision decision = TestMusesConfiguration.s2Rt2ae.decidesBasedOnConfiguredRiskPolicy(accessRequest);
        System.out.println("The computed decision for the asset "
                + accessRequest.getRequestedCorporateAsset().iterator().next().getAssetName()
                + " was: "
                + ((CorporateUserAccessRequestDecision) decision).getTextualDecisionDescription() + "\n");
        if (!decision.equals(Decision.STRONG_DENY_ACCESS)) {
            if (!decision.equals(Decision.ALLOW_ACCESS)) {
                TestMusesConfiguration.user1.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(decision
                        .getRiskCommunication()); // including some potential other behaviours, risk treatments that
                // would allow the user to access the asset with less risk, such as
                // going to a company lounge with secure WiFi
            }
            while (decision.equals(Decision.MAYBE_ACCESS)
                    && TestMusesConfiguration.user1.isStillMakingRequest(accessRequest)) {
                if (TestMusesConfiguration.user1.givesUpRequestDueToRisk(accessRequest)) {
                    TestMusesConfiguration.user1.setStillMakingRequest(accessRequest, false);
                }
                else {
                    if (decision.getRiskCommunication().hasRiskTreatment(
                            RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
                        if (TestMusesConfiguration.user1.acceptsToRefineOpportunity()) {
                            System.out.println("User accepted to refine the access oportunity");
                            opportunityDescriptor = TestMusesConfiguration.user1.refinesOpportunity(); // in our example
                            // it corresponds
                            // to
                            // refinesOpportunity()
                            // below
                            accessRequest.setOpportunityDescriptor(opportunityDescriptor);
                            TestMusesConfiguration.s2EventCorrelator
                            .logsSuccessfullyAppliedRiskTreatment(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY);
                        }
                    }
                    for (RiskTreatment riskTreatment : decision.getRiskCommunication().getRiskTreatments()) {
                        if (!riskTreatment.equals(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
                            if (TestMusesConfiguration.user1.appliesSuccessfullyRiskTreatment(riskTreatment)) {
                                // e.g. user1.movesTo(genevaAirportSecuredCorporateLoungeWiFi); //this risk treatment
                                // allows her to access the asset
                                TestMusesConfiguration.user1
                                .isInformedOfSuccessfullyAppliedRiskTreatment(riskTreatment);
                                TestMusesConfiguration.s2EventCorrelator
                                .logsSuccessfullyAppliedRiskTreatment(riskTreatment);
                            }
                            else {
                                TestMusesConfiguration.user1.isInformedOfUnsuccessfullRiskTreatmentApplication();
                            }
                        }
                    }
                    decision = TestMusesConfiguration.s2Rt2ae.decidesBasedOnConfiguredRiskPolicy(accessRequest);
                    TestMusesConfiguration.user1.readsAccessRiskCommunicationIncludingPotentialRiskTreatments(decision
                            .getRiskCommunication()); // including some potential other behaviours, risk treatments that
                    // would allow the user to access the asset with less risk, such
                    // as going to a company lounge with secure WiFi
                }
            }
            while (decision.equals(Decision.ON_YOUR_RISK_ACCESS)
                    && TestMusesConfiguration.user1.isStillMakingRequest(accessRequest)) {
                if (TestMusesConfiguration.user1.givesUpRequestDueToRisk(accessRequest)) {
                    TestMusesConfiguration.user1.setStillMakingRequest(accessRequest, false);
                    TestMusesConfiguration.s2EventCorrelator.logsAccessRequestUserDecisionInMusesCompanyInstance();
                    // It may be important to also log when a user decides not taking the opportunity due to risk, e.g.,
                    // to avoid never taking opportunities even when there is no risk due to laziness or risk
                    // aversion...
                }
                else {
                    if (TestMusesConfiguration.user1.decidesAccessingAssetInSpiteOfRisk(accessRequest)) {
                        TestMusesConfiguration.user1.setStillMakingRequest(accessRequest, false);
                        Asset[] corporateAssets = TestMusesConfiguration.user1.getCorporateAssets(accessRequest);
                        TestMusesConfiguration.s2EventCorrelator.logsAccessRequestUserDecisionInMusesCompanyInstance();
                        TestMusesConfiguration.s2EventCorrelator.logsUserUsesAssetInMusesCompanyInstance();
                        TestMusesConfiguration.user1.usesCorporateAssets(corporateAssets);
                        if (TestMusesConfiguration.user1
                                .successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(accessRequest
                                        .getOpportunityDescriptor())) {
                            TestMusesConfiguration.s2EventCorrelator
                            .logsPositiveOutcomeBasedOnTheAchievedOpportunity(accessRequest);
                            TestMusesConfiguration.s2Rt2ae.updatesTrustInUserGivenPositiveOutcome(
                                    TestMusesConfiguration.user1, accessRequest.getOpportunityDescriptor());
                        }
                        else {
                            TestMusesConfiguration.s2EventCorrelator
                            .logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(accessRequest);
                            TestMusesConfiguration.s2Rt2ae.updatesTrustInUserGivenNegativeOutcome(
                                    TestMusesConfiguration.user1, accessRequest.getOpportunityDescriptor());
                        }
                    }
                    else {
                        if (decision.getRiskCommunication().hasRiskTreatment(
                                RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
                            if (TestMusesConfiguration.user1.acceptsToRefineOpportunity()) {
                                opportunityDescriptor = TestMusesConfiguration.user1.refinesOpportunity();
                                // in our example it corresponds to refinesOpportunity()
                                // below
                                accessRequest.setOpportunityDescriptor(opportunityDescriptor);
                                TestMusesConfiguration.s2EventCorrelator
                                .logsSuccessfullyAppliedRiskTreatment(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY);
                            }
                        }
                        for (RiskTreatment riskTreatment : decision.getRiskCommunication().getRiskTreatments()) {
                            if (!riskTreatment.equals(RiskTreatment.PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY)) {
                                if (TestMusesConfiguration.user1.appliesSuccessfullyRiskTreatment(riskTreatment)) {
                                    // e.g. user1.movesTo(genevaAirportSecuredCorporateLoungeWiFi); //this risk
                                    // treatment allows her to access the asset
                                    TestMusesConfiguration.user1
                                    .isInformedOfSuccessfullyAppliedRiskTreatment(riskTreatment);
                                    TestMusesConfiguration.s2EventCorrelator
                                    .logsSuccessfullyAppliedRiskTreatment(riskTreatment);
                                }
                            }
                            else {
                                TestMusesConfiguration.user1.isInformedOfUnsuccessfullRiskTreatmentApplication();
                            }
                        }
                        decision = TestMusesConfiguration.s2Rt2ae.decidesBasedOnConfiguredRiskPolicy(accessRequest);
                        TestMusesConfiguration.user1
                        .readsAccessRiskCommunicationIncludingPotentialRiskTreatments(decision
                                .getRiskCommunication()); // including some potential other behaviours, risk
                        // treatments that would allow the user to access the
                        // asset with less risk, such as going to a company
                        // lounge with secure WiFi
                    }
                }
            }
            if (decision.equals(Decision.ALLOW_ACCESS)) {
                TestMusesConfiguration.user1.setStillMakingRequest(accessRequest, false);
                Asset[] corporateAssets = TestMusesConfiguration.user1.getCorporateAssets(accessRequest);
                TestMusesConfiguration.s2EventCorrelator.logsUserUsesAssetInMusesCompanyInstance();
                TestMusesConfiguration.user1.usesCorporateAssets(corporateAssets);
                if (TestMusesConfiguration.user1
                        .successfullyUseCorporateAssetsGivenTheSpecifiedOpportunity(accessRequest
                                .getOpportunityDescriptor())) {
                    TestMusesConfiguration.s2EventCorrelator
                    .logsPositiveOutcomeBasedOnTheAchievedOpportunity(accessRequest);
                    TestMusesConfiguration.s2Rt2ae.updatesTrustInUserGivenPositiveOutcome(TestMusesConfiguration.user1,
                            accessRequest.getOpportunityDescriptor());
                }
                else {
                    TestMusesConfiguration.s2EventCorrelator
                    .logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(accessRequest);
                    TestMusesConfiguration.s2Rt2ae.updatesTrustInUserGivenNegativeOutcome(TestMusesConfiguration.user1,
                            accessRequest.getOpportunityDescriptor());
                }
            }
            // Much later assuming there is a security incident on the asset
            SecurityIncident securityIncidentOnPatent = new SecurityIncident("Patent is invalidated",
                    TestMusesConfiguration.newPatentProposal.getValue()); // the MUSES WP5 event correlator would detect
            // this incident
            TestMusesConfiguration.s2EventCorrelator.reportsSecurityIncident(securityIncidentOnPatent);
            if (TestMusesConfiguration.s2EventCorrelator
                    .seemsUserInvolvedInSecurityIncident(TestMusesConfiguration.user1) > 0.8) {
            	System.out.println("S2 Event Correlator detected a security incident possibly linked to the user");
                TestMusesConfiguration.s2MusesClientApp.warnsUserResponsibleForSecurityIncident(
                        TestMusesConfiguration.user1, securityIncidentOnPatent);
                TestMusesConfiguration.s2Rt2ae.decreasesTrustInUser(TestMusesConfiguration.user1,
                        securityIncidentOnPatent);
                s2Rt2ae.recalculateThreatProbabilities(accessRequest);
            }
        }
        else {
            TestMusesConfiguration.s2EventCorrelator.logDeniedRequest(accessRequest);
        }

        // CorporateSecurityPolicy noAccessOutsideOfCorporatePremices = new CorporateSecurityPolicy();

        // noAccessOutsideOfCorporatePremices.setAcceptableRiskThreshold(Location.EVERYWHERE, RiskValue.NO_RISK); //
        // Equivalent to deny access everywhere

        // CorporateOffice corporateOffice = new CorporateOffice("Corporate Office", 0.0, 0.0);

        // noAccessOutsideOfCorporatePremices.setAcceptableRiskThreshold(corporateOffice, RiskValue.FULL_RISK); //
        // Equivalent to allow access even under attack

    }

    /**
     * Muses users devices and assets configurations steps.
     */
    public static void musesUsersDevicesAndAssetsConfigurationsSteps() {

        RiskPolicy riskPolicy = TestMusesConfiguration.userCso.configureRiskPolicy(RiskValue.TAKE_AVERAGE_RISK); // The risk
        // policy would
        // be specified
        // as risk
        // probability
        // curves
        // ponderated
        // with costs and
        // benefits
        TestMusesConfiguration.s2EventCorrelator = TestMusesConfiguration.userCso.configureEventCorrelator();
        TestMusesConfiguration.s2Rt2ae = TestMusesConfiguration.userCso.configureRt2ae(
                TestMusesConfiguration.s2EventCorrelator, RiskPolicy.TAKE_MEDIUM_RISK);
        TestMusesConfiguration.s2MusesServerApp = TestMusesConfiguration.userCso
                .configureMusesServerApp(TestMusesConfiguration.s2Rt2ae);

        TestMusesConfiguration.s2MusesClientApp = TestMusesConfiguration.userCso
                .configureMusesClientApp(TestMusesConfiguration.s2MusesServerApp);

        if (TestMusesConfiguration.userCso.hasCsoConfiguredAssets(TestMusesConfiguration.s2Rt2ae)) {
            TestMusesConfiguration.materialForPublicMarketingPoster = TestMusesConfiguration.s2Rt2ae
                    .getAsset("materialForPublicMarketingPoster");
            TestMusesConfiguration.materialForBid = TestMusesConfiguration.s2Rt2ae.getAsset("materialForBid");
            TestMusesConfiguration.newPatentProposal = TestMusesConfiguration.s2Rt2ae.getAsset("newPatentProposal");
            TestMusesConfiguration.materialForPatentProposal = TestMusesConfiguration.s2Rt2ae
                    .getAsset("materialForPatentProposal");
        }
        else {
            TestMusesConfiguration.newPatentProposal = TestMusesConfiguration.userCso.addsNewAssetToRt2ae(
                    TestMusesConfiguration.s2Rt2ae, new Asset("newPatentProposal", 600000));
            // Vulnerability patentInvalidationTrial = new Vulnerability();
            // Vector<Vulnerability> vulnerabilitiesNewPatent = new Vector<Vulnerability>();
            // vulnerabilitiesNewPatent.add(patentInvalidationTrial);
            // newPatentProposal.setVulnerabilities(vulnerabilitiesNewPatent);

            TestMusesConfiguration.materialForPatentProposal = TestMusesConfiguration.userCso.addsNewAssetToRt2ae(
                    TestMusesConfiguration.s2Rt2ae, new Asset("materialForPatentProposal",
                            TestMusesConfiguration.newPatentProposal.getValue()));
            // Collection<Vulnerability> vulnerabilitiesPatentMaterial =
            // s2EventCorrelator.getVulnerabilities(materialForPatentProposal);
            // Vulnerability materialInterceptedOverTheNetwork = new Vulnerability();
            // vulnerabilitiesPatentMaterial.add(materialInterceptedOverTheNetwork);
            // materialForPatentProposal.setVulnerabilities(vulnerabilitiesPatentMaterial);

            TestMusesConfiguration.materialForBid = TestMusesConfiguration.userCso.addsNewAssetToRt2ae(
                    TestMusesConfiguration.s2Rt2ae, new Asset("materialForBid", 150000));
            // Collection<Vulnerability> vulnerabilitiesBidMaterial =
            // s2EventCorrelator.getVulnerabilities(materialForPatentProposal);
            // Vulnerability materialOfBidInterceptedOverTheNetwork = new Vulnerability();
            // vulnerabilitiesPatentMaterial.add(materialOfBidInterceptedOverTheNetwork);
            // materialForPatentProposal.setVulnerabilities(vulnerabilitiesBidMaterial);

            TestMusesConfiguration.materialForPublicMarketingPoster = TestMusesConfiguration.userCso
                    .addsNewAssetToRt2ae(TestMusesConfiguration.s2Rt2ae, new Asset("materialForPublicMarketingPoster",
                            0));
        }

        TestMusesConfiguration.userCso.enrollsUserInCompanyInformationSystem(TestMusesConfiguration.user1);

        TestMusesConfiguration.user1Laptop = new PersonalUserDevice();

        if (TestMusesConfiguration.userCso.checksIfDeviceIsTrustworthyEnough()) {
            TestMusesConfiguration.user1Laptop.installOnClient(TestMusesConfiguration.s2MusesClientApp);
            String userLogin = TestMusesConfiguration.user1.getNickname();
            String password = TestMusesConfiguration.user1.typePassword();
            if (TestMusesConfiguration.user1.authenticateWihMusesCredentials(userLogin, password)) {
                TestMusesConfiguration.user1Laptop.setOwner(TestMusesConfiguration.user1.getNickname());
                TestMusesConfiguration.user1.authenticates();
                Certificate deviceKeyPairMusesCertificate = TestMusesConfiguration.s2EventCorrelator.logNewDevice(
                        TestMusesConfiguration.user1Laptop.getCryptoId(),
                        TestMusesConfiguration.user1Laptop.getOwner(),
                        TestMusesConfiguration.user1Laptop.getCertificateSignatureRequest());
                TestMusesConfiguration.user1Laptop.setCertificate(deviceKeyPairMusesCertificate);
            }
            else {
                System.exit(-1);
            }
        }

    }

    /**
     * Refines opportunity.
     */
    public static void refinesOpportunity() {
        Vector<Asset> requestedAssestsByUser1 = new Vector<Asset>();
        requestedAssestsByUser1.add(TestMusesConfiguration.materialForPublicMarketingPoster);
        requestedAssestsByUser1.add(TestMusesConfiguration.materialForPatentProposal);

        new Outcome("Gained two hours work of user1", 2 * TestMusesConfiguration.user1.getHourlyCost());
        new Outcome("Lost two hours work of user1", -1 * 2 * TestMusesConfiguration.user1.getHourlyCost());
        new Outcome("Gained submitted bid", 150000);
        new Outcome("Lost bid", 150000);
    }

    /*
     * public static void computesThreats(OpportunityDescriptor opportunityDescriptor) { Collection<Asset>
     * requestedAssestsByUser1 = opportunityDescriptor.getRequestedAssets(); // "user1 has two hours to work on a
     * marketing poster at an airport that will be public with public material otherwise two hours of her working time
     * will be lost" Outcome gainedTwoHoursWorkOfUser1 = new Outcome("Gained two hours work of user1", 2 *
     * user1.getHourlyCost()); Outcome lostTwoHoursWorkOfUser1 = new Outcome("Lost two hours work of user1", -1 * 2 *
     * user1.getHourlyCost()); // "user1 must access documents for a 150 000 kEuros bid to win a new project to submit
     * it now or it will be too late because the deadline will have passed" Outcome gainedSubmittedBid = new
     * Outcome("Gained submitted bid", 150000); Outcome lostBid = new Outcome("Lost bid", 150000); //"user1 works on a
     * patent with confidential material Outcome materialForPatentProposalIsStolen = new
     * Outcome("Material for patent proposal is stolen and invalidates patent", -1 *
     * materialForPatentProposal.getValue()); Outcome newPatentProposalIsNotInvalidated = new
     * Outcome("New patent is NOT invalidate", newPatentProposal.getValue()); Vector<Outcome>
     * outcomesUser1WorksTwoHoursAtTheAirport = new Vector<Outcome>();
     * outcomesUser1WorksTwoHoursAtTheAirport.add(gainedTwoHoursWorkOfUser1);
     * outcomesUser1WorksTwoHoursAtTheAirport.add(gainedSubmittedBid); Vector<Outcome> outcomesPatentMaterialIsStolen =
     * new Vector<Outcome>(); Probability probabilityGainedTwoHoursWorkOfUser1 =
     * s2Rt2ae.callEventCorrelatorForProbability(gainedTwoHoursWorkOfUser1, s2Rt2ae.getTrustValue(user1)); Probability
     * probabilityMaterialForPatentProposalIsStolen =
     * s2Rt2ae.callEventCorrelatorForProbability(materialForPatentProposalIsStolen, s2Rt2ae.getTrustValue(user1));
     * Opportunity opportunityUser1WorksTwoHoursAtTheAirport = new Opportunity("user1 works two hours at the airport",
     * probabilityGainedTwoHoursWorkOfUser1, outcomesUser1WorksTwoHoursAtTheAirport); Threat
     * threatAttackerStealsMaterialForPatentProposal = new Threat("Attacker steals material for patent proposal",
     * probabilityMaterialForPatentProposalIsStolen, outcomesPatentMaterialIsStolen); Threat[] newPatentProposalThreats
     * = s2EventCorrelator.getThreats(newPatentProposal); Threat[] materialForPatentProposalThreats =
     * s2EventCorrelator.getThreats(materialForPatentProposal); Threat[] materialForBidThreats =
     * s2EventCorrelator.getThreats(materialForBid); Threat[] materialForPublicMarketingPosterThreats =
     * s2EventCorrelator.getThreats(materialForPublicMarketingPoster); Vector<RiskEvent> riskEvents = new
     * Vector<RiskEvent>(); riskEvents.add(opportunityUser1WorksTwoHoursAtTheAirport);
     * riskEvents.add(threatAttackerStealsMaterialForPatentProposal); for (RiskEvent riskEvent :
     * newPatentProposalThreats) { riskEvents.add(threatAttackerStealsMaterialForPatentProposal); } AccessRequest
     * accessRequest = user1.requestsAccessToAssetsForOpportunity(requestedAssestsByUser1,
     * opportunityUser1WorksTwoHoursAtTheAirport, genevaAirportGateAPublicWiFi, user1Laptop); //user1Laptop is for
     * example inferred by the sensed MUSES WP6 context observation and their events correlation with MUSES WP5 return
     * accessRequest; }
     */

}
