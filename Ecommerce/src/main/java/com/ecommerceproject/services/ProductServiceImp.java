package com.ecommerceproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceproject.entities.Product;
import com.ecommerceproject.repositories.ProductRepository;
import com.ecommerceproject.service.interfaces.ProductService;


@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		Optional<Product> product =productRepository.findById(id);
		
		return product.orElseThrow(() ->new RuntimeException("Product Not Found"));
	}

	@Override
	public Product addProduct(Product product) {
	
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id,Product product) {
	    Product product1 = getProductById(id);
	    product1.setDescription(product.getDescription());
	    product1.setProduct_name(product.getProduct_name());
	    product1.setPrice(product.getPrice());
	    product1.setAvailable_products(product.getAvailable_products());
	    product1.setUpdated_time(product.getUpdated_time());
	    productRepository.save(product1);
		return product;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
                       
}
