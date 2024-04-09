package org.exaple.online_queue.services;

import org.exaple.online_queue.models.Department;

import java.util.List;

public interface DepartmentServiceInterface {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department createDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Long id);
}
