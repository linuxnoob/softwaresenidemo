package com.example.test.demo.SoftwareSeni.Repo;


import com.example.test.demo.SoftwareSeni.Entity.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepo extends JpaRepository<Transcation, Integer> {
    List<Transcation> findAllById(Integer parent_id);

    @Query("Select t.parent_id from Transcation t where t.type like %:type%")
    List<Long> findTypeTransactionContaining(String type);

    @Query("Select COUNT(parent_id) from Transcation  where parent_id = :parent_id")
    Double countTransactionByParentId(Long parent_id);

    @Query("Select t from Transcation t where t.parent_id = :parent_id")
    Transcation findByParentId(Long parent_id);

    @Query("Select t from Transcation t where t.parent_id = :parent_id")
    List<Transcation> findByTransactionByParentId(Long parent_id);
    /*@Query("Select c from Transcation c where c.name like %:name% order by c.name asc")
    List<Transcation> findByNameIgnoreContaining(String name);*/

}
