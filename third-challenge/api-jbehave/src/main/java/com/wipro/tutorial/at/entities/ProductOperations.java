package com.wipro.tutorial.at.entities;

import com.wipro.tutorial.at.util.JsonUtil;
import com.wipro.tutorial.at.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductOperations {

    @Autowired
    private JsonUtil jsonUtil;

    @Value("${api.product.detail}")
    private String productDetailUrl;

    public String getProduct(int id){
        return RestUtil.sendGet(String.format(productDetailUrl, id));
    }
}
