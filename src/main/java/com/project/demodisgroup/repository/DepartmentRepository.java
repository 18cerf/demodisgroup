package com.project.demodisgroup.repository;

import com.project.demodisgroup.entity.Department;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findAll(Sort sort);
    boolean existsById(Long id);
}
