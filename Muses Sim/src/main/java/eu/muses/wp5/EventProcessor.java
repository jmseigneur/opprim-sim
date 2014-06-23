/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.wp5;

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskTreatment;
import eu.muses.sim.riskman.SecurityIncident;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.asset.MusesCertificateRequest;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.riskman.vulnerability.Vulnerability;
import eu.muses.sim.test.SimUser;
import eu.muses.sim.trustman.TrustValue;

/**
 * The Class EventProcessor.
 */
public class EventProcessor {

	private List<Clue> clues = new ArrayList<Clue>();

	/**
	 * Instantiates a new event processor.
	 */
	public EventProcessor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clues
	 *            the clues to set
	 */
	public void setClues(List<Clue> clues) {
		this.clues = clues;
	}

	/**
	 * Gets the clues.
	 *
	 * @param asset
	 *            the asset
	 * @return the clues
	 */
	public List<Clue> getClues(Asset asset) {

		return this.clues;
	}

	/**
	 * Gets the threats.
	 *
	 * @param asset
	 *            the asset
	 * @param userTrustValue
	 *            the user trust value
	 * @return the threats
	 */
	public Threat[] getThreats(Asset asset, TrustValue userTrustValue) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the vulnerabilities.
	 *
	 * @param materialForPatentProposal
	 *            the material for patent proposal
	 * @return the vulnerabilities
	 */
	public Collection<Vulnerability> getVulnerabilities(
			Asset materialForPatentProposal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Log denied request.
	 *
	 * @param accessRequest
	 *            the access request
	 */
	public void logDeniedRequest(AccessRequest accessRequest) {
		// TODO Auto-generated method stub

	}

	/**
	 * Log new device.
	 *
	 * @param cryptoId
	 *            the crypto id
	 * @param owner
	 *            the owner
	 * @param certificateSignatureRequest
	 *            the certificate signature request
	 * @return the certificate
	 */
	public Certificate logNewDevice(String cryptoId, Object owner,
			MusesCertificateRequest certificateSignatureRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Logs access request user decision in muses company instance.
	 */
	public void logsAccessRequestUserDecisionInMusesCompanyInstance() {
		// TODO Auto-generated method stub

	}

	/**
	 * Logs negative outcome based on the non achieved opportunity.
	 *
	 * @param accessRequest
	 *            the access request
	 */
	public void logsNegativeOutcomeBasedOnTheNonAchievedOpportunity(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub

	}

	/**
	 * Logs positive outcome based on the achieved opportunity.
	 *
	 * @param accessRequest
	 *            the access request
	 */
	public void logsPositiveOutcomeBasedOnTheAchievedOpportunity(
			AccessRequest accessRequest) {
		// TODO Auto-generated method stub

	}

	/**
	 * Logs successfully applied risk treatment.
	 *
	 * @param riskTreatment
	 *            the risk treatment
	 */
	public void logsSuccessfullyAppliedRiskTreatment(RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub

	}

	/**
	 * Logs user uses asset in muses company instance.
	 */
	public void logsUserUsesAssetInMusesCompanyInstance() {
		// TODO Auto-generated method stub

	}

	/**
	 * Reports security incident.
	 *
	 * @param securityIncident
	 *            the security incident
	 */
	public void reportsSecurityIncident(SecurityIncident securityIncident) {
		// TODO Auto-generated method stub

	}

	/**
	 * Seems user involved in security incident.
	 *
	 * @param user1
	 *            the user1
	 * @return the double
	 */
	public double seemsUserInvolvedInSecurityIncident(SimUser user1) {
		// TODO Auto-generated method stub
		return 0.9;
	}

}
