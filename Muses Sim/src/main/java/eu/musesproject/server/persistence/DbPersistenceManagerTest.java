package eu.musesproject.server.persistence;

import static org.junit.Assert.*;


import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import eu.muses.sim.Outcome;
import eu.muses.sim.request.AccessRequest;
import eu.muses.sim.riskman.RiskPolicy;
import eu.muses.sim.riskman.asset.Asset;
import eu.muses.sim.riskman.opportunity.Opportunity;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.test.SimUser;
import eu.muses.wp5.Clue;
import eu.muses.wp5.CluesThreatEntry;
import eu.muses.wp5.CluesThreatTable;

public class DbPersistenceManagerTest {
	
	static DbPersistenceManager dbmanager = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dbmanager = new DbPersistenceManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetOutcomes() {
		List<Outcome> List = dbmanager.getOutcomes();
		if (List.size()>0){
			Iterator<Outcome> i = List.iterator();
			while(i.hasNext()){
				Outcome outcome = i.next();
				assertNotNull(outcome);
			}
		}else{
			fail("There is not any outcome in the database,please first try to store outcome in the database");

		}
	}

	@Test
	public final void testSetOutcomes() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetOpportunities() {
		List<Opportunity> List = dbmanager.getOpportunities();
		if (List.size()>0){
			Iterator<Opportunity> i = List.iterator();
			while(i.hasNext()){
				Opportunity opportunity = i.next();
				assertNotNull(opportunity);
			}
		}else{
			fail("There is not any Opportunity in the database,please first try to store Opportunity in the database");
		}	}

	@Test
	public final void testSetOpportunities() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAssets() {
		List<Asset> List = dbmanager.getAssets();
		if (List.size()>0){
			Iterator<Asset> i = List.iterator();
			while(i.hasNext()){
				Asset asset = i.next();
				assertNotNull(asset);
			}
		}else{
			fail("There is not any Asset in the database,please first try to store Asset in the database");
		}		
	}

	@Test
	public final void testSetAssets() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetThreats() {
		List<Threat> list = dbmanager.getThreats();
		if(list.size()>0){
			Iterator<Threat> i = list.iterator();
			while(i.hasNext()){
				Threat threat = i.next();
				assertNotNull(threat);
				if(threat.getOutcomes().size()>0){
					Iterator<Outcome> it = threat.getOutcomes().iterator();
					while(it.hasNext()){
						Outcome outcome = it.next();
						assertNotNull(outcome);

					}	
				}else{
					fail("There is not one or several Threat with no  Outcome in the database ,please first try to store threat with Oucome  in the database");
				}
			}
		}
		else{
			fail("There is not a Threat with no  Outcome in the database ,please first try to store threat with Oucome  in the database");
		}		
	}
			

	@Test
	public final void testSetThreats() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetClues() {
		List<Clue> List = dbmanager.getClues();
		if (List.size()>0){
			Iterator<Clue> i = List.iterator();
			while(i.hasNext()){
				Clue clue = i.next();
				assertNotNull(clue);
			}
		}else{
			fail("There is not any Clue in the database,please first try to store Clue in the database");
		}			
	}

	@Test
	public final void testSetClues() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetRiskPolicies() {
		List<RiskPolicy> List = dbmanager.getRiskPolicies();
		if (List.size()>0){
			Iterator<RiskPolicy> i = List.iterator();
			while(i.hasNext()){
				RiskPolicy riskpolicy = i.next();
				assertNotNull(riskpolicy);
			}
		}else{
			fail("There is not any RiskPolicy in the database,please first try to store RiskPolicy in the database");
		}	
	}

	@Test
	public final void testSetRiskPolicies() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetSimUsers() {
		List<eu.muses.sim.test.SimUser> List = dbmanager.getSimUsers();
		if (List.size()>0){
			Iterator<SimUser> i = List.iterator();
			while(i.hasNext()){
				SimUser simuser = i.next();
				assertNotNull(simuser);
			}
		}else{
			fail("There is not any SimUser in the database,please first try to store SimUser in the database");
		}
	}

	@Test
	public final void testSetSimUsers() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetCluesThreatTable() {
		CluesThreatTable cluesthreattable = dbmanager.getCluesThreatTable();
		if(cluesthreattable!=null){
			Iterator<CluesThreatEntry> i = cluesthreattable.getCluesThreatTable().iterator();
			while(i.hasNext()){
				CluesThreatEntry cluesthreatentry = i.next();
				Threat threat = cluesthreatentry.getThreat();
				assertNotNull(threat);
				if(threat.getOutcomes().size()>0){
					Iterator<Outcome> its = threat.getOutcomes().iterator();
					while(its.hasNext()){
						Outcome outcome = its.next();
						assertNotNull(outcome);
					}
				}else{
					fail("Size of list of Outcome is equal to 0 "); 
				}	
			}
		}
		else{
			fail("Threat is null"); 

		}
		
	}

	@Test
	public final void testSetCluesThreatTable() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetAccessRequests() {
		List<AccessRequest> list = dbmanager.getAccessRequests();
		
		if(list.size()>0){
			Iterator<AccessRequest> i = list.iterator();
			while(i.hasNext()){
				AccessRequest accessrequests = i.next();
				assertNotNull(accessrequests.getUser());
				assertNotNull(accessrequests.getTime());
				assertNotNull(accessrequests.getUserAction());
				assertNotNull(accessrequests.getCluesThreatEntry().getThreat());
				
				Iterator<Outcome> its = accessrequests.getOpportunityDescriptor().getOutcomes().iterator();
				while(its.hasNext()){
					Outcome outcome = its.next();
					//assertNotNull(outcome);
				}
				
				Iterator<Asset> ist = accessrequests.getOpportunityDescriptor().getRequestedAssets().iterator();
				while(ist.hasNext()){	
					Asset asset = ist.next();
					assertNotNull(asset);
				}
				
				Iterator<Outcome> ists = accessrequests.getCluesThreatEntry().getThreat().getOutcomes().iterator();
				while(ists.hasNext()){
					Outcome outcome = ists.next();
					assertNotNull(outcome);
				}
				
				Iterator<Clue> sit = accessrequests.getCluesThreatEntry().getClues().iterator();
				while(sit.hasNext()){
					Clue clue = sit.next();
					assertNotNull(clue);
				}
				
			}
		}else{
			
		}
			
	}

	@Test
	public final void testSetAccessRequests() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testAnonymizeAccessReqeuests() {
		fail("Not yet implemented"); // TODO
	}

}
