package org.exaple.online_queue.repositories;

import org.exaple.online_queue.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface QueueRepository extends JpaRepository<Queue, Long> {
    Queue findByQueueName(String queueName);
    Queue findByUserId(Long userId);
    Queue findByCreationTimeBetween(LocalDateTime startOfToday, LocalDateTime endOfToday);
    Queue findByWorkInProgressAndIsFinished(Boolean workInProgress, Boolean isFinished);
}
