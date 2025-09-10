package com.bancolombia.arka.domain.port.out;

import com.bancolombia.arka.domain.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepositoryPort {
    
    Flux<Product> findAll();
    Mono<Product> findById(String id);
    Mono<Product> save(Product product);
    void deleteById(String id);
    boolean existById(String id);

}
