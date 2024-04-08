package org.exaple.online_queue.services.impl;

import lombok.AllArgsConstructor;
import org.exaple.online_queue.models.WorkingTime;
import org.exaple.online_queue.repositories.WorkTimeRepo;
import org.exaple.online_queue.services.WorkingTimeServiceInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class WorkTimeService implements WorkingTimeServiceInterface {

    WorkTimeRepo workTimeRepo;

    @Override
    public List<WorkingTime> getWorkingTime() {
        return workTimeRepo.findAll();
    }

    @Override
    public WorkingTime getWorkingTime(String id) {
        return workTimeRepo.getReferenceById(Long.valueOf(id));
    }

    @Override
    public WorkingTime addWorkingTime(WorkingTime workingTime) {
        return workTimeRepo.save(workingTime);
    }

    @Override
    public WorkingTime updateWorkingTime(WorkingTime workingTime) {
        return workTimeRepo.save(workingTime);
    }

    @Override
    public WorkingTime removeWorkingTime(String id) {
        workTimeRepo.deleteById(Long.valueOf(id));
        return workTimeRepo.getReferenceById(Long.valueOf(id));
    }

    @Override
    public List<WorkingTime> addWorkingTimes(List<WorkingTime> workingTimes) {
        return workTimeRepo.saveAll(workingTimes);
    }
}
