package com.api.clinica.DTOs.medico;

import com.api.clinica.DTOs.DTOEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizarMedico(@NotNull Long id, String nome, String telefone, @Valid DTOEndereco endereco) {
}
