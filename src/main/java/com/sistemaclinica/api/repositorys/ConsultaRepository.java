package com.sistemaclinica.api.repositorys;

import com.sistemaclinica.api.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
