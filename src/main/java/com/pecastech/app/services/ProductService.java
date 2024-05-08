package com.pecastech.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import com.pecastech.app.dto.AliexpressDto;
import com.pecastech.app.dto.StockDto;
import com.pecastech.app.exceptions.ProductNotFoundException;
import com.pecastech.app.model.Product;
import com.pecastech.app.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    AliexpressService aliexpressService;

    @Autowired
    ProductRepository repository;

    public Product insert(AliexpressDto itemRegistrationDto){
        Product product = new Product();
        product.setOwnerId(itemRegistrationDto.ownerID());
        product.setShopId(itemRegistrationDto.id());    
        //TODO - RDN: price vem convertido
        product.setPrice(itemRegistrationDto.price());
        product.setCategory(itemRegistrationDto.category());
        product.setPromotionPrice(itemRegistrationDto.promotionPrice());
        
        //String aliexJson = aliexpressService.getItem(itemRegistrationDto.id());
        
        RestTemplate abc = new RestTemplate();
        String aliexJson = abc.getForEntity("https://604b2e53-8673-48f4-aad2-994499634da3.mock.pstmn.io/teste", String.class).getBody();
       
       
        JSONObject json = new JSONObject(aliexJson);

        JSONObject item = json.getJSONObject("result").getJSONObject("item");;

        JSONObject priceData = item.getJSONObject("sku").getJSONArray("base").getJSONObject(0);
        
        int quantity = priceData.getInt("quantity");
        product.setQuantity(quantity);
        product.setIsAvailable(quantity >= 1);
        
        product.setName(item.getString("title"));
        product.setImage(item.getJSONArray("images").getString(0));

        repository.save(product);

        return product;
    }

    public Product insert(StockDto productdDto){
        Product product = new Product();
        
        product.setOwnerId(productdDto.ownerID());
        product.setName(productdDto.name());
        product.setCategory(productdDto.category());
        product.setDescription(productdDto.description());
        product.setPromotionPrice(productdDto.promotionPrice());
        product.setPrice(productdDto.price());
        product.setImage(productdDto.image()); 

        product.setQuantity(productdDto.quantity());

        boolean isAvailable = productdDto.quantity() > 0;
        product.setIsAvailable(isAvailable);

        repository.save(product);
        return product;
    }

    public void delete(String ownerID){
        Product product = repository.findByOwnerId(ownerID);
        if( product == null) {
            throw new ProductNotFoundException();
            
        }
        repository.deleteByOwnerId(ownerID);
    }
    
    public void put(String ownerID, StockDto stockDto){
        Product product = repository.findByOwnerId(ownerID);
        if( product == null) {
            throw new ProductNotFoundException();
        }
        if(stockDto.ownerID() != null){
            product.setOwnerId(stockDto.ownerID());
        }
        
        if(stockDto.name() != null){
            product.setName(stockDto.name());
        }
        
        if(stockDto.category() != null){
            product.setCategory(stockDto.category());
        }
        
        if(stockDto.description() != null){
            product.setDescription(stockDto.description());
        }
        
        if(stockDto.price() != null){
            product.setPrice(stockDto.price());
        }
        
        if(stockDto.image() != null){
            product.setImage(stockDto.image());
        }
        
        if(stockDto.quantity() >= 0){
            product.setQuantity(stockDto.quantity());

            boolean isAvailable = stockDto.quantity() > 0;
            product.setIsAvailable(isAvailable);
        }
        
        repository.save(product);
    }
}
