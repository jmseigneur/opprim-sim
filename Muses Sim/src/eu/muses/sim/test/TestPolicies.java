/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.test;

import java.util.Date;

import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.context.location.Location;
import eu.muses.sim.corporate.policy.CorporateSecurityPolicy;
import eu.muses.sim.corporate.policy.EnvironmentalContext;
import eu.muses.sim.corporate.policy.Group;
import eu.muses.sim.corporate.policy.NetworkConnectionType;
import eu.muses.sim.corporate.policy.Role;
import eu.muses.sim.corporate.policy.SensitivityLevel;
import eu.muses.sim.corporate.policy.rule.BeforeTimeRule;
import eu.muses.sim.corporate.policy.rule.CombinedRule;
import eu.muses.sim.corporate.policy.rule.CombinedRuleOperator;
import eu.muses.sim.corporate.policy.rule.Rule;
import eu.muses.sim.riskman.CorporateUserDevice;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.RiskValue;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.wp5.EventProcessor;

public class TestPolicies {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {

        // First step is to configure the assets with their value with a method transfroming it into sensitivity level
        Asset patentMaterial = new Asset("patent", 600000);
        SensitivityLevel.computeAssetSensitivityLevel(patentMaterial);

        SimUser user1Cso = new SimUser("user1Cso", 160);
        new SimUser("user2Accountant", 80);
        new CorporateUserDevice();
        user1Cso.checksIfDeviceIsTrustworthyEnough();

        new Role("Accountant");

        new Group("Accountants Group");

        new Location("here", 0, 0);
        new Date(System.currentTimeMillis());

        new NetworkConnectionType("Airport public WiFi");

        new EnvironmentalContext();

        Rule beforeTimeRule1 = new BeforeTimeRule(new Date(System.currentTimeMillis()));
        Rule beforeTimeRule2 = new BeforeTimeRule(new Date(System.currentTimeMillis()));

        CombinedRule combinedRule = new CombinedRule(beforeTimeRule1, beforeTimeRule2, CombinedRuleOperator.AND);

        CorporateSecurityPolicy corporateSecuritypolicy = new CorporateSecurityPolicy(combinedRule);

        RiskPolicy riskPolicy = new RiskPolicy(RiskValue.NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY,
                corporateSecuritypolicy);

        EventProcessor musesEventProcessor = new EventProcessor();
        new RealTimeRiskTrustAnalysisEngine(musesEventProcessor, riskPolicy);

        // Decision decision = rt2ae.decidesBasedOnConfiguredRiskPolicy(
        // accessRequest, //contains retrieval of threats, risks... and users/devices...
        // currentLocation,
        // now,
        // currentNetworkType,
        // user2Laptop,
        // user2Accountant,
        // currentEnvironmentalContext,
        // currentRole, //comes from Android/iPhone Mobile Device Management
        // currentGroup); //comes from Android/iPhone Mobile Device Management

        // if (policy.fromAllowedLocation(currentLocation) &&
        // policy.atAllowedTime(now) &&
        // policy.onAllowedNetworkConnectionType(currentNetworkType) &&
        // policy.onAuthorizeddDevice(user2Laptop) &&
        // policy.byAuthorizedUser(user2Accountant) &&
        // policy.onTrustedDevice(user2Laptop) &&
        // policy.byTrustedUser(user2Accountant) &&
        // policy.onGoodEnoughEnvironmentalContext(currentEnvironmentalContext) &&
        // policy.hasAllowedRole(currentRole) &&
        // policy.isInAllowedGroup(currentGroup)) {
        //
        // }

        // A rule is mapped to a Boolean
        // D5.1

        // authorized users and terminals can become trusted
        // "Within the trusted state, the user can complete some very sensible operation, such as changes of policies."
        // ? "Any change in the configuration results in a loss of authorization or trust for the requested asset."
        // two ongoing user sessions on two different devices
        // invoke a cleaning of the stored assets...
        // local sensors collectors

        // from D8.2
        // DeviceSecurityLevel deviceSecurityLevel = new DeviceSecurityLevel();
        // if (deviceSecurityLevel >= DeviceSecurityLevel.COMPLIANT_WITH_SECURITY_POLICY ) {
        // }

    }

}
