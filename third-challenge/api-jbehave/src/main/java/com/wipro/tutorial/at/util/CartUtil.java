package com.wipro.tutorial.at.util;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
public class CartUtil {


    public static List<String> createProducts(){

       List<String> products= new ArrayList<>();
       products.add("{ \"description\": \"apple\", \"id\": 1, \"value\": 6, \"weight\": 5 }");
       products.add("{ \"description\": \"lemon\", \"id\": 1, \"value\": 9, \"weight\": 3 }");



        return products;
    }

    public CartUtil() {
    }
}
