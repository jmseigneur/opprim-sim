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
        // this.cluesThreatTable = new Vector<CluesThreatEntry>();
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

}
