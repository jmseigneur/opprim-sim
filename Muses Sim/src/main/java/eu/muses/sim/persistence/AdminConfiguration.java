package eu.muses.sim.persistence;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import eu.muses.sim.riskman.complexpolicy.ComplexPolicy;

public class AdminConfiguration  {
	
	String Rules;
	String Connection;
	String Zone;
	ComplexPolicy CompleyRiskPolicy;
	
	public AdminConfiguration() {
	
	}

	public String getRules() {
		return Rules;
	}

	public void setRules(String rules) {
		Rules = rules;
	}

	public String getConnection() {
		return Connection;
	}

	public void setConnection(String connection) {
		Connection = connection;
	}

	public String getZone() {
		return Zone;
	}

	public void setZone(String zone) {
		Zone = zone;
	}

	public ComplexPolicy getCompleyRiskPolicy() {
		return CompleyRiskPolicy;
	}

	public void setCompleyRiskPolicy(ComplexPolicy riskPolicy) {
		CompleyRiskPolicy = riskPolicy;
	}

	

}
