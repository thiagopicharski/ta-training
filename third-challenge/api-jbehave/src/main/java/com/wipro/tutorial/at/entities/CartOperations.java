package com.wipro.tutorial.at.entities;

import com.wipro.tutorial.at.util.JsonUtil;
import com.wipro.tutorial.at.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CartOperations {
    @Autowired
    protected JsonUtil jsonUtil;

    protected Logger LOGGER = Logger.getLogger("root");

    @Value("${api.cart.product.add}")
    private String addProductCartUrl;
    @Value("${api.cart.product.create}")
    private String createCartUrl;
    @Value("${api.cart.product.delete}")
    private String productRemoveUrl;
    @Value("${api.cart.product.shipment}")
    private String shipmentUrl;


    public String addProduct(String product, int cartId){
        return RestUtil.sendPut(String.format(addProductCartUrl, cartId), product);
    }

    public String createCart(String product){
        return RestUtil.sendPut(createCartUrl, product);
    }

    public String removeItem(int productId, int cartId){
        return RestUtil.sendDelete(String.format(productRemoveUrl), cartId, productId));
    }








}
