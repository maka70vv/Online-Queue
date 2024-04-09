package org.exaple.online_queue.services;


import org.exaple.online_queue.models.Services;

import java.util.List;

public interface ServicesServiceInterface {
    List<Services> getServices();
    Services getServiceById(Long serviceId);
    Services createService(Services service);
    Services updateService(Services service);
    void deleteService(Long serviceId);
}
