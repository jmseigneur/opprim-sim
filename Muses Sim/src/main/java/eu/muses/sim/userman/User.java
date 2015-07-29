/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.userman;

import java.util.Vector;

import eu.muses.sim.request.AccessRequest;

/**
 * The Class User.
 */
public class User {

	/** The access requests. */
	private Vector<AccessRequest> accessRequests = new Vector<AccessRequest>();

	/** The nickname. */
	private String nickname;
	
	private String password;

	/**
	 * Instantiates a new user.
	 *
	 * @param nickname
	 *            the nickname
	 */
	public User(String nickname, String password) {
		super();
		this.nickname = nickname;
		this.password = password;
	}

	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname() {
		return this.nickname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nickname;
	}

	public String getPassword() {
		return password;
	}

	
	

}
