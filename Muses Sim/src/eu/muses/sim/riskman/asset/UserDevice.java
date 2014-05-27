package eu.muses.sim.riskman.asset;

import java.security.Certificate;
import java.security.KeyPair;

import eu.muses.sim.RealTimeRiskTrustAnalysisEngine;
import eu.muses.sim.sim.MusesClientApp;

public abstract class UserDevice {

	private KeyPair keyPair; 
	
	private String cryptoId;
	
	private String owner;
	
	
	
	public void installs(MusesClientApp musesClientApp) {
		// TODO Auto-generated method stub
		this.keyPair = generateKeyPair();
		this.cryptoId = hashPrivateKey(keyPair);
	}

	public void installOnClient(MusesClientApp s2MusesClientApp) {
		// TODO Implement installation of MUSES application on the device
		
	}

	private KeyPair generateKeyPair() {
		return null;
	}
	
	private String hashPrivateKey(KeyPair keyPair) {
		//TODO implement hash of private key
		return null;
	}
	
	public String getCryptoId() {
		return null;
	}

	public void setOwner(String nickname) {
		// TODO Auto-generated method stub
		
	}

	public Object getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCertificate(Certificate musesCertificate) {
		// TODO Auto-generated method stub
		
	}

	public MusesCertificateRequest getCertificateSignatureRequest() {
		// TODO Auto-generated method stub
		return null;
	}
}
