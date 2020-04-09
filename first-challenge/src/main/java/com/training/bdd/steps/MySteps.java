package com.training.bdd.steps;

import com.google.gson.Gson;
import com.training.bdd.classes.LikeToTimeDishes;
import com.training.bdd.classes.IntArrayDishes;
import junit.framework.Assert;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MySteps {

	private static Gson GSON = new Gson();
	private static LikeToTimeDishes contextSolution;
	private static int[] contextArray;

	@Given("I used an array '$list' of dishes")
	public void tetingGiven(@Value("list") String list) {
		String json = "{list:" + list + "}";
		IntArrayDishes aux = GSON.fromJson(json, IntArrayDishes.class);
		contextArray = ArrayUtils.toPrimitive(aux.getList().toArray(new Integer[0]));
		System.out.println(contextSolution.calculateSolution(contextArray).toString());
	}

	@When("I remove the dishes '$positionListToRemove'")
	public void testingWhen(@Value("positionListToRemove") String positionListToRemove) {
		String json = "{list:" + positionListToRemove + "}";
		IntArrayDishes positions = GSON.fromJson(json, IntArrayDishes.class);
		int[] arrayDishesUpdate;
	}
	
	@Then("the current output must be '$result'")
	public void testingThen() {
		System.out.println("Then nerkcne");
	}
    
}
