package org.exaple.online_queue.services;

import org.exaple.online_queue.models.WorkingTime;

import java.util.List;

public interface WorkingTimeServiceInterface {
    List<WorkingTime> getWorkingTime();
    WorkingTime getWorkingTime(String id);
    WorkingTime addWorkingTime(WorkingTime workingTime);
    WorkingTime updateWorkingTime(WorkingTime workingTime);
    WorkingTime removeWorkingTime(String id);
    List<WorkingTime> addWorkingTimes(List<WorkingTime> workingTimes);
}
