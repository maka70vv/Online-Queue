package org.exaple.online_queue.repositories;

import org.exaple.online_queue.models.Filial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {
    Filial findByFilialName(String filialName);
}
