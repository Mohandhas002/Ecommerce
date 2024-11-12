package com.ecommerceproject.service.interfaces;

import java.util.List;
import com.ecommerceproject.entities.Product;

public interface ProductService {
	
       List<Product> getAllProduct();
       Product getProductById(Long id);
       Product addProduct(Product product);
       Product updateProduct(Long id,Product product);
       void deleteProduct(Long id);
       
}
