package com.bancolombia.arka.infrastructure.adapter.out.persistence.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bancolombia.arka.domain.model.Comment;

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
    private List<Comment> comments;

}

