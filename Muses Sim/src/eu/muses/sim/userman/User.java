package eu.muses.sim.userman;

import java.util.Vector;

import eu.muses.sim.request.AccessRequest;


public class User {
	
	private Vector<AccessRequest> accessRequests = new Vector<AccessRequest>();
	
	private String nickname;

	public User(String nickname) {
		super();
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}
	
	

}
