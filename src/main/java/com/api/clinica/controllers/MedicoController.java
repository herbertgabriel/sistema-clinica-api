package com.api.clinica.controllers;

import com.api.clinica.DTOs.DTOAtualizarMedico;
import com.api.clinica.DTOs.DTOCadastroMedico;
import com.api.clinica.DTOs.DTOListagemMedicos;
import com.api.clinica.models.Medico;
import com.api.clinica.repositorys.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/medico")
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DTOCadastroMedico medico) {
        medicoRepository.save(new Medico(medico));
    }

    @GetMapping
    public Page<DTOListagemMedicos> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(DTOListagemMedicos::new);
    }

    @PatchMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DTOAtualizarMedico dadosMedico){
        var medico = medicoRepository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.desativar();
    }




}
