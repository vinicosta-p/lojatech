package com.pecastech.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.el.lang.ELArithmetic.BigDecimalDelegate;
import org.json.JSONArray;
import org.json.JSONObject;
import com.pecastech.app.dto.ItemRegistrationDto;
import com.pecastech.app.model.Product;
import com.pecastech.app.repository.ProductRepository;

import java.math.BigDecimal;

@Service
public class ProductService {
    
    @Autowired
    AliexpressService aliexpressService;

    @Autowired
    ProductRepository repository;

    public Product insert(ItemRegistrationDto itemRegistrationDto){
        Product product = new Product();

        String aliexJson = aliexpressService.getItem(itemRegistrationDto.id());
        /* 
        RestTemplate abc = new RestTemplate();
        String aliexJson = abc.getForEntity("https://604b2e53-8673-48f4-aad2-994499634da3.mock.pstmn.io/teste", String.class).getBody();
        */
       
        JSONObject json = new JSONObject(aliexJson);

        JSONObject item = json.getJSONObject("result").getJSONObject("item");;

        JSONObject priceData = item.getJSONObject("sku").getJSONArray("base").getJSONObject(0);
        BigDecimal price = priceData.getBigDecimal("price");
        BigDecimal promotionPrice = priceData.getBigDecimal("promotionPrice");
        int quantity = priceData.getInt("quantity");
    
        product.setShopId(itemRegistrationDto.id());
        product.setName(item.getString("title"));
        product.setImage(item.getJSONArray("images").getString(0));
        // adicionar margin
        product.setPrice(price);
        product.setPromotionPrice(promotionPrice);
        
        product.setQuantity(quantity);
        product.setIsAvailable(quantity >= 1);
        
        BigDecimal profitMargin = new BigDecimal(itemRegistrationDto.profitMargin());
        product.setProfitMargin(profitMargin);

        JSONArray delivery = json.getJSONObject("result").getJSONObject("delivery").getJSONArray("shippingList").getJSONObject(0).getJSONArray("note");

        product.setFreight(delivery.getString(0));
        product.setEstimatedTime(delivery.getString(2));
            
        //repository.save(product);

        return product;
    }

    public Product insert(Product product){
        return new Product();
    }
    
}
