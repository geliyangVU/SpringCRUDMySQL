package com.geliyang.crudmysql.service;


import com.geliyang.crudmysql.entity.Product;
import com.geliyang.crudmysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProduct(List<Product> products){
        return repository.saveAll(products);
    }


    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return repository.findById(id);
    }



}
