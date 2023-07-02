package com.project.demodisgroup.repository;

import com.project.demodisgroup.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
