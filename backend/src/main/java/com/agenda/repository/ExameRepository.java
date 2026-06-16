package com.agenda.repository;

import com.agenda.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExameRepository extends JpaRepository<Exame, Long> {
    List<Exame> findAll();
}
