package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepositoryInterface;

@Service
public class ProductServiceImple implements ProductServiceInterface{
	
	@Autowired
	private ProductRepositoryInterface productRepo;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product getProductByID(Integer id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product=productRepo.findById(id).get();
		if(product!=null) {
			productRepo.delete(product);
			return "Product Delete Succesfully";
		}
		return "Something Wrong on server";
	}
	@Override
	public Product editProduct(Product product, Integer id) {
		Product oldProd=productRepo.findById(id).get();
		oldProd.setproductName(product.getproductName());
		oldProd.setDescription(product.getDescription());
		oldProd.setPrice(product.getPrice());
		oldProd.setStatus(product.getStatus());
		return productRepo.save(oldProd);
	}

}
