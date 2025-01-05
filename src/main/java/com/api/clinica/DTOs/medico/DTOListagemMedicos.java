package com.api.clinica.DTOs.medico;

import com.api.clinica.models.Especialidade;
import com.api.clinica.models.Medico;

public record DTOListagemMedicos(String nome, String email, String crm, Especialidade especialidade) {
    public DTOListagemMedicos(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
