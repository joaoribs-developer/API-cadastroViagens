package com.example.demo.model

import java.lang.reflect.GenericArrayType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table



@Entity
data class Promocao (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 1,
    val descricao: String = "",
    val local: String = "",
    val qtDias :Int = 0,
    val isAllInclusive :Boolean = true,
    val valor : Double = 0.0

        )
