package com.api.clinica.models;

import com.api.clinica.DTOs.DTOEndereco;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "medicos")
@Entity(name = "Medico")
@Data
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
}
