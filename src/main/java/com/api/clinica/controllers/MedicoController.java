package com.api.clinica.controllers;

import com.api.clinica.DTOs.medico.DTOAtualizarMedico;
import com.api.clinica.DTOs.medico.DTOCadastroMedico;
import com.api.clinica.DTOs.medico.DTODetalhesMedico;
import com.api.clinica.DTOs.medico.DTOListagemMedicos;
import com.api.clinica.models.Medico;
import com.api.clinica.repositorys.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/medico")
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DTOCadastroMedico dadosMedico, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dadosMedico);

        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DTODetalhesMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DTOListagemMedicos>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(DTOListagemMedicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTODetalhesMedico(medico));
    }

    @PatchMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DTOAtualizarMedico dadosMedico){
        var medico = medicoRepository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);
        return ResponseEntity.ok(new DTODetalhesMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.desativar();
        return ResponseEntity.noContent().build();
    }




}
