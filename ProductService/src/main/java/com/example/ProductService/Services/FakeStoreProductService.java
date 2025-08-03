package com.example.ProductService.Services;

import com.example.ProductService.DTOs.FakeStoreProductDTO;
import com.example.ProductService.Exceptions.InvalidProductIdException;
import com.example.ProductService.Models.Catogory;
import com.example.ProductService.Models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreproductservice") // this nameming annoation stores the name of the service in the springcontroller so that we can use name of service direclty in the controller layer by uising qualifire annotation
//@Primary  primary tell the spring that this is the primary service for product controller because productservice implement two services
public abstract class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate){
         this.restTemplate  = restTemplate;
    }

    private Product ConvertFakeStoreProductDTOtoProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDiscription(fakeStoreProductDTO.getDiscription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImage(fakeStoreProductDTO.getImage());

        Catogory catogory = new Catogory();
        catogory.setTitle(fakeStoreProductDTO.getCatogory());
        product.setCatogory(catogory);
       return product;
    }
    public Product  GetProductById(long id) throws InvalidProductIdException {
        // call the fake store api to get the product with the given id here
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);

        if(fakeStoreProductDTO == null){
            throw new InvalidProductIdException("Invalid product id passed");

        }

        // convert the FakeStoreDTO object  to Product Object  - change is the fakeStore catogiry is of String type and in our project entity we have catogory as Catogory type
        return ConvertFakeStoreProductDTOtoProduct(fakeStoreProductDTO);
    }

    public List<Product> GetAllProducts() {

        // lots of changes are done the return type of fakestore is list
        // we can not convert the datatype during run time
       FakeStoreProductDTO [] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDTO[].class);

       List<Product> products = new ArrayList<>();

       for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
           products.add(ConvertFakeStoreProductDTOtoProduct(fakeStoreProductDTO));
       }
      return products;
    }

    public Product CreateProduct( Product product){
        return new Product();
    }


    public Product ReplaceProduct( long id ,  Product product){
        //PUT Method
        //Replace the product with given id with the input product
        //and return the updated product in the output.

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDto =
                restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return ConvertFakeStoreProductDTOtoProduct(fakeStoreProductDto);
    }

    public  Product UpdateProduct (long id, Product product){
        return new Product();
    }

    public  void DeleteProdcut(long id){

    }
}
