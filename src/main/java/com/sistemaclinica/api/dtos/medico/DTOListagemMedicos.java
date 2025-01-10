package com.sistemaclinica.api.dtos.medico;

import com.sistemaclinica.api.models.Especialidade;
import com.sistemaclinica.api.models.Medico;

public record DTOListagemMedicos(String nome, String email, String crm, Especialidade especialidade) {
    public DTOListagemMedicos(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
