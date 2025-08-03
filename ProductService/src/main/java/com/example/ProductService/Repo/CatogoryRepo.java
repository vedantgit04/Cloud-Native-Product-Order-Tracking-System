package com.example.ProductService.Repo;

import com.example.ProductService.Models.Catogory;
import com.example.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatogoryRepo extends JpaRepository<Catogory,Long> {

    Catogory save(Catogory catogory);

}
