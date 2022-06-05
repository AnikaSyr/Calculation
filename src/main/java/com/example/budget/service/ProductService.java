package com.example.budget.service;

import com.example.budget.exception.ClientNotFoundException;
import com.example.budget.exception.ProductNotFoundException;
import com.example.budget.model.Client;
import com.example.budget.model.Product;
import com.example.budget.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listAll(){
        return (List<Product>) productRepository.findAll();
    }
    public List<Product> listAllOrderById(){
        return (List<Product>) productRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }
    public void save(Product product){
        productRepository.save(product);
    }



    public Product get(Long id) throws ProductNotFoundException {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ProductNotFoundException("Could not find any product with ID " + id);
    }
    public void delete (Long id) throws ProductNotFoundException {
        Long count = productRepository.countById(id);
        if(count == null || count ==0) {
            throw new ProductNotFoundException("Could not find any products with ID " + id);
        }
        productRepository.deleteById(id);
    }
}
