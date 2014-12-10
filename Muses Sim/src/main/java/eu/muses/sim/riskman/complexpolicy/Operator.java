package eu.muses.sim.riskman.complexpolicy;

public class Operator {
	
	private String textual_representation;
	private String logical_representation;
	
	/** Pre-defined Operators */
	public static Operator PLUS = new Operator("+","+");
	public static Operator MINUS = new Operator("-","-");
	public static Operator EQUAL = new Operator("=","==");
	public static Operator DIFFERENT = new Operator("<>","!=");
	public static Operator GREATER = new Operator(">",">");
	public static Operator LOWER = new Operator("<","<");
	public static Operator GREATER_EQUAL = new Operator(">=",">=");
	public static Operator LOWER_EQUAL = new Operator("<=","<=");
	public static Operator IF = new Operator("IF","IF");
	public static Operator ELSE = new Operator("ELSE","ELSE");
	public static Operator THEN = new Operator("THEN","THEN");
	public static Operator AND = new Operator("AND","&&");
	public static Operator OR = new Operator("OR","||");
	public static Operator NOT = new Operator("NOT","NOT");
	public static Operator OP_PAR = new Operator("(","(");
	public static Operator CL_PAR = new Operator(")",")");

	public Operator() {
		super();
	}
	
	public Operator(String t_rep, String l_rep) {
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
