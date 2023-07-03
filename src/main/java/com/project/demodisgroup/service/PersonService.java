package com.project.demodisgroup.service;

import com.project.demodisgroup.dto.PersonDto;
import com.project.demodisgroup.entity.Department;
import com.project.demodisgroup.entity.Person;
import com.project.demodisgroup.repository.DepartmentRepository;
import com.project.demodisgroup.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {
    public PersonService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
    }

    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;

//    public void save(PersonDto personDto) {
//        personRepository.save(new Person()
//                .builder()
//                .id(personDto.getId())
//                .firstname(personDto.getFirstname())
//                .lastname(personDto.getLastname())
//                .department(new Department().builder()
//                        .id(personDto.getDepartment().getId())
//                        .name(personDto.getDepartment().getName())
//                        .build())
//                .build());
//    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person find(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Cant find person with id = " + id));
    }
    public List<Person> findAll(){
        return (List<Person>) personRepository.findAll();
    }

    public void delete(Long id){
        personRepository.findById(id).get().getDepartment().removePerson(personRepository.findById(id).get());
        personRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return personRepository.existsById(id);
    }
}
