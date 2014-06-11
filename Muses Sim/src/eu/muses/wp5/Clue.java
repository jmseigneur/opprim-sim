/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.wp5;

/**
 * The Class Clue.
 */
public class Clue {

    /** The id. */
    String id;

    /** The Constant antivirusClue. */
    public final static Clue antivirusClue = new Clue("ANTIVIRUS");

    /** The Constant vpnClue. */
    public final static Clue vpnClue = new Clue("VPN");

    /** The Constant firewallClue. */
    public final static Clue firewallClue = new Clue("FIREWALL");

    /**
     * Instantiates a new clue.
     */
    public Clue() {
        super();
    }

    /**
     * Instantiates a new clue.
     *
     * @param clueId
     *            the clue id
     */
    public Clue(String clueId) {
        super();
        this.id = clueId;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return id;
    }

}
