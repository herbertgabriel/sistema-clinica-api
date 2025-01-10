package com.sistemaclinica.api.dtos.medico;

import com.sistemaclinica.api.dtos.DTOEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DTOAtualizarMedico(@NotNull Long id, String nome, String telefone, @Valid DTOEndereco endereco) {
}
