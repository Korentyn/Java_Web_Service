package com.testopa.testopa.repositories;

import com.testopa.testopa.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Interface qui permet de créer automatiquement les requêtes

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findById(Integer id);
    List<Product> findAll();
    List<Product> findByName(String name);
}
