package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.DepartmentList;
@Repository
@RepositoryRestResource(exported=false)
public interface DepartmentRepository extends CrudRepository<DepartmentList, Long> {

	DepartmentList findByName(String name);

}
