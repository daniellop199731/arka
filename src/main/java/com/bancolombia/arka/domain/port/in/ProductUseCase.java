package com.bancolombia.arka.domain.port.in;

import com.bancolombia.arka.domain.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUseCase {

    Mono<Product> save(Product product);
    Flux<Product> getAllProducts();
    
}
