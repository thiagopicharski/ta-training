package com.wipro.ta.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.wipro.ta.Lista;

public class MySteps {
	
	public static Gson GSON = new Gson();
	public Map<String, Object> context = new HashMap<String, Object>();
	
	
	@Given ("a collection '<notRemoved>'")
	public void givenCollection (@Value("notRemoved") String notRemoved) {
		
		
		String json = "{list:\"" + notRemoved + "\"}";
		Lista lista = GSON.fromJson(json, Lista.class);
		
		context.put("lista", lista);
		
				
	}
	
	@When ("calculate this collection by maximum sum of all possible")
	public void whenCalculate() {
		
		List<Integer> notRemoved = new ArrayList<Integer>();
		for (Integer x : notRemoved) {
			System.out.println(x);
		}
					
		
	}
	
	@Then ("the result should be '<coefficient>'")
	public void thenResult(@Value("coefficient") String coefficient) {
		
		Assert.assertEquals("the result", coefficient);
		
 	}
	
    
}
