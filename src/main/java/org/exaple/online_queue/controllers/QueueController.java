package org.exaple.online_queue.controllers;

import lombok.AllArgsConstructor;
import org.exaple.online_queue.models.Queue;
import org.exaple.online_queue.services.impl.QueueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queue")
@AllArgsConstructor
public class QueueController {
    private final QueueService queueService;

    @GetMapping("/all")
    public List<Queue> getQueues() {
        return queueService.getQueues();
    }

    @GetMapping
    public Queue getQueue(@RequestParam ("queue_name") String queueName) {
        return queueService.getQueue(queueName);
    }

    @DeleteMapping("/delete")
    public void deleteQueue(@RequestParam ("queue_id") Long queue_id) {
        queueService.deleteQueue(queue_id);
    }

    @PostMapping("/add")
    public Queue addQueue(@RequestBody Queue queue) {
        return queueService.addQueue(queue);
    }

    @PatchMapping("/start_work")
    public Queue startWork(@RequestBody Queue queue) {
        return queueService.startQueue(queue);
    }

    @PatchMapping("/end_work")
    public Queue endWork(@RequestBody Queue queue) {
        return queueService.endQueue(queue);
    }

    @GetMapping("/get/by_worker")
    public Queue getQueueByWorker(@RequestParam ("userId") Long userId) {
        return queueService.getQueueByUser(userId);
    }

    @GetMapping("/today")
    public List<Queue> getQueueToday() {
        return queueService.getQueuesToday();
    }

    @GetMapping("/actual")
    public List<Queue> getQueueActual() {
        return queueService.getActualQueues();
    }

}
