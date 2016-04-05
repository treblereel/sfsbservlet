package org.treblereel.sfsbservlet.bean;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

import org.treblereel.sfsbservlet.domain.TestingObject;

@Stateful
@StatefulTimeout(unit = java.util.concurrent.TimeUnit.SECONDS, value = 1)
public class TestingPassivationBean implements TestingPassivation {

	private TestingObject testingObject;
	
	@PostConstruct
	public void postConstract(){
		System.out.println("postConstract");
	}
	
	@Override
	public void setTestingObject(TestingObject testingObject) {
		this.testingObject = testingObject;	
	}

	@Override
	public TestingObject getTestingObject() {
		return testingObject;
	}
	
	@PrePassivate
	private void prePassivate(){
		System.out.println("Passivating EJB. Property value: " 
			+ testingObject.getTestingProperty());
	}
	
	@PostActivate
	private void postActivate(){
		// Reinitialize resources (ex: JDBC connections)
		// ...
		
		System.out.println("Activating EJB. Property value: " 
			+ testingObject.getTestingProperty());
	}

}
