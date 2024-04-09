package org.exaple.online_queue.services.impl;

import org.exaple.online_queue.models.Queue;
import org.exaple.online_queue.models.Services;
import org.exaple.online_queue.models.Users;
import org.exaple.online_queue.repositories.QueueRepository;
import org.exaple.online_queue.repositories.ServiceRepository;
import org.exaple.online_queue.repositories.UserRepo;
import org.exaple.online_queue.services.QueueServiceInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Primary
@Service
public class QueueService implements QueueServiceInterface {
    private final QueueRepository queueRepository;
    private final ServiceRepository serviceRepository;
    private final UserRepo userRepository;

    public QueueService(QueueRepository queueRepository, ServiceRepository serviceRepository, UserRepo userRepository) {
        this.queueRepository = queueRepository;
        this.serviceRepository = serviceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Queue> getQueues() {
        return queueRepository.findAll();
    }

    @Override
    public Queue getQueue(String queueName) {
        return queueRepository.findByQueueName(queueName);
    }

    @Override
    public void deleteQueue(Long id) {
        queueRepository.deleteById(id);
    }

    @Override
    public Queue addQueue(Queue queue) {
        if (queue.getService() != null && queue.getService().getId() != null) {
            Services service = serviceRepository.findById(queue.getService().getId()).orElse(null);
            queue.setService((Services) service);
        }

        // Поиск пользователя по переданному идентификатору и установка его в поле user
        if (queue.getUser() != null && queue.getUser().getId() != null) {
            Users user = userRepository.findById(queue.getUser().getId()).orElse(null);
            queue.setUser(user);
        }
        String serviceCode = queue.getService().getServiceCode();
        queue.setQueueName(serviceCode + "-" + queue.getId());
        return queueRepository.save(queue);
    }

    @Override
    public Queue startQueue(Queue queue) {
        queue.setWorkInProgress(true);
        queue.setInWorkStarted(LocalDateTime.now());
        return queueRepository.save(queue);
    }

    @Override
    public Queue endQueue(Queue queue) {
        queue.setFinished(true);
        queue.setWorkInProgress(false);
        queue.setInWorkEnded(LocalDateTime.now());
        long timeInMinutes = ChronoUnit.MINUTES.between(queue.getInWorkStarted(), queue.getInWorkEnded());
        queue.setTimeInWork(Math.toIntExact(timeInMinutes));
        return queueRepository.save(queue);
    }

    @Override
    public Queue getQueueByUser(Long userId) {
        return queueRepository.findByUserId(userId);
    }

    @Override
    public List<Queue> getQueuesToday() {
        LocalDateTime startOfToday = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfToday = LocalDateTime.now().with(LocalTime.MAX);
        return Collections.singletonList(queueRepository.findByCreationTimeBetween(startOfToday, endOfToday));
    }

    @Override
    public List<Queue> getActualQueues() {
        Queue queue = queueRepository.findByWorkInProgressAndIsFinished(false, false);
        List<Queue> queues = new ArrayList<>();
        if (queue != null) {
            queues.add(queue);
        }
        return queues;
    }
}
