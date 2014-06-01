/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.corporate;

import eu.muses.sim.Outcome;
import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.decision.DecisionManager;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;
import eu.muses.wp5.EventProcessor;

/**
 * The Class Corporation.
 */
public class Corporation {

    /** The decision manager. */
    private DecisionManager decisionManager = new DecisionManager();

    /**
     * Checks if device is trustworthy enough.
     *
     * @return true, if successful
     */
    public boolean checksIfDeviceIsTrustworthyEnough() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Compute corporate access request decision.
     *
     * @param accessRequest
     *            the access request
     */
    public void computeCorporateAccessRequestDecision(AccessRequest accessRequest) {
        // TODO Auto-generated method stub

    }

    /**
     * Compute corporate access request opportunity.
     *
     * @param accessRequest
     *            the access request
     */
    public void computeCorporateAccessRequestOpportunity(AccessRequest accessRequest) {
        // TODO Auto-generated method stub

    }

    /**
     * Compute corporate access request risk.
     *
     * @param accessRequest
     *            the access request
     */
    public void computeCorporateAccessRequestRisk(AccessRequest accessRequest) {

    }

    /**
     * Compute corporate access request threats.
     *
     * @param accessRequest
     *            the access request
     */
    public void computeCorporateAccessRequestThreats(AccessRequest accessRequest) {
        // TODO Auto-generated method stub

    }

    /**
     * Compute corporate access request trust.
     *
     * @param accessRequest
     *            the access request
     */
    public void computeCorporateAccessRequestTrust(AccessRequest accessRequest) {
        // TODO Auto-generated method stub

    }

    /**
     * Decreases trust in user.
     *
     * @param alice
     *            the alice
     * @param securityIncidentOnPatent
     *            the security incident on patent
     */
    public void decreasesTrustInUser(SimUser alice, Outcome securityIncidentOnPatent) {
        // TODO Auto-generated method stub

    }

    /**
     * Enrolls user in company information system.
     *
     * @param user
     *            the user
     */
    public void enrollsUserInCompanyInformationSystem(SimUser user) {
        // TODO Auto-generated method stub

    }

    /**
     * Generate corporate access request risk treatments and trust risk communication.
     *
     * @param accessRequest
     *            the access request
     */
    public void generateCorporateAccessRequestRiskTreatmentsAndTrustRiskCommunication(AccessRequest accessRequest) {
        // TODO Auto-generated method stub

    }

    /**
     * Gets the trust value.
     *
     * @param user
     *            the user
     * @return the trust value
     */
    public TrustValue getTrustValue(SimUser user) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Installs.
     *
     * @param eventProcessor
     *            the event processor
     */
    public void installs(EventProcessor eventProcessor) {
        // TODO Auto-generated method stub

    }

    /**
     * Installs.
     *
     * @param rt2ae
     *            the rt2ae
     */
    public void installs(RealTimeRiskTrustAnalysisEngine rt2ae) {
        // TODO Auto-generated method stub

    }

    /**
     * Logs access request user decision in muses company instance.
     */
    public void logsAccessRequestUserDecisionInMusesCompanyInstance() {
        // TODO Auto-generated method stub

    }

    /**
     * Logs beneficial outcome based on the achieved opportunity.
     *
     * @param accessRequest
     *            the access request
     */
    public void logsBeneficialOutcomeBasedOnTheAchievedOpportunity(AccessRequest accessRequest) {
        // TODO Auto-generated method stub

    }

    /**
     * Logs new device.
     *
     * @param newDevice
     *            the new device
     */
    public void logsNewDevice(UserDevice newDevice) {
        // TODO Auto-generated method stub

    }

    /**
     * Reports security incident.
     *
     * @param securityIncidentOnPatent
     *            the security incident on patent
     */
    public void reportsSecurityIncident(Outcome securityIncidentOnPatent) {
        // TODO Auto-generated method stub

    }

    /**
     * Seems user involved in security incident.
     *
     * @param alice
     *            the alice
     * @return the double
     */
    public double seemsUserInvolvedInSecurityIncident(SimUser alice) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Sets the cso.
     *
     * @param userCSO
     *            the new cso
     */
    public void setCso(SimUser userCSO) {
        // TODO Auto-generated method stub

    }

    /**
     * Warns user responsible for security incident.
     *
     * @param alice
     *            the alice
     * @param securityIncidentOnPatent
     *            the security incident on patent
     */
    public void warnsUserResponsibleForSecurityIncident(SimUser alice, Outcome securityIncidentOnPatent) {
        // TODO Auto-generated method stub

    }

}
