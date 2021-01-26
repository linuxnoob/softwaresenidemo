package com.example.test.demo.SoftwareSeni.Repo;


import com.example.test.demo.SoftwareSeni.Entity.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepo extends JpaRepository<Transcation, Long> {
    List<Transcation> findAllById(String id);

    @Query("Select t.parent_id from Transcation t where t.type like %:type%")
    List<String> findTypeTransactionContaining(String type);

    /*@Query("Select c from Transcation c where c.name like %:name% order by c.name asc")
    List<Transcation> findByNameIgnoreContaining(String name);*/

}
