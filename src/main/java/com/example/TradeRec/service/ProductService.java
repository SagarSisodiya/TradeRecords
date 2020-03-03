package com.example.TradeRec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.TradeRec.entity.Product;
import com.example.TradeRec.repository.ProductInfoRepository;

@Component
public class ProductService {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	public List<Product> getProduct() {
		return productInfoRepository.findAll();
	}

	public Optional<Product> getProductById(int productId) {
		return productInfoRepository.findById(productId);
	}

	public void addProduct(Product product) {
		productInfoRepository.save(product);
	}

	public void removeProduct(int productId) {
		productInfoRepository.deleteById(productId);
	}

}
