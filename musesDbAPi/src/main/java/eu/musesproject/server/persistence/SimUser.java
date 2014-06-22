/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.musesproject.server.persistence;




/**
 * The Class SimUser.
 */
public class SimUser  {

	/** The hourly cost. */
	private double hourlyCost;

	/** The TrustValue */
	private double trustValue;

	private String nickname;

	/**
	 * @return the hourlyCost
	 */
	public double getHourlyCost() {
		return hourlyCost;
	}

	/**
	 * @param hourlyCost the hourlyCost to set
	 */
	public void setHourlyCost(double hourlyCost) {
		this.hourlyCost = hourlyCost;
	}

	/**
	 * @return the trustValue
	 */
	public double getTrustValue() {
		return trustValue;
	}

	/**
	 * @param trustValue the trustValue to set
	 */
	public void setTrustValue(double trustValue) {
		this.trustValue = trustValue;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimUser [hourlyCost=" + hourlyCost + ", trustValue="
				+ trustValue + ", nickname=" + nickname + "]";
	}

	
}
