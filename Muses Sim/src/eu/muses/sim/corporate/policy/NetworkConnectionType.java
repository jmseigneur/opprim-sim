/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.corporate.policy;

/**
 * The Class NetworkConnectionType.
 */
public class NetworkConnectionType {

    /** The name. */
    private String name;

    /** The Constant COMPANY_INTRANET. */
    public final static NetworkConnectionType COMPANY_INTRANET = new NetworkConnectionType("Company Intranet");

    /** The Constant VPN. */
    public final static NetworkConnectionType VPN = new NetworkConnectionType("VPN");

    /** The Constant EXTERNAL. */
    public final static NetworkConnectionType EXTERNAL = new NetworkConnectionType("External");

    /**
     * Instantiates a new network connection type.
     *
     * @param name
     *            the name
     */
    public NetworkConnectionType(String name) {
        super();
        this.name = name;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

}
