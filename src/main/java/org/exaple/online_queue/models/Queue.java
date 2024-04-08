package org.exaple.online_queue.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Service service;
    private boolean workInProgress = false;
    private boolean isFinished = false;
    private LocalDateTime creationTime;
    private LocalDateTime inWorkStarted;
    private LocalDateTime inWorkEnded;
    @OneToOne
    private Users user;
    private String queueName;


    @PrePersist
    protected void onCreate() {
        creationTime = LocalDateTime.now();
    }
}
