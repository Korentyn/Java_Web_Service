package com.testopa.testopa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String name;
     private String description;
     private String imageurl;

     @NotNull // Lors de la création en BDD, amount ne pourra pas être null
     private Double price;
     private Date createdate;

     @ManyToOne // = pour plusieurs factures on peut avoir 1 client (gère les clés étrangères)
     @JsonBackReference // Empeche la boucle infinie dû aux relations entre les classes
     private Seller seller;
}
