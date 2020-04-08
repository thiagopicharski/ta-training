package com.wipro.tutorial.at.support;

import com.wipro.tutorial.at.util.JsonUtil;
import com.wipro.tutorial.at.util.RestUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CartSupport {
    @Autowired
    protected JsonUtil jsonUtil;

    protected Logger LOGGER = Logger.getLogger(this.getClass());

    @Value("${api.cart.detail}")
    private String cartInfoUrl;
    @Value("${api.cart.list}")
    private String cartListUrl;
    @Value("${api.cart.product.list}")
    private String productsInCartUrl;
    @Value("${api.cart.product.add}")
    private String addProductUrl;
    @Value("${api.cart.create}")
    private String newCartUrl;
    @Value("${api.cart.product.delete}")
    private String removeProductUrl;
    @Value("${api.cart.product.shipment}")
    private String shipmentUrl;

    public String getCart(int id){
        return RestUtil.sendGet(String.format(cartInfoUrl, id));
    }

    public String cartList(){
        return RestUtil.sendGet(cartListUrl);
    }

    public String productsInCart(int id){
        return RestUtil.sendGet(String.format(productsInCartUrl, id));
    }

    public String addProduct(String product, int cartId){
        return RestUtil.sendPut(String.format(addProductUrl, cartId), product);
    }

    public String newCart(String product){
        return RestUtil.sendPut(newCartUrl, product);
    }

    public String removeProduct(int productId, int cartId){
        return RestUtil.sendDelete(String.format(removeProductUrl, cartId, productId));
    }

    public String determineShipment(String shipment, int cartId){
        return RestUtil.sendPost(String.format(shipmentUrl, cartId), shipment);
    }
}