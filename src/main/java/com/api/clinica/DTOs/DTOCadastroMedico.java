package com.api.clinica.DTOs;

import com.api.clinica.models.Especialidade;

public record DTOCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DTOEndereco endereco) {
}
