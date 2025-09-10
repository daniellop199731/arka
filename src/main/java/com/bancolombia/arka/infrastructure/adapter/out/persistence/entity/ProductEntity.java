package com.bancolombia.arka.infrastructure.adapter.out.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "products")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
 
    @Id
    private String id;
    private String name;
    private double price;

}

