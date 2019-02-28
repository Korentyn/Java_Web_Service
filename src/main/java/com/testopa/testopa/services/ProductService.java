package com.testopa.testopa.services;

import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.domain.Product;
import com.testopa.testopa.repositories.ProductRepository;
import com.testopa.testopa.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findProducts(){
        return (List<Product> ) this.productRepo.findAll();

    }

    public Optional<Product> findProductsById(Long id){
        return this.productRepo.findById(id);
    }

    public List<Product> findProductsByName(String name){
        return this.productRepo.findByName(name);
    }

    public Product saveProducts(Product product){
        return this.productRepo.save(product);
    }

    public void deleteProductsById(Long id){
        this.productRepo.deleteById(id);
    }
}
