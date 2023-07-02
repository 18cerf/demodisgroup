package com.project.demodisgroup.controller;

import com.project.demodisgroup.dto.DepartmentDto;
import com.project.demodisgroup.entity.Department;
import com.project.demodisgroup.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/department")
public class RestDepartmentController {
    private final DepartmentService departmentService;

    public RestDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getList() {
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> get(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.find(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Department> add(@RequestBody DepartmentDto departmentDto) {
        Department newDepartment = Department.builder()
                .name(departmentDto.getName())
                .build();

        departmentService.save(newDepartment);
        return new ResponseEntity<>(newDepartment, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Department> update(@RequestBody DepartmentDto departmentDto) {
        if (departmentService.existById(departmentDto.getId())) {

            Department updatedDepartment = departmentService.find(departmentDto.getId());
            updatedDepartment.setName(departmentDto.getName());

            departmentService.save(updatedDepartment);
            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        if (departmentService.existById(id)) {
            departmentService.delete(id);
            return HttpStatus.OK;
        } else
            return HttpStatus.CONFLICT;
    }
}
