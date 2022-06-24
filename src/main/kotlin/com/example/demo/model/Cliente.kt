package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
//não exibir null no jackson
data class Cliente(val id: String, val nome:String,
/* formartar um campo especifico da sua classe na hora de imprimir o json */
                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") val date: Date

                   ,val telefone: Telefone?)


// @JsonIgnoreProperties("tipo") ignorar um determinado campo na hora de mostrar o json
data class Telefone(val ddd:String, val numero: String, @JsonIgnore val tipo :String)