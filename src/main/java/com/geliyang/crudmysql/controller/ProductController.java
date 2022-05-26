package com.geliyang.crudmysql.controller;


import com.geliyang.crudmysql.entity.Product;
import com.geliyang.crudmysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(List<Product> products){
        return productService.saveProducts(products);
    }



    


}
