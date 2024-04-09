package org.exaple.online_queue.controllers;

import lombok.AllArgsConstructor;
import org.exaple.online_queue.models.Department;
import org.exaple.online_queue.services.impl.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/all")
    public List<Department> getAll() {
        return departmentService.getAllDepartments();
    }

    @GetMapping
    public Department get(@RequestParam Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/create")
    public Department create(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PatchMapping("/update")
    public Department update(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id) {
        departmentService.deleteDepartment(id);
    }
}
