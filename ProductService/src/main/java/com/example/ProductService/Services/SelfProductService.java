package com.example.ProductService.Services;

import com.example.ProductService.Exceptions.InvalidProductIdException;
import com.example.ProductService.Models.Catogory;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repo.CatogoryRepo;
import com.example.ProductService.Repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
public   class  SelfProductService implements ProductService{
     private ProductRepo productRepo;
     private CatogoryRepo catogoryRepo;
    SelfProductService(ProductRepo productRepo, CatogoryRepo catogoryRepo){
        this.productRepo = productRepo;
        this.catogoryRepo = catogoryRepo;
    }

    @Override
    public Product GetProductById( long id) throws InvalidProductIdException{
        Optional<Product> optionalProduct =  productRepo.findById(id);

        if(optionalProduct.isEmpty()){
            throw  new InvalidProductIdException("invalid id");
        }
        return optionalProduct.get();
    }

     @Override
    public List<Product> GetAllProducts(){
        return productRepo.findAll();
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
