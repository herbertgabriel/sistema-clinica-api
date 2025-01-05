package com.api.clinica.DTOs.paciente;

import com.api.clinica.models.Endereco;
import com.api.clinica.models.Paciente;

public record DTODetalhesPaciente(Long id, String nome, String telefone, Endereco endereco) {
    public DTODetalhesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEndereco());
    }
}
