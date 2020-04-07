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
        return jsonUtil.loadJson(cartJson).read("$.id", Integer.class);
    }

    public int getProductsLen(String cartJson){
        return jsonUtil.loadJson(cartJson).read("$.products.length()", Integer.class);
    }

    public int getNthProductId(String cartJson, int productIndex){
        return jsonUtil.loadJson(cartJson)
                .read(String.format("$.products[%s].id", productIndex), Integer.class);
    }
}
