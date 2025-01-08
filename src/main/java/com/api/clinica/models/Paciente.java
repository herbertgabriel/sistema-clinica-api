package com.api.clinica.models;

import com.api.clinica.DTOs.paciente.DTOAtualizarPaciente;
import com.api.clinica.DTOs.paciente.DTOCadastroPaciente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Data
@NoArgsConstructor
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
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = new Endereco();
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
