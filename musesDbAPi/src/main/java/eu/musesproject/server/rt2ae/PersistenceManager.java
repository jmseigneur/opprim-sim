/**
 * 
 */
package eu.musesproject.server.rt2ae;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xavier
 *
 */
public class PersistenceManager {

	/**
	 * 
	 */
	
	public PersistenceManager() {
		
		// TODO Auto-generated constructor stub
	}
	
	public static List<Opportunity> getOpportunities() {
		return null;
	}
	
	@SuppressWarnings({"resource" })
	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");
		User u = new User();
		
		//u.findAllUsers()
		
		
		System.out.println(u.findAllUsers().toString());
	}	
	
	

}
