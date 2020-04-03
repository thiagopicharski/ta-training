package com.wipro.tutorial.at.steps;

import com.wipro.tutorial.at.pages.ResultPage;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultPageSteps extends AbstractSteps {

    @Autowired
    private ResultPage resultPage;

    @When("I click on the first result")
    public void clickFirstResult(){
        resultPage.clickOnFirstResult();
    }

}
