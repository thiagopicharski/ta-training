package com.wipro.tutorial.at.entities;

import com.jayway.jsonpath.DocumentContext;
import com.wipro.tutorial.at.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityUtils {

    @Autowired
    JsonUtil jsonUtil;

    public int getCartId(String cartJson){
        DocumentContext json = jsonUtil.loadJson(cartJson);
        return json.read("$.id", Integer.class);
    }
}
