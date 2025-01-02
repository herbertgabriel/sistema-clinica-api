package com.api.clinica.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {

    @PostMapping("/medico")
    public void cadastrarMedico(@RequestBody String medico) {
        
    }
}
