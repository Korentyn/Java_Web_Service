package com.testopa.testopa.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;


@Entity(name="seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Length(min=5, max=5)
    private String zipcode;
    private String city;

    @OneToMany(mappedBy = "seller")
    private List<Product> products;
}
