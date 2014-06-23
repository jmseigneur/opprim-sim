/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.context.location;

import eu.muses.sim.context.Contextable;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.vulnerability.Vulnerability;

/**
 * The Class Location.
 */
public class Location implements Contextable {

	/** The Constant EVERYWHERE. */
	public static final Location EVERYWHERE = new Location("EVERYWHERE", 0.0,
			0.0);

	/** The lat. */
	private double lat;

	/** The lon. */
	private double lon;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new location.
	 *
	 * @param name
	 *            the name
	 * @param lat
	 *            the lat
	 * @param lon
	 *            the lon
	 */
	public Location(String name, double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
	}

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return this.lat;
	}

	/**
	 * Gets the lon.
	 *
	 * @return the lon
	 */
	public double getLon() {
		return this.lon;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.muses.sim.context.Contextable#getVulnerabilities()
	 */
	@Override
	public Vulnerability[] getVulnerabilities() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.muses.sim.context.Contextable#isUnderAttack()
	 */
	@Override
	public Probability isUnderAttack() {
		// TODO Auto-generated method stub
		return null;
	}

}
