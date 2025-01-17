package com.sistemaclinica.api.services;

import com.sistemaclinica.api.dtos.consulta.DTOAgendamentoConsultas;
import com.sistemaclinica.api.exceptions.ValidacaoException;
import com.sistemaclinica.api.models.Consulta;
import com.sistemaclinica.api.models.Medico;
import com.sistemaclinica.api.repositorys.ConsultaRepository;
import com.sistemaclinica.api.repositorys.MedicoRepository;
import com.sistemaclinica.api.repositorys.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    public void agendar(DTOAgendamentoConsultas dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do Paciente informado não existe!");
        }
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do Medico informado não existe!");
        }
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DTOAgendamentoConsultas dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatório quando médico não for escolhido");

        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());


    }
}
