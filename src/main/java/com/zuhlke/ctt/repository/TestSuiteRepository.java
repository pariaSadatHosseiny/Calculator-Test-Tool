package com.zuhlke.ctt.repository;

import com.zuhlke.ctt.model.entities.TestCase;
import com.zuhlke.ctt.model.entities.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "testsuites", path = "testsuites")
public interface TestSuiteRepository extends JpaRepository<TestSuite,Long> {

}
