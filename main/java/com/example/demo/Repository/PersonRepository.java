package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Person;
@Repository
@RepositoryRestResource(exported=false)
public interface PersonRepository extends CrudRepository<Person, Long> {

	boolean existsByName(String name);

}
