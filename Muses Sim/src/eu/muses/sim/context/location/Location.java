package eu.muses.sim.context.location;

import eu.muses.sim.context.Contextable;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.vulnerability.Vulnerability;

public class Location implements Contextable {
	
    public static final Location EVERYWHERE = new Location("EVERYWHERE", 0.0, 0.0);

    private double lat;
	private double lon;
	private String name;
	
	public Location(String name, double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getName() {
		return name;
	}

	@Override
	public Probability isUnderAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vulnerability[] getVulnerabilities() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
