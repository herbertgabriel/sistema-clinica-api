package com.sistemaclinica.api.controllers;

import com.sistemaclinica.api.dtos.consulta.DTOAgendamentoConsultas;
import com.sistemaclinica.api.dtos.consulta.DTODetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DTOAgendamentoConsultas dados){
        return ResponseEntity.ok(new DTODetalhamentoConsulta(dados));
    }
}
