/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.asset;

import java.security.KeyPair;
import java.security.cert.Certificate;

import eu.muses.sim.test.MusesClientApp;

/**
 * The Class UserDevice.
 */
public abstract class UserDevice {

    /** The key pair. */
    private KeyPair keyPair;

    /** The crypto id. */
    private String cryptoId;

    /**
     * Generate key pair.
     *
     * @return the key pair
     */
    private KeyPair generateKeyPair() {
        return null;
    }

    /**
     * Gets the certificate signature request.
     *
     * @return the certificate signature request
     */
    public MusesCertificateRequest getCertificateSignatureRequest() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Gets the crypto id.
     *
     * @return the crypto id
     */
    public String getCryptoId() {
        return null;
    }

    /**
     * Gets the owner.
     *
     * @return the owner
     */
    public Object getOwner() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Hash private key.
     *
     * @param keyPair
     *            the key pair
     * @return the string
     */
    private String hashPrivateKey(KeyPair keyPair) {
        // TODO implement hash of private key
        return null;
    }

    /**
     * Install on client.
     *
     * @param s2MusesClientApp
     *            the s2 muses client app
     */
    public void installOnClient(MusesClientApp s2MusesClientApp) {
        // TODO Implement installation of MUSES application on the device

    }

    /**
     * Installs.
     *
     * @param musesClientApp
     *            the muses client app
     */
    public void installs(MusesClientApp musesClientApp) {
        // TODO Auto-generated method stub
        this.keyPair = generateKeyPair();
        this.cryptoId = hashPrivateKey(this.keyPair);
    }

    /**
     * Sets the certificate.
     *
     * @param musesCertificate
     *            the new certificate
     */
    public void setCertificate(Certificate musesCertificate) {
        // TODO Auto-generated method stub

    }

    /**
     * Sets the owner.
     *
     * @param nickname
     *            the new owner
     */
    public void setOwner(String nickname) {
        // TODO Auto-generated method stub

    }
}
