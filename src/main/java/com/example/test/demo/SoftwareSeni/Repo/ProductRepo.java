package com.example.test.demo.SoftwareSeni.Repo;


import com.example.test.demo.SoftwareSeni.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Products, Integer> {
    List<Products> findAllById(Integer Id);

    @Query("Select p from Products p where p.name like %:name%")
    List<Products> findTypeProductsContaining(String name);

    @Query("Select COUNT(id) from Products  where category_id = :category_id")
    Double countProductsByCategoryId(Integer category_id);

    @Query("Select p from Products p where p.category_id = :category_id")
    List<Products> findByProductsByCategorytId(Integer category_id);
    /*@Query("Select c from Transcation c where c.name like %:name% order by c.name asc")
    List<Transcation> findByNameIgnoreContaining(String name);*/

}
