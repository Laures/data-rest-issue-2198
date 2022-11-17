package com.example.demo.lombok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "lombok-examples", itemResourceRel = "lombok-example", collectionResourceRel = "lombok-examples")
public interface LombokExampleRepository extends JpaRepository<LombokExample, Long> {

}
