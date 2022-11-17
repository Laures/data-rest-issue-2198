package com.example.demo.delombok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "examples", itemResourceRel = "example", collectionResourceRel = "examples")
public interface ExampleRepository extends JpaRepository<Example, Long> {


}
