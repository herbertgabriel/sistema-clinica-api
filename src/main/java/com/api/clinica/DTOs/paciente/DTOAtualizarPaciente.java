package com.api.clinica.DTOs.paciente;

import com.api.clinica.DTOs.DTOEndereco;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizarPaciente(
        @NotNull Long id,
        String nome,
        String telefone,
        DTOEndereco endereco
) {
}
