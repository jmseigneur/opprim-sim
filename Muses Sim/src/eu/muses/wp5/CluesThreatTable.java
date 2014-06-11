/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.wp5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.threat.Threat;

/**
 * The Class CluesThreatTable.
 */
public class CluesThreatTable {

    /** The clues threat table. */
    private Collection<CluesThreatEntry> cluesThreatTable;

    /**
     * Instantiates a new clues threat table.
     */
    public CluesThreatTable() {
        super();
        this.cluesThreatTable = new Vector<CluesThreatEntry>();
    }

    /**
     * Instantiates a new clues threat table.
     *
     * @param cluesThreatTable
     *            the clues threat table
     */
    public CluesThreatTable(Collection<CluesThreatEntry> cluesThreatTable) {
        super();
        this.cluesThreatTable = cluesThreatTable;
    }

    /**
     * Adds the mapping.
     *
     * @param clues
     *            the clues
     * @param threat
     *            the threat
     */
    public void addMapping(List<Clue> clues, Threat threat) {

        CluesThreatEntry mapping = new CluesThreatEntry(clues, threat);
        this.cluesThreatTable.add(mapping);

    }

    /**
     * Gets the clues threat table.
     *
     * @return the clues threat table
     */
    public Collection<CluesThreatEntry> getCluesThreatTable() {
        return this.cluesThreatTable;
    }

    /**
     * Gets the threats from clues.
     *
     * @param clues
     *            the clues
     * @return the threats from clues
     */
    public List<Threat> getThreatsFromClues(List<Clue> clues) {
        List<Threat> threats = new ArrayList<Threat>();
        for (CluesThreatEntry entry : this.cluesThreatTable) {
            if (entry.containsClues(clues)) {
                threats.add(entry.getThreat());
            }
        }
        return threats;
    }

    /**
     * Sets the clues threat table.
     *
     * @param cluesThreatTable
     *            the new clues threat table
     */
    public void setCluesThreatTable(Collection<CluesThreatEntry> cluesThreatTable) {
        this.cluesThreatTable = cluesThreatTable;
    }
    
    public void updateThreatProbability(Threat threat){
    	
    	for (CluesThreatEntry entry : cluesThreatTable) {
			if(entry.getThreat() == threat){
				Threat temp = entry.getThreat();
				double newProbability = temp.getBadOutcomeCount()/ temp.getOccurences();
				temp.setProbability(new Probability(newProbability));
				entry.setThreat(temp);
			}
		}
    	
    }
    
 public void updateThreatOccurences(Threat threat){
    	
    	for (CluesThreatEntry entry : cluesThreatTable) {
			if(entry.getThreat() == threat){
				Threat temp = entry.getThreat();
				double newOccurence = temp.getOccurences() + 1;
				temp.setOccurences(newOccurence);
				entry.setThreat(temp);
			}
		}
    	
    }
 
 public void updateThreatBadOutcomeCount(Threat threat){
 	
 	for (CluesThreatEntry entry : cluesThreatTable) {
			if(entry.getThreat() == threat){
				Threat temp = entry.getThreat();
				double newBadOutcomeCount = temp.getBadOutcomeCount() + 1;
				temp.setBadOutcomeCount(newBadOutcomeCount);
				entry.setThreat(temp);
			}
		}
 	
 }

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	// TODO Auto-generated method stub
	String toString = "Content of the table is:\n";
	for (CluesThreatEntry entry : cluesThreatTable){
		toString = toString.concat("Clues: ");
		for (Clue clue : entry.getClues()) {
			toString = toString.concat(clue.getId() + " - ");
		}
		toString = toString.concat("Threat: ");
		toString = toString.concat(entry.getThreat().getDescription() + "\n");		
	}
	
	return toString;
}
 
 

}
