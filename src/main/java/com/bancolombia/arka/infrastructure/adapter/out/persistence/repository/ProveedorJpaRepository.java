package com.bancolombia.arka.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancolombia.arka.infrastructure.adapter.out.persistence.entity.ProveedorEntity;

public interface ProveedorJpaRepository extends JpaRepository<ProveedorEntity, Integer> {

}
