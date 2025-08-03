package com.example.ProductService.Controllers;

// code is loosy coupled because we are programming to interface not to implementation
import com.example.ProductService.Commons.AuthorazationCommons;
import com.example.ProductService.DTOs.Role;
import com.example.ProductService.DTOs.UserDto;
import com.example.ProductService.Exceptions.InvalidProductIdException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private AuthorazationCommons authorazationCommons;

    ProductController(@Qualifier("selfproductservice") ProductService productService, AuthorazationCommons authorazationCommons){
        this.productService = productService;
        this.authorazationCommons= authorazationCommons;
    }



    //localhost:8080/products/id
    @GetMapping("/{id}")
    public ResponseEntity<Product> GetProductById(@PathVariable("id") long id) throws InvalidProductIdException {


      // throw  new RuntimeException("something went wrong");  by using this method to handle exception it is showing all the relevant information to client
//      try{
//          product = productService.GetProductById(id);
//      }catch (RuntimeException e){
//         System.out.println("something went wrong");
//        return new ResponseEntity<>(product,HttpStatusCode.valueOf(404));
//    }
//      catch (different type of exception){
//          System.out.println("some went wrong");
//          return new ResponseEntity<>(product,HttpStatusCode.valueOf(402));
//      } we can able to handel the exception in the controller layer but this is controller gets bulky for that we are using controller advise
        Product  product = productService.GetProductById(id);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }

    //localhost:8081/products
    @GetMapping("/all/{token}")
    public  ResponseEntity<List<Product>> GetAllProducts(@PathVariable  String token){
        // first we need tot validate the token
        UserDto userDto = authorazationCommons.ValidateToken(token);

        if(userDto == null){
            // token in invalid
                return new ResponseEntity<>(HttpStatusCode.valueOf(401));
        }
//        // this code is for authorization where we are checking the RBA - for admin
//        boolean isAdmin  = false;
//        for(Role role : userDto.getRoles()){
//            if(role.equals("Admin")){
//                isAdmin = true;
//                break;
//            }
//        }
//        if(isAdmin == false){
//            // thorws some exception like you are not authorize to acces this url
//            return null;
//        }

       List<Product>products = productService.GetAllProducts();
       return new ResponseEntity<>(products,HttpStatusCode.valueOf(200));
    }
//
    @PostMapping
    public ResponseEntity<Product> CreateProduct(@RequestBody Product product){
         Product productr  = productService.CreateProduct(product);
         return new ResponseEntity<>(productr,HttpStatusCode.valueOf(200));
    }

    // partial update
    @PatchMapping("/{id}")
    public  ResponseEntity<Product>  UpdateProduct (@PathVariable ("id") long id,@RequestBody Product product)
            throws InvalidProductIdException {
          Product product1  = productService.UpdateProduct(id,product);
          return new ResponseEntity<>(product1,HttpStatusCode.valueOf(200));
    }
     // complete update
    @PutMapping("/{id}")
    public ResponseEntity<Product> ReplaceProduct(@PathVariable("id") Long id , @RequestBody Product product) throws InvalidProductIdException {
        Product newproduct =  productService. ReplaceProduct(id,product);

        return new ResponseEntity<>(newproduct,HttpStatusCode.valueOf(200));
    }
//
    @DeleteMapping("{id}")
    public void DeleteProdcut(@PathVariable("id")Long id) throws InvalidProductIdException {

            productService. DeleteProdcut(id);

             return;
    }

}
