package com.example.TradeRec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TradeRec.entity.Product;

@Repository
public interface ProductInfoRepository extends JpaRepository<Product, Integer> {

}
