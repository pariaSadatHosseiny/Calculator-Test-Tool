package com.zuhlke.ctt.repository;

import com.zuhlke.ctt.model.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;


@RepositoryRestResource(collectionResourceRel = "testcases", path = "testcases")
public interface TestCaseRepository extends CrudRepository<TestCase,Long> {

}
