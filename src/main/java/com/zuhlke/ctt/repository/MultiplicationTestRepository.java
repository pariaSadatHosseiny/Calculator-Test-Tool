package com.zuhlke.ctt.repository;

import com.zuhlke.ctt.model.entities.MultiplicationTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/* Created by  paria
 * Date:       2/7/2021
 * Time:       10:31 PM
 */

@RepositoryRestResource(collectionResourceRel = "multiplication", path = "multiplication")
public interface MultiplicationTestRepository extends CrudRepository<MultiplicationTest,Integer> {

}
