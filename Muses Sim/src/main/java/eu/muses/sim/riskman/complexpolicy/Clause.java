package eu.muses.sim.riskman.complexpolicy;

public class Clause {
	
	private Argument arg;
	private Operator op;
	private double value;

	public Clause() {
		super();
	}
	
	public Clause(Argument arg, Operator op, double val) {
		super();
		this.arg = arg;
		this.op = op;
		this.value = val;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return arg.getTextualRepresentation() + op.getTextualRepresentation() + value;
	}
	
	public String toLogicalString(){
		
		return arg.getLogical_representation() + op.getLogical_representation() + value;
		
	}

}
