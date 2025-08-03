package com.example.ProductService.Projections;

// we use projection only if we are returnning some attribute of object
// we are create this projection for the return result of the custom query of hql as we are only returning id and title this should not being able to map with simple product object
public interface ProductWithOnlyIdAndTitle {

    Long GetId();
    String GetTitle();

}


