package org.exaple.online_queue.repositories;

import org.exaple.online_queue.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
