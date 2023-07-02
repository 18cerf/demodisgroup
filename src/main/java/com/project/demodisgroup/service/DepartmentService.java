package com.project.demodisgroup.service;

import com.project.demodisgroup.dto.DepartmentDto;
import com.project.demodisgroup.dto.PersonDto;
import com.project.demodisgroup.entity.Department;
import com.project.demodisgroup.entity.Person;
import com.project.demodisgroup.repository.DepartmentRepository;
import com.project.demodisgroup.repository.PersonRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DepartmentService {
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    private final DepartmentRepository departmentRepository;

    public void save(DepartmentDto departmentDto) {
        departmentRepository.save(
                new Department().builder()
                        .id(departmentDto.getId())
                        .name(departmentDto.getName())
                        .build());
    }

    public void save(Department department) {
        departmentRepository.save(department);
    }

    public Department find(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Cant find Department with id = " + id));
    }

    public List<Department> findAll() {
        return departmentRepository.findAll(Sort.by("id"));
    }

    public void delete(Long id) {
            departmentRepository.deleteById(id);
    }
    public boolean existById(Long id){
       return departmentRepository.existsById(id);
    }
}
