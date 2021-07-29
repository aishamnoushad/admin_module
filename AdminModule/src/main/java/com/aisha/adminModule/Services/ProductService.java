package com.aisha.adminModule.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.Product;
import com.aisha.adminModule.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}


	public Product saveProduct(Product newProduct) {
		if(newProduct.getSub_Category_ID()==null)
			newProduct.setSub_Category_ID("");
		else if(newProduct.getSub_Sub_Category_ID()==null)
			newProduct.setSub_Sub_Category_ID("");
		newProduct.setCreated_at(LocalDateTime.now());
		newProduct.setUpdated_at(LocalDateTime.now());
		System.out.println("saving record" + newProduct.toString());
		return productRepository.saveAndFlush(newProduct);
	}
	
	
	public Optional<Product> findProductById(String productId) {
		return productRepository.findById(productId);
	}
	
	public void deleteProductById(String productId) {
		productRepository.deleteById(productId);
	}

}
