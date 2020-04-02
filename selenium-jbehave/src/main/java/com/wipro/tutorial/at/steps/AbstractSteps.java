package com.wipro.tutorial.at.steps;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.tutorial.at.context.TestContext;

public abstract class AbstractSteps {
	
	@Autowired
	protected TestContext context;
	
	protected Logger LOG = Logger.getLogger(this.getClass());
}
