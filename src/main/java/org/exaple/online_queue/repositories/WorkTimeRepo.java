package org.exaple.online_queue.repositories;

import org.exaple.online_queue.models.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTimeRepo extends JpaRepository<WorkingTime, Long> {
}
