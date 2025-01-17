package com.sistemaclinica.api.dtos.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sistemaclinica.api.models.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOAgendamentoConsultas(
        Long idMedico,
        @NotNull Long idPaciente,
        @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime data,

        Especialidade especialidade
        ) {
}
