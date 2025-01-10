package com.sistemaclinica.api.models;

import com.sistemaclinica.api.dtos.paciente.DTOAtualizarPaciente;
import com.sistemaclinica.api.dtos.paciente.DTOCadastroPaciente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(@Valid DTOCadastroPaciente dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.cpf = dadosPaciente.cpf();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.endereco = new Endereco(dadosPaciente.endereco());
        this.ativo = true;
    }
    public void atualizarInformacoes(DTOAtualizarPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
