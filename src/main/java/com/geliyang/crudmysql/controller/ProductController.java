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
    public Product addProduct(Product product){
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

    @GetMapping("Product/{id}")
    public Optional<Product> findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }


    @GetMapping("Product/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }


    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }


}
