package com.agenda.repository;

import com.agenda.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    List<Atendimento> findAllByOrderByDataAscHoraAsc();
}
