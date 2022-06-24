package com.example.demo.service

import com.example.demo.model.Promocao
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap
@Component
class PromocaoServiceImpl: PromocaoService {
    companion object {
        val viagensRealizadas = arrayOf(
            Promocao(1, "viagem a trabalho", "São paulo", 4, true, 0.0),
            Promocao(2, "viagem a passeio", "Bahia", 5, false, 4000.98),
            Promocao(3, "viagem com familia", "SantaCruz", 3, false, 800.00),
            Promocao(4, "viagem estudo", "NY", 12, true,30.0)
        )

    }

    var viagens = ConcurrentHashMap<Int, Promocao>(viagensRealizadas.associateBy(Promocao::id))




    override fun addNovaViagem(promocao: Promocao) {
        viagens[promocao.id] = promocao

    }

    override fun delete(id: Int) {
        viagens.remove(id)
    }

    override fun getGetById(id: Int): Promocao? {
        return viagens[id]
    }

    override fun localFilter(localFilter: String): List<Promocao> {
     return  viagens.filter {
            it.value.local.contains(localFilter, true)
        }.map(Map.Entry<Int, Promocao>::value).toList()
    }

    override fun update(id: Int, promocao: Promocao) {
        delete(id)
        addNovaViagem(promocao)
    }


}