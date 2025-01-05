package com.api.clinica.models;

import com.api.clinica.DTOs.medico.DTOAtualizarMedico;
import com.api.clinica.DTOs.medico.DTOCadastroMedico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Data
@NoArgsConstructor
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DTOCadastroMedico medico) {
        this.nome = medico.nome();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DTOAtualizarMedico dadosMedico) {
        if(dadosMedico.nome() != null && !dadosMedico.nome().isBlank()) {
            this.nome = dadosMedico.nome();
        }
        if(dadosMedico.telefone() != null && !dadosMedico.telefone().isBlank()) {
            this.telefone = dadosMedico.telefone();
        }
        if(dadosMedico.endereco() != null){
            this.endereco.atualizarEndereco(dadosMedico.endereco());
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
