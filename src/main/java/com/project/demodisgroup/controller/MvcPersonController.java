package com.project.demodisgroup.controller;

import com.project.demodisgroup.entity.Department;
import com.project.demodisgroup.entity.Person;
import com.project.demodisgroup.repository.DepartmentRepository;
import com.project.demodisgroup.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mvc/person")
public class MvcPersonController {

    private final PersonService personService;

    private final DepartmentRepository departmentService;

    public MvcPersonController(PersonService personService, DepartmentRepository departmentService) {
        this.personService = personService;
        this.departmentService = departmentService;
    }

    @ModelAttribute(name = "newPerson")
    public Person newPerson() {
        return new Person();
    }

    @ModelAttribute(name = "departments")
    public List<Department> loadDepartments() {
        return (List<Department>) departmentService.findAll();
    }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable Long id, Model model) {
        model.addAttribute("persons", Arrays.asList(personService.find(id)));
        return "person";
    }

    @GetMapping("/")
    public String getListPerson(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person";
    }

    @PostMapping("/")
    public String createPerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/mvc/person/";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return "redirect:/mvc/person/";
    }

    @GetMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.find(id));
        return "update-person";
    }

    @PostMapping("/update/")
    public String updatePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/mvc/person/";
    }

}
