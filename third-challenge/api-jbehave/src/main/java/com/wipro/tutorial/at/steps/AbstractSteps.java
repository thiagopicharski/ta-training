package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.util.CartUtil;
import com.wipro.tutorial.at.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.tutorial.at.context.TestContext;

public abstract class AbstractSteps {
	
	@Autowired
	protected TestContext context;

	@Autowired
	protected JsonUtil jsonUtil;

	@Autowired
	protected CartUtil cartUtil;
	
	protected Logger logger = Logger.getLogger(this.getClass());
}
