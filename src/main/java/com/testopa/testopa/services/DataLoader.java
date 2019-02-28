package com.testopa.testopa.services;

import com.testopa.testopa.domain.Product;
import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.repositories.ProductRepository;
import com.testopa.testopa.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class DataLoader {

    private final ProductRepository productRepo;
    private final SellerRepository sellerRepo;

    @Autowired
    public DataLoader(ProductRepository productRepo, SellerRepository sellerRepo){
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;
    }

    //Charge les données dans la BDD une fois le contructeur terminé
    @PostConstruct
    private void loadData(){
        productRepo.deleteAll();
        sellerRepo.deleteAll();


        // On créé un client
        Seller seller1 = new Seller(null, "Coco","Vendeur de drogue","32150","Toulouse",null);
        sellerRepo.save(seller1);


        // On créé les produits
        Product product1 = new Product(null,"ProductName1", "MyDescription1", "http://", 10.55, new Date(), null);
        Product product2 = new Product(null,"ProductName1", "MyDescription2", "http://", 9.99, new Date(), null);
        productRepo.save(product1);
        productRepo.save(product2);
    }
}
