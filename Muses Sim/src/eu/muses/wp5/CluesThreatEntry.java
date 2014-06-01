/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.wp5;

import java.util.List;

import eu.muses.sim.riskman.threat.Threat;

/**
 * The Class CluesThreatEntry.
 */
public class CluesThreatEntry {

    /** The clues. */
    private List<Clue> clues;

    /** The threat. */
    private Threat threat;

    /**
     * Instantiates a new clues threat entry.
     */
    public CluesThreatEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new clues threat entry.
     *
     * @param clues
     *            the clues
     * @param threat
     *            the threat
     */
    public CluesThreatEntry(List<Clue> clues, Threat threat) {
        super();
        this.clues = clues;
        this.threat = threat;
    }

    /**
     * Contains clues.
     *
     * @param clueList
     *            the clue list
     * @return true, if successful
     */
    public boolean containsClues(List<Clue> clueList) {

        int count = 0;
        for (Clue clue : this.clues) {
            if (clueList.contains(clue)) {
                count++;
            }
        }

        if (count == this.clues.size()) {
            return true;
        }

        return false;

    }

    /**
     * Gets the clues.
     *
     * @return the clues
     */
    public List<Clue> getClues() {
        return this.clues;
    }

    /**
     * Gets the threat.
     *
     * @return the threat
     */
    public Threat getThreat() {
        return this.threat;
    }

    /**
     * Sets the clues.
     *
     * @param clues
     *            the new clues
     */
    public void setClues(List<Clue> clues) {
        this.clues = clues;
    }

    /**
     * Sets the threat.
     *
     * @param threat
     *            the new threat
     */
    public void setThreat(Threat threat) {
        this.threat = threat;
    }

}
