package com.api.clinica.controllers;

import com.api.clinica.DTOs.DTOCadastroMedico;
import com.api.clinica.models.Medico;
import com.api.clinica.repositorys.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/medico")
    @Transactional
    public void cadastrarMedico(@RequestBody DTOCadastroMedico medico) {
        medicoRepository.save(new Medico(medico));
    }
}
