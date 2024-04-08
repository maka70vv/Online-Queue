package org.exaple.online_queue.controllers;

import lombok.AllArgsConstructor;
import org.exaple.online_queue.models.Filial;
import org.exaple.online_queue.models.WorkingTime;
import org.exaple.online_queue.services.impl.FilialService;
import org.exaple.online_queue.services.impl.WorkTimeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filial")
@AllArgsConstructor
public class FilialController {
    private final FilialService filialService;
    private final WorkTimeService workTimeService;

    @GetMapping("/all")
    public List<Filial> getFilial() {
        return filialService.getFilials();
    }

    @GetMapping
    public Filial getFilialById(@RequestParam("id") Long id) {
        return filialService.getFilialById(id);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Filial createFilial(@RequestBody Filial filial) {
        return filialService.createFilial(filial);
    }

    @PatchMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public Filial updateFilial(@RequestBody Filial filial) {
        return filialService.updateFilial(filial);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteFilial(@RequestParam("id") Long id) {
        filialService.deleteFilial(id);
    }
}
