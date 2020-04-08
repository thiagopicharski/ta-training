package com.wipro.tutorial.at.entity;

import com.wipro.tutorial.at.util.JsonUtil;
import com.wipro.tutorial.at.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;
@Component
public class RESTFunctions {

    @Autowired
    protected JsonUtil jsonUtil;

    protected Logger LOGGER = Logger.getLogger(getClass());

    @Value("${api.cart.create}")
    private String newCartUrl;

    @Value("${api.cart.product.add}")
    private String newProductCartUrl;

    @Value("${api.cart.product.delete}")
    private String productDeleteUrl;

    @Value("${api.cart.detail}")
    private String cartDetailUrl;

    @Value("${api.cart.product.shipment}")
    private String shipmentUrl;

    public String newCart(String product){
        return RestUtil.sendPut(newCartUrl, product);
    }

    public Integer getIdCart(String cartJson){
        return jsonUtil.loadJson(cartJson).read("$.id", Integer.class);
    }

    public String getCart(Integer id){
        return RestUtil.sendGet(String.format(cartDetailUrl, id));
    }

    public Integer getCartAmount(String cartJson){
        return jsonUtil.loadJson(cartJson).read("$.total");
    }

    public String getShipment(String shipment, Integer idCart){
        return RestUtil.sendPost(String.format(shipmentUrl, idCart), shipment);
    }

    public String newProduct(String product, Integer idCart){
        return RestUtil.sendPut(String.format(newProductCartUrl, idCart), product);
    }

    public String deleteProduct(Integer idProduct, Integer idCart){
        return RestUtil.sendDelete(String.format(productDeleteUrl, idCart, idProduct));
    }

    public Integer getProduct(String cartJson, Integer indexProduct){
        return jsonUtil.loadJson(cartJson).read(String.format("$.products[%s].id", indexProduct), Integer.class);
    }

}
