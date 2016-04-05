package org.treblereel.sfsbservlet.domain;

import java.io.Serializable;

public class TestingObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String testingProperty;
	
	public TestingObject(String testingProperty){
		this.testingProperty = testingProperty;
	}

	public String getTestingProperty() {
		return testingProperty;
	}
}
