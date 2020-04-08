package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.tutorial.at.context.TestContext;

public abstract class AbstractSteps {
	
	@Autowired
	protected TestContext context;

	@Autowired
	protected JsonUtil jsonUtil;
	
	protected Logger LOGGER = Logger.getLogger(this.getClass());

    protected abstract void createCart();
}
