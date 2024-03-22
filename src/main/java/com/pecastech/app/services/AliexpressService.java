package com.pecastech.app.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AliexpressService {
    
    @Value("${api.key}")
    private String API_SECRET;
    private String HOST = "aliexpress-datahub.p.rapidapi.com";
    private String url = "https://aliexpress-datahub.p.rapidapi.com/item_detail_simple?region=BR&locale=pt_BR";

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders headers = new HttpHeaders();
    //itemId=3256804591426248 exemplo
    
    public String itemDetailSimple(String Id){
        String params = "&itemId=" + Id;

        headers.set("X-RapidAPI-Key", API_SECRET);
        headers.set("X-RapidAPI-Host", HOST );
        
        HttpEntity request = new HttpEntity(headers); 

        ResponseEntity<String> response = restTemplate.exchange(url + params, HttpMethod.GET, request, String.class, 1);
        
        headers.clear();
        
        return response.getBody();
    }
}

