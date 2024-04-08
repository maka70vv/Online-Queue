package org.exaple.online_queue.services.impl;

import lombok.AllArgsConstructor;
import org.exaple.online_queue.models.Filial;
import org.exaple.online_queue.repositories.FilialRepository;
import org.exaple.online_queue.services.FilialServiceInterface;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class FilialService implements FilialServiceInterface {
    private final FilialRepository filialRepository;

    @Override
    public List<Filial> getFilials() {
        return filialRepository.findAll();
    }

    @Override
    public Filial getFilialById(Long id) {
        return filialRepository.findById(id).orElse(null);
    }

    @Override
    public Filial createFilial(Filial filial) {
        return filialRepository.save(filial);
    }

    @Override
    public Filial updateFilial(Filial filial) {
        return filialRepository.save(filial);
    }

    @Override
    public Filial deleteFilial(Long id) {
        filialRepository.deleteById(id);
        return null;
    }
}
