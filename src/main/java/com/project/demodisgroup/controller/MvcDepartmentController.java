package com.project.demodisgroup.controller;

import com.project.demodisgroup.entity.Department;
import com.project.demodisgroup.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/mvc/department")
public class MvcDepartmentController {

    private final DepartmentService departmentService;

    public MvcDepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @ModelAttribute(name = "newDepartment")
    public Department newPerson() {
        return new Department();
    }

    ////////////////////


    @GetMapping("/{id}")
    public String getDepartment(@PathVariable Long id, Model model) {
        model.addAttribute("departments", Arrays.asList(departmentService.find(id)));
        return "department";
    }

    @GetMapping("/")
    public String getListDepartment(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "department";
    }

    @PostMapping("/")
    public String createDepartment(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/mvc/department/";
    }

    @PostMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
        return "redirect:/mvc/department/";
    }

    @GetMapping("/update/{id}")
    public String updateDepartment(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.find(id));
        return "update-department";
    }

    @PostMapping("/update/")
    public String updateDepartment(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/mvc/department/";
    }


}
