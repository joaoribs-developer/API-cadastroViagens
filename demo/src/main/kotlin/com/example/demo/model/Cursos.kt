package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Cursos(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 1,
    val descricao: String = "",
    val plataforma: String = "",
    val qtHoras :Int = 0,
    val valor : Double = 0.0,
    val concluido: Boolean = true,

)
