package com.javanauta.agendadortarefas.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javanauta.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record TarefasDTORecord(
         String id,
         String  descricao,
         String nomeTarefa,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
         LocalDateTime dataCriacao,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
         LocalDateTime dataEvento,
         String emailUsuario,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
         LocalDateTime dataAlteracao,
         StatusNotificacaoEnum statusNotificacaoEnum) {



}
