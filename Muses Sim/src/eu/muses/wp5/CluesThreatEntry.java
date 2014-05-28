package eu.muses.wp5;

import java.util.List;

import eu.muses.sim.riskman.threat.Threat;

public class CluesThreatEntry {
	
	private List<Clue> clues;
	private Threat threat;
	public CluesThreatEntry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CluesThreatEntry(List<Clue> clues, Threat threat) {
		super();
		this.clues = clues;
		this.threat = threat;
	}
	public List<Clue> getClues() {
		return clues;
	}
	public void setClues(List<Clue> clues) {
		this.clues = clues;
	}
	public Threat getThreat() {
		return threat;
	}
	public void setThreat(Threat threat) {
		this.threat = threat;
	}
	
	public boolean containsClues(List<Clue> clueList){
		
		int count = 0;
		for (Clue clue : clues) {
		if(clueList.contains(clue));
		count++;
		}
		
		if(count == clues.size())
		return true;
		
		return false;
		
	}

}
