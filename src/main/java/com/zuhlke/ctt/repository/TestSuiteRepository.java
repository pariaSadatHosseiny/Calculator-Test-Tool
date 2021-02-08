package com.zuhlke.ctt.repository;

import com.zuhlke.ctt.model.entities.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

@RepositoryRestResource(collectionResourceRel = "testSuites", path = "testSuites")
public interface TestSuiteRepository extends JpaRepository<TestSuite,Long> {

}
