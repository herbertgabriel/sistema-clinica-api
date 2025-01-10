package com.sistemaclinica.api.dtos.medico;

import com.sistemaclinica.api.models.Endereco;
import com.sistemaclinica.api.models.Especialidade;
import com.sistemaclinica.api.models.Medico;

public record DTODetalhesMedico(Long id, String nome, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DTODetalhesMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
