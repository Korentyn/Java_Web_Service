package com.testopa.testopa.repositories;

import com.testopa.testopa.domain.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SellerRepository extends CrudRepository<Seller, Long> {
    List<Seller> findById(Integer id);
    List<Seller> findByName(String name);
}
