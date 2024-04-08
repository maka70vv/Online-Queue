package org.exaple.online_queue.controllers;

import lombok.AllArgsConstructor;
import org.exaple.online_queue.models.WorkingTime;
import org.exaple.online_queue.services.impl.WorkTimeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/work-time")
@AllArgsConstructor
public class WorkTimeController {
    private final WorkTimeService workTimeService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public WorkingTime createWorkTime(@RequestBody WorkingTime workingTime) {
        return workTimeService.addWorkingTime(workingTime);
    }

    @PatchMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public WorkingTime updateWorkTime(@RequestBody WorkingTime workingTime) {
        return workTimeService.updateWorkingTime(workingTime);
    }
}
