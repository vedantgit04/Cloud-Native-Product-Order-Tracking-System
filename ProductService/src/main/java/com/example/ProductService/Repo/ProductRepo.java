package com.example.ProductService.Repo;

import com.example.ProductService.Models.Product;
import com.example.ProductService.Projections.ProductWithOnlyIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

      // it is using join to fecht the catogory
      List<Product> findAll();
      Optional<Product>  findById(Long id); // optional is used if there is possiblity of returnning null values so that where ever we perform opration of that optional veriable it is showing warnning that check if the value is null or not
      Product save(Product product);

      @Query("select p from Product as p where p.price > 100 and p.title like lower('%pro%') ")
      List<Product> someHQLQuery();

//      we are albe to cutomise the return attributes by using hql query
      // this method is only returnning id and title not a project object as product
      // here we are returing the column name from as , they should be same in the projection interface like pi.id as id then in interface it should be Getid
     @Query("select p.id as Id, p.title as Title  from Product as p where p.price > 100 and p.title like lower('%pro%') ")
      List<ProductWithOnlyIdAndTitle> someHQL1Query();

      // now for custome SQL query we need to like this
      // how many DB class -2
      // first getting the Project Object and From catogory.id feching the Catogory object
      @Query(value = "select * from product where id = 2", nativeQuery = true)
      Product SQLquery();
}

/*

C -> Create
R -> Read
U -> Update
D -> Delete

Create, Update => save()
Read => find()
Delete => delete();

Product save(Product product);

ProductRepository -> Product

Product findById(id) => select * from product where id = <id>
List<Product> findAll() => select * from product
Product findByTitle(String title) => select * from product where title = "";
 */


