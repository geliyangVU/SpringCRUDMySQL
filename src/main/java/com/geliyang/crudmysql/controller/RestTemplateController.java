package com.geliyang.crudmysql.controller;


import com.geliyang.crudmysql.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getProductsRestTemplate")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:9191/Products",
                HttpMethod.GET,
                entity,
                String.class).getBody();
    }


    @PostMapping(value = "/createProductRestTemplate")
    public String createProduct(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

        return restTemplate.exchange(
                "http://localhost:9191/addProduct",
                HttpMethod.POST,
                entity,
                String.class).getBody();
    }


    @RequestMapping(value = "/updateProductRestTemplate/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);

        return restTemplate.exchange(
                "http://localhost:9191/update/"+id,
                HttpMethod.PUT,
                entity,
                String.class).getBody();
    }



    @RequestMapping(value = "/deleteProductRestTemplate/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<Product>(headers);

        return restTemplate.exchange(
                "http://localhost:9191/delete/"+id,
                HttpMethod.DELETE,
                entity,
                String.class).getBody();
    }





}
