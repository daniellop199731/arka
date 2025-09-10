package com.bancolombia.arka.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bancolombia.arka.infrastructure.adapter.out.persistence.entity.ProductEntity;

public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
}
