package com.sistemaclinica.api.dtos.consulta;

import java.time.LocalDateTime;

public record DTODetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
