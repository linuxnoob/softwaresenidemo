package com.example.test.demo.SoftwareSeni.Repo;


import com.example.test.demo.SoftwareSeni.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAllById(Integer Id);

    @Query("Select p from Product p where p.type like %:name%")
    List<Product> findTypeProductContaining(String name);

    @Query("Select COUNT(id) from Product  where category_id = :category_id")
    Double countProductByCategoryId(Integer category_id);

    @Query("Select p from Product p where p.category_id = :category_id")
    List<Product> findByProductByCategorytId(Integer parent_id);
    /*@Query("Select c from Transcation c where c.name like %:name% order by c.name asc")
    List<Transcation> findByNameIgnoreContaining(String name);*/

}
