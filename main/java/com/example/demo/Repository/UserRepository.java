package com.example.demo.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.UserDetails;
@Repository
@RepositoryRestResource(exported=false)
public interface UserRepository extends CrudRepository<UserDetails, Long> {

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email); 

}