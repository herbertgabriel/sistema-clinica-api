package com.api.clinica.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizarMedico(@NotNull Long id, String nome, String telefone, @Valid DTOEndereco endereco) {
}
