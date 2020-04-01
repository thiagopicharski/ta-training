package com.wipro.ta.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.wipro.ta.Lista;

public class MySteps {
	
	public static Gson GSON = new Gson();
	public Map<String, Object> context = new HashMap<String, Object>();
//	private static com.wipro.ta.LikeToTimeDishes LikeToTimeDishes = new com.wipro.ta.LikeToTimeDishes();
	
	
	@Given ("a collection '<notRemoved>'")
	public void givenCollection (@Value("notRemoved") String notRemoved) {
		String json = "{list:\"" + list + "\"}";
		Lista lista = GSON.fromJson(json, Lista.class);
		
		context.put("lista", lista);
		
	}
	
	@When ("calculate this collection by maximum sum of all possible '<list>'")
	public void whenCalculate(@Value("list") String list) {
		
		ArrayList<Integer> vect = new ArrayList<Integer>();
		double[] vects = new double [3];
		
		for(int i=0; i<3; i++) {
			
			
		}
		
		
		
	}
	
	@Then ("the result should be '<coefficient>'")
	public void thenResult(@Value("coefficient") String coefficient) {
		
	}
	
    
}
