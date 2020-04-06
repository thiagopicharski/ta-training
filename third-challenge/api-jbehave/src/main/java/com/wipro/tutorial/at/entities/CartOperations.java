package com.wipro.tutorial.at.entities;

import com.wipro.tutorial.at.util.JsonUtil;
import com.wipro.tutorial.at.util.RestUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartOperations {
    @Autowired
    protected JsonUtil jsonUtil;

    protected Logger LOGGER = Logger.getLogger(this.getClass());

    @Value("${api.cart.detail}")
    private String cartDetailUrl;
    @Value("${api.cart.list}")
    private String listCartsUrl;
    @Value("${api.cart.product.list}")
    private String productListUrl;
    @Value("${api.cart.product.add}")
    private String addProductCartUrl;
    @Value("${api.cart.create}")
    private String createCartUrl;
    @Value("${api.cart.product.delete}")
    private String productRemoveUrl;
    @Value("${api.cart.product.shipment}")
    private String shipmentUrl;

    public String getCard(int id){
        return RestUtil.sendGet(String.format(cartDetailUrl, id));
    }

    public String listCarts(){
        return RestUtil.sendGet(listCartsUrl);
    }

    public String listCartProducts(int id){
        return RestUtil.sendGet(String.format(productListUrl, id));
    }

    public String addProduct(String product, int cartId){
        return RestUtil.sendPut(String.format(addProductCartUrl, cartId), product);
    }

    public String createCart(String product){
        return RestUtil.sendPut(createCartUrl, product);
    }

    public String removeItem(int productId, int cartId){
        return RestUtil.sendDelete(String.format(productRemoveUrl, cartId, productId));
    }

    public String calculateShipment(String shipment, int cartId){
        return RestUtil.sendPost(String.format(shipmentUrl, cartId), shipment);
    }
}
