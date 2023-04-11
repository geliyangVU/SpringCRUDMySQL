package com.geliyang.crudmysql.controller;


import com.geliyang.crudmysql.entity.Product;
import com.geliyang.crudmysql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/Products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

//    @GetMapping("Product/{name}")
//    public Product findProductByName(@PathVariable String name){
//        return productService.getProductByName(name);
//    }


    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") String id,@RequestBody Product product){

        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){

        return productService.deleteProduct(id);
    }


}
