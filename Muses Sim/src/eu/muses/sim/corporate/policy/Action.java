package eu.muses.sim.corporate.policy;

public class Action {
	
	public static final Action WIPE_ALL = new Action("Wipe all");
	public static final Action LOCK = new Action("Lock");
	
	private String name;

	public Action(String name) {
		super();
		this.name = name;
	}

}
