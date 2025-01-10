package com.sistemaclinica.api.dtos.paciente;

import com.sistemaclinica.api.dtos.DTOEndereco;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizarPaciente(
        @NotNull Long id,
        String nome,
        String telefone,
        DTOEndereco endereco
) {
}
