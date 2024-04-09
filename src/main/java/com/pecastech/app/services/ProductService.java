package com.pecastech.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONArray;
import org.json.JSONObject;
import com.pecastech.app.dto.AliexpressDto;
import com.pecastech.app.dto.StockDto;
import com.pecastech.app.model.Product;
import com.pecastech.app.repository.ProductRepository;

import java.math.BigDecimal;

@Service
public class ProductService {
    
    @Autowired
    AliexpressService aliexpressService;

    @Autowired
    ProductRepository repository;

    public Product insert(AliexpressDto itemRegistrationDto){
        Product product = new Product();

        product.setShopId(itemRegistrationDto.id());
        product.setPrice(itemRegistrationDto.price());
        product.setCategory(itemRegistrationDto.category());
        
        //String aliexJson = aliexpressService.getItem(itemRegistrationDto.id());
      
        RestTemplate abc = new RestTemplate();
        String aliexJson = abc.getForEntity("https://604b2e53-8673-48f4-aad2-994499634da3.mock.pstmn.io/teste", String.class).getBody();
       
       
        JSONObject json = new JSONObject(aliexJson);

        JSONObject item = json.getJSONObject("result").getJSONObject("item");;

        JSONObject priceData = item.getJSONObject("sku").getJSONArray("base").getJSONObject(0);

        BigDecimal promotionPrice = priceData.getBigDecimal("promotionPrice");
        int quantity = priceData.getInt("quantity");
    
        
        product.setName(item.getString("title"));
        product.setImage(item.getJSONArray("images").getString(0));
        product.setPromotionPrice(promotionPrice);
        
        product.setQuantity(quantity);
        product.setIsAvailable(quantity >= 1);

        JSONArray delivery = json.getJSONObject("result").getJSONObject("delivery").getJSONArray("shippingList").getJSONObject(0).getJSONArray("note");

        product.setFreight(delivery.getString(0));
        product.setEstimatedTime(delivery.getString(2));
            
        repository.save(product);

        return product;
    }

    public Product insert(StockDto productdDto){
        Product product = new Product();
        
        product.setName(productdDto.name());
        product.setCategory(productdDto.category());
        product.setDescription(product.getDescription());
        
        product.setPrice(productdDto.price());
        product.setImage(productdDto.image());
        
        product.setEstimatedTime(productdDto.estimatedTime());
        product.setFreight(productdDto.freight()); 

        product.setQuantity(productdDto.quantity());

        boolean isAvailable = productdDto.quantity() > 0;
        product.setIsAvailable(isAvailable);

        repository.save(product);
        return product;
    }
    
}
