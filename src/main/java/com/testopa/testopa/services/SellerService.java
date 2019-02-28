package com.testopa.testopa.services;

import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.domain.Product;
import com.testopa.testopa.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepository sellerRepo;

    @Autowired
    public SellerService(SellerRepository sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    public List<Seller> findSellers(){
        return (List<Seller> ) this.sellerRepo.findAll();

    }

    public Optional<Seller> findSellersById(Long id){
        return this.sellerRepo.findById(id);
    }

    public List<Seller> findSellersByName(String name){
        return this.sellerRepo.findByName(name);
    }

    public Seller saveSellers(Seller seller){
        return this.sellerRepo.save(seller);
    }

    public void deleteSellersById(Long id){
        this.sellerRepo.deleteById(id);
    }
}
