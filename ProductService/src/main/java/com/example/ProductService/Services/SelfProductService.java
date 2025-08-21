package com.example.ProductService.Services;

import com.example.ProductService.Exceptions.InvalidProductIdException;
import com.example.ProductService.Models.Catogory;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repo.CatogoryRepo;
import com.example.ProductService.Repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
public   class  SelfProductService implements ProductService{
     private ProductRepo productRepo;
     private CatogoryRepo catogoryRepo;
     private RedisTemplate redisTemplate;
    SelfProductService(ProductRepo productRepo, CatogoryRepo catogoryRepo, RedisTemplate redisTemplate){
        this.productRepo = productRepo;
        this.catogoryRepo = catogoryRepo;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Product GetProductById( long id) throws InvalidProductIdException {

        // first check the product in the redis chache
        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_" + id);
        if (product != null) {
            // this is the case of cache hit
            return product;
        }
        Optional<Product> optionalProduct = productRepo.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new InvalidProductIdException("invalid id");
        }
        // this is the case of chache miss
        Product product1 = optionalProduct.get();
        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_" + id, product1);
        return product1;
    }

    // we  are using  this service for pagination
     @Override
    public Page<Product> GetAllProducts(int pageNumber , int pageSize){

//         Sort.by("price").descending().and(Sort.by(" title"));
        return productRepo.findAll(PageRequest.of(pageNumber,pageSize,  Sort.by("price").descending()));
      }


    public  Product CreateProduct(Product product){
          Catogory catogory = product.getCatogory();

        if (catogory.getId() == null) {
            //first save the category in the DB
             Catogory savedCategory = catogoryRepo.save(catogory);
            product.setCatogory(savedCategory);
        }

        return  productRepo.save(product);

    }

    public Product UpdateProduct(Long id, Product product)throws InvalidProductIdException {

        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductIdException("product is not present");
        }
        if(product == null){
            throw new InvalidProductIdException("product is null");
        }

        Product currproduct = optionalProduct.get();

        if(product.getTitle() !=null){
            currproduct.setTitle(product.getTitle());
        }

        if(product.getDiscription()!=null){
            currproduct.setDiscription(product.getDiscription());
        }


        if(product.getImage()!=null){
            currproduct.setImage(product.getImage());
        }


        return productRepo.save(currproduct);

    }

   public Product ReplaceProduct(Long id , Product product) throws InvalidProductIdException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductIdException("invalid product id");
        }

        return productRepo.save(product);
    }

    public  void  DeleteProdcut(Long id) throws InvalidProductIdException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()){
            throw new InvalidProductIdException("invalid id");
        }

        productRepo.deleteById(id);
        return;
    }

}
