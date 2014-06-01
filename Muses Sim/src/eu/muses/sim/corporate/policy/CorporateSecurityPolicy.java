/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.corporate.policy;

import java.util.Date;

import eu.muses.sim.context.Contextable;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.corporate.policy.rule.Rule;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.UserDevice;
import eu.muses.sim.test.SimUser;

/**
 * The Class CorporateSecurityPolicy.
 */
public class CorporateSecurityPolicy {

    /**
     * Instantiates a new corporate security policy.
     *
     * @param finalCombinedRuled
     *            the final combined ruled
     */
    public CorporateSecurityPolicy(Rule finalCombinedRuled) {
    }

    /**
     * At allowed time.
     *
     * @param date
     *            the date
     * @return true, if successful
     */
    public boolean atAllowedTime(Date date) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * By authorized user.
     *
     * @param user
     *            the user
     * @return true, if successful
     */
    public boolean byAuthorizedUser(SimUser user) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * By trusted user.
     *
     * @param user
     *            the user
     * @return true, if successful
     */
    public boolean byTrustedUser(SimUser user) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * From allowed location.
     *
     * @param location
     *            the location
     * @return true, if successful
     */
    public boolean fromAllowedLocation(Location location) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Checks for allowed role.
     *
     * @param role
     *            the role
     * @return true, if successful
     */
    public boolean hasAllowedRole(Role role) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Checks for validated rules combination.
     *
     * @return true, if successful
     */
    public boolean hasValidatedRulesCombination() {
        // TODO implement has validated rules combination
        return false;
    }

    /**
     * Checks if is in allowed group.
     *
     * @param group
     *            the group
     * @return true, if is in allowed group
     */
    public boolean isInAllowedGroup(Group group) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * On allowed network connection type.
     *
     * @param currentNetworkType
     *            the current network type
     * @return true, if successful
     */
    public boolean onAllowedNetworkConnectionType(NetworkConnectionType currentNetworkType) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * On authorizedd device.
     *
     * @param device
     *            the device
     * @return true, if successful
     */
    public boolean onAuthorizeddDevice(UserDevice device) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * On good enough environmental context.
     *
     * @param environmentalContext
     *            the environmental context
     * @return true, if successful
     */
    public boolean onGoodEnoughEnvironmentalContext(EnvironmentalContext environmentalContext) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * On trusted device.
     *
     * @param device
     *            the device
     * @return true, if successful
     */
    public boolean onTrustedDevice(UserDevice device) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Sets the acceptable risk threshold.
     *
     * @param contextable
     *            the contextable
     * @param riskValueThresholdBeforeDeny
     *            the risk value threshold before deny
     */
    public void setAcceptableRiskThreshold(Contextable contextable, RiskValue riskValueThresholdBeforeDeny) {
        // Implement acceptable risk threshold
    }

}
