package eu.muses.sim.riskman.complexpolicy;

import java.util.ArrayList;
import java.util.Arrays;

public class Argument {
	
	private String textual_representation;
	private String logical_representation;
	
	/** Pre-defined Arguments */
	public static Argument C_OPP_THREATS_MAX = new Argument("Max. threat cost","a");
	public static Argument P_OPP_THREATS_MAX = new Argument("Max. threat prob","b");
	public static Argument B_OPP__MAX = new Argument("Max. opp benefit","c");
	public static Argument P_OPP_MAX = new Argument("Max. opp prob","d");
	public static Argument P_BENEFIT_COST = new Argument("Probability of benefit","e");
	
	/** Allowed operators */
	public ArrayList<Operator> allowedOperators = new ArrayList<Operator>(Arrays.asList(Operator.EQUAL, Operator.DIFFERENT, Operator.LOWER, Operator.GREATER, Operator.LOWER_EQUAL, Operator.GREATER_EQUAL));

	public Argument() {
		super();
	}
	
	public Argument(String t_rep, String l_rep) {
		super();
		this.textual_representation = t_rep;
		this.logical_representation = l_rep;
	}

	/**
	 * @return the textual_representation
	 */
	public String getTextualRepresentation() {
		return textual_representation;
	}

	/**
	 * @param textual_representation the textual representation to set
	 */
	public void setTextualRepresentation(String t_rep) {
		this.textual_representation = t_rep;
	}
	

	/**
	 * @return the logical_representation
	 */
	public String getLogical_representation() {
		return logical_representation;
	}

	/**
	 * @param logical_representation the logical_representation to set
	 */
	public void setLogical_representation(String logical_representation) {
		this.logical_representation = logical_representation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.textual_representation;
	}	

}
