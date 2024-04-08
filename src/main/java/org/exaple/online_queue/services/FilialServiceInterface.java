package org.exaple.online_queue.services;

import org.exaple.online_queue.models.Filial;

import java.util.List;

public interface FilialServiceInterface {
    List<Filial> getFilials();
    Filial getFilialById(Long id);
    Filial createFilial(Filial filial);
    Filial updateFilial(Filial filial);
    Filial deleteFilial(Long id);
}
