package org.exaple.online_queue.services.impl;

import org.exaple.online_queue.models.Services;
import org.exaple.online_queue.repositories.ServiceRepository;
import org.exaple.online_queue.services.ServicesServiceInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ServicesService implements ServicesServiceInterface {
    private final ServiceRepository serviceRepository;

    public ServicesService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Services> getServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Services getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId).orElse(null);
    }

    @Override
    public Services createService(Services service) {
        return serviceRepository.save(service);
    }

    @Override
    public Services updateService(Services services) {
        return serviceRepository.save(services);
    }

    @Override
    public void deleteService(Long serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
