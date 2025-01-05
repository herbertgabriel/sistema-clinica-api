package com.api.clinica.DTOs.paciente;

import com.api.clinica.models.Paciente;

public record DTOListagemPaciente(Long id, String nome, String email, String cpf) {
    public DTOListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
