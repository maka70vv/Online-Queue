package org.exaple.online_queue.services;

import org.exaple.online_queue.models.Queue;

import java.util.List;

public interface QueueServiceInterface {
    List<Queue> getQueues();
    Queue getQueue(String queueName);
    void deleteQueue(Long id);
    Queue addQueue(Queue queue);
    Queue startQueue(Queue queue);
    Queue endQueue(Queue queue);
    Queue getQueueByUser(Long userId);
    List<Queue> getQueuesToday();
    List<Queue> getActualQueues();
}
