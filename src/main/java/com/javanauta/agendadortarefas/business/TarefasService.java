package com.javanauta.agendadortarefas.business;

import com.javanauta.agendadortarefas.business.dto.TarefasDTORecord;
import com.javanauta.agendadortarefas.business.mapper.TarefaUpdateConverter;
import com.javanauta.agendadortarefas.business.mapper.TarefasConverter;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.javanauta.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;
    private final TarefaUpdateConverter tarefaUpdateConverter;

    //Salva as tarefas no mongoDB
    public TarefasDTORecord gravarTarefa(String token, TarefasDTORecord dto) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        TarefasDTORecord dtoFinal = new TarefasDTORecord(null, dto.nomeTarefa(),dto.descricao(), LocalDateTime.now(), dto.dataEvento(), email, null, StatusNotificacaoEnum.PENDENTE);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dtoFinal);
        return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }


    public List<TarefasDTORecord> bucasTarefasAgendadasPorPeriodo (LocalDateTime dataInicial, LocalDateTime dataFinal) {

        return  tarefasConverter.paraListaTarefasDTORecord(
                tarefasRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial,
                        dataFinal, StatusNotificacaoEnum.PENDENTE));
    }

    public List<TarefasDTORecord> buscaTarefasPorEmail(String token) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

        return tarefasConverter.paraListaTarefasDTORecord(listaTarefas);
    }

    public  void deletaTerefaPorId(String id) {
        try {
            tarefasRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao deletar tarefa por id, id não encontrado" + id, e.getCause());
        }
    }

    public TarefasDTORecord alteraStatus(StatusNotificacaoEnum status, String id) {
        try{
        TarefasEntity entity = tarefasRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada" + id));
                entity.setStatusNotificacaoEnum(status);
                return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));
        } catch (ResourceNotFoundException e){

            throw new ResourceNotFoundException("Erro ao alterar status da tarefa" + e.getCause());

        }
    }

    public TarefasDTORecord updateTarefas(TarefasDTORecord dto, String id) {
        try {
            TarefasEntity entity = tarefasRepository.findById(id).
                    orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada" + id));

                tarefaUpdateConverter.updateTarefas(dto, entity);
            return tarefasConverter.paraTarefaDTO(tarefasRepository.save(entity));

        } catch (ResourceNotFoundException e){

            throw new ResourceNotFoundException("Erro ao alterar status da tarefa" + e.getCause());

        }
    }


}
