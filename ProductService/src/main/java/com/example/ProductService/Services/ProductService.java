package com.example.ProductService.Services;


import com.example.ProductService.Exceptions.InvalidProductIdException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.ProductServiceApplication;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface ProductService {

    public Product GetProductById( long id) throws InvalidProductIdException;

    public Page<Product> GetAllProducts(int pageNumber , int pageSize);

    public  Product CreateProduct(Product product);

    public Product UpdateProduct(Long id,Product product) throws InvalidProductIdException;

    Product ReplaceProduct(Long id , Product product) throws InvalidProductIdException;

    public  void DeleteProdcut(Long id) throws InvalidProductIdException;


//    @Query("Custom Query") //HQL -> Hibernate Query Language
//    Optional<Product> someRandomQuery();

}
