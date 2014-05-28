package eu.muses.wp5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import eu.muses.sim.riskman.threat.Threat;

public class CluesThreatTable {

	private Collection<CluesThreatEntry> cluesThreatTable;

	public CluesThreatTable() {
		super();
		//this.cluesThreatTable = new Vector<CluesThreatEntry>();
	}

	public CluesThreatTable(Collection<CluesThreatEntry> cluesThreatTable) {
		super();
		this.cluesThreatTable = cluesThreatTable;
	}

	public Collection<CluesThreatEntry> getCluesThreatTable() {
		return cluesThreatTable;
	}

	public void setCluesThreatTable(
			Collection<CluesThreatEntry> cluesThreatTable) {
		this.cluesThreatTable = cluesThreatTable;
	}

	public void addMapping(List<Clue> clues, Threat threat) {

		CluesThreatEntry mapping = new CluesThreatEntry(clues, threat);
		this.cluesThreatTable.add(mapping);

	}

	public List<Threat> getThreatsFromClues(List<Clue> clues) {

		List<Threat> threats = new ArrayList<Threat>();
		for (CluesThreatEntry entry : this.cluesThreatTable) {
			if (entry.containsClues(clues))
				threats.add(entry.getThreat());
		}
		
		return threats;

	}

}
