package com.example.demo.model

data class Promocao (
    val id: Int,
    val descricao: String,
    val local: String,
    val qtDias :Int,
    val isAllInclusive :Boolean,
    val valor : Double

        )
