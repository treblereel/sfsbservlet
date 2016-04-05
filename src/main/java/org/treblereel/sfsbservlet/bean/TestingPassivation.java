package org.treblereel.sfsbservlet.bean;

import javax.ejb.Local;

import org.treblereel.sfsbservlet.domain.TestingObject;

@Local
public interface TestingPassivation {

	void setTestingObject(TestingObject testingObject);
	
	TestingObject getTestingObject();

}
