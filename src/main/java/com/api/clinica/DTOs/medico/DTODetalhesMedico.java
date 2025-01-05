package com.api.clinica.DTOs;

import com.api.clinica.models.Endereco;
import com.api.clinica.models.Especialidade;
import com.api.clinica.models.Medico;

public record DTODetalhesMedico(Long id, String nome, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DTODetalhesMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
