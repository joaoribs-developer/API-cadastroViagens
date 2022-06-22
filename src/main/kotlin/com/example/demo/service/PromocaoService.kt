package com.example.demo.service

import com.example.demo.model.Promocao

interface PromocaoService {

    fun addNovaViagem (promocao: Promocao)
    fun delete (id : Int)
    fun getGetById (id: Int): Promocao?
    fun localFilter(localFilter : String): List<Promocao>
    fun update (id: Int, promocao: Promocao)
}