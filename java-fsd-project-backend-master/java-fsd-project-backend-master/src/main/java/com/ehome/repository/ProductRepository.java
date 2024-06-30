package com.ehome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehome.entities.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
