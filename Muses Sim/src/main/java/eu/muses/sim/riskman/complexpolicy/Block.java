package eu.muses.sim.riskman.complexpolicy;

import java.util.ArrayList;

public class Block {
	
	private ArrayList<Clause> clauses = new ArrayList<Clause>();
	private ArrayList<Operator> operators = new ArrayList<Operator>();

	public Block() {
		super();
	}
	
	public Block(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}

	/**
	 * @return the clauses
	 */
	public ArrayList<Clause> getClauses() {
		return clauses;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}

	public void addClause (Clause c){
		
		clauses.add(c);
		
	}
	
	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}

	public void addOperator (Operator o){
		
		operators.add(o);
		
	}
	
}
