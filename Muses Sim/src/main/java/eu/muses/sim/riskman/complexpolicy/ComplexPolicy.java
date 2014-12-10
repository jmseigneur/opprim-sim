package eu.muses.sim.riskman.complexpolicy;

import java.util.ArrayList;

import eu.muses.sim.decision.Decision;

public class ComplexPolicy {
	
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Operator> operators = new ArrayList<Operator>();
	private ArrayList<Argument> arguments = new ArrayList<Argument>();
	private String textPolicy = "";
	private String logicalPolicy = "";
	private ArrayList<Decision> decisions = new ArrayList<Decision>();
	private String name = "";

	public ComplexPolicy() {
		super();
	}
	
	public ComplexPolicy(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	/**
	 * @return the blocks
	 */
	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	/**
	 * @param blocks the blocks to set
	 */
	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}
	
	public void addBlock(Block b) {
		this.blocks.add(b);
	}

	/**
	 * @return the operators
	 */
	public ArrayList<Operator> getOperators() {
		return operators;
	}

	/**
	 * @param operators the operators to set
	 */
	public void setOperators(ArrayList<Operator> operators) {
		this.operators = operators;
	}
	
	public void addOperator(Operator o) {
		this.operators.add(o);
	}

	/**
	 * @return the textPolicy
	 */
	public String getTextPolicy() {
		return textPolicy;
	}

	/**
	 * @param textPolicy the textPolicy to set
	 */
	public void setTextPolicy(String textPolicy) {
		this.textPolicy = textPolicy;
	}
	
	public void editTextPolicy(String edit){
		
		this.textPolicy = this.textPolicy.concat(edit);
		
	}

	/**
	 * @return the logicalPolicy
	 */
	public String getLogicalPolicy() {
		return logicalPolicy;
	}

	/**
	 * @param logicalPolicy the logicalPolicy to set
	 */
	public void setLogicalPolicy(String logicalPolicy) {
		this.logicalPolicy = logicalPolicy;
	}

	public void editLogicalPolicy(String edit){
		
		this.logicalPolicy = this.logicalPolicy.concat(edit);
		
	}
	
	/**
	 * @return the clauses
	 */
	public ArrayList<Argument> getArguments() {
		return arguments;
	}

	/**
	 * @param clauses the clauses to set
	 */
	public void setArguments(ArrayList<Argument> arguments) {
		this.arguments = arguments;
	}
	
	public void addArgument(Argument c) {
		this.arguments.add(c);
	}

	/**
	 * @return the decisions
	 */
	public ArrayList<Decision> getDecisions() {
		return decisions;
	}

	/**
	 * @param decisions the decisions to set
	 */
	public void setDecisions(ArrayList<Decision> decisions) {
		this.decisions = decisions;
	}
	
	public void addDecision(Decision d) {
		this.decisions.add(d);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
