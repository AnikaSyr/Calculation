package com.example.budget.service;

import com.example.budget.exception.ProductCopyNotFoundException;
import com.example.budget.exception.ProductNotFoundException;
import com.example.budget.model.Product;
import com.example.budget.model.ProductCopy;
import com.example.budget.repository.ProductCopyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCopyService {
    private final ProductCopyRepository productCopyRepository;

    public ProductCopyService(ProductCopyRepository productCopyRepository) {
        this.productCopyRepository = productCopyRepository;
    }


    public List<ProductCopy> listAll(){
        return (List<ProductCopy>) productCopyRepository.findAll();
    }

    public List<ProductCopy> listAllOrderById(){
        return (List<ProductCopy>) productCopyRepository.findAll((Sort.by(Sort.Direction.ASC, "id")));
    }
    public void save(ProductCopy productCopy){
        productCopyRepository.save(productCopy);
    }



    public ProductCopy get(Long id) throws ProductCopyNotFoundException {
        Optional<ProductCopy> result = productCopyRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new ProductCopyNotFoundException("Could not find any product with ID " + id);
    }
    public void delete (Long id) throws ProductCopyNotFoundException {
        Long count = productCopyRepository.countById(id);
        if(count == null || count ==0) {
            throw new ProductCopyNotFoundException("Could not find any products with ID " + id);
        }
        productCopyRepository.deleteById(id);
    }

}
