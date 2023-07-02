package com.project.demodisgroup.controller;

import com.project.demodisgroup.dto.PersonDto;
import com.project.demodisgroup.entity.Person;
import com.project.demodisgroup.service.DepartmentService;
import com.project.demodisgroup.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/person")
public class RestPersonController {

    private final PersonService personService;
    private final DepartmentService departmentService;

    public RestPersonController(PersonService personService, DepartmentService departmentService) {
        this.personService = personService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Person>> getList() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        if (personService.existById(id)) {
            return new ResponseEntity<>(personService.find(id), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<Person> add(@RequestBody PersonDto personDto) {
        if (departmentService.existById(personDto.getDepartmentId())) {
            Person newPerson = Person.builder()
                    .firstname(personDto.getFirstname())
                    .lastname(personDto.getLastname())
                    .department(departmentService.find(personDto.getDepartmentId()))
                    .build();
            personService.save(newPerson);
            return new ResponseEntity<>(newPerson, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/")
    public ResponseEntity<Person> update(@RequestBody PersonDto personDto) {
        if (personService.existById(personDto.getId()) && departmentService.existById(personDto.getDepartmentId())) {
            Person newPerson = personService.find(personDto.getId());

            newPerson.setDepartment(departmentService.find(personDto.getDepartmentId()));
            newPerson.setFirstname(personDto.getFirstname());
            newPerson.setLastname(personDto.getLastname());

            personService.save(newPerson);
            return new ResponseEntity<>(newPerson, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        if (personService.existById(id)) {
            personService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
