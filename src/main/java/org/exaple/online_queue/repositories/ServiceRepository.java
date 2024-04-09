package org.exaple.online_queue.repositories;

import org.exaple.online_queue.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services, Long> {

}
