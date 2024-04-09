package org.exaple.online_queue.controllers;

import org.exaple.online_queue.models.Services;
import org.exaple.online_queue.services.impl.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {
    private final ServicesService servicesService;

    public ServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/all")
    public List<Services> getAllServices() {
        return servicesService.getServices();
    }

    @GetMapping
    public Services getServiceById(@RequestParam ("id") Long id) {
        return servicesService.getServiceById(id);
    }

    @PostMapping("/create")
    public Services createService(@RequestBody Services service) {
        return servicesService.createService(service);
    }

    @PatchMapping("/update")
    public Services updateService(@RequestBody Services service) {
        return servicesService.updateService(service);
    }

    @DeleteMapping("/delete")
    public void deleteService(@RequestBody Services service) {
        servicesService.deleteService(service.getId());
    }
}
