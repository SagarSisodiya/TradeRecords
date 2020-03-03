package com.example.TradeRec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TradeRec.entity.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, String>{

}
