package com.sistemaclinica.api.dtos.paciente;

import com.sistemaclinica.api.models.Endereco;
import com.sistemaclinica.api.models.Paciente;

public record DTODetalhesPaciente(Long id, String nome, String email, String telefone, Endereco endereco) {
    public DTODetalhesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco());
    }
}
