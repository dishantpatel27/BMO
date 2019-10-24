package com.bmo.test.repo;

import com.bmo.test.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PersonRepo extends JpaRepository<Person, Long>{
    public List<Person> findAll();

    @Modifying
    @Query(
            value = "insert into Person (first_name,last_name) values (:firstName, :lastName)",
            nativeQuery = true)
    void insertUser(@Param("firstName") String firstName, @Param("lastName") String lastName);



}
