package com.example.demo

import com.example.demo.model.Promocao
import com.fasterxml.jackson.annotation.JacksonInject
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScanPackages
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMethod
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class DemoApplication {
    companion object {
        val viagensRealizadas = arrayOf(
            Promocao(1, "viagem a trabalho", "São paulo", 4, true, 0.0),
            Promocao(2, "viagem a passeio", "Bahia", 5, false, 4000.98),
            Promocao(3, "viagem com familia", "SantaCruz", 3, false, 800.00),
            Promocao(4, "viagem estudo", "NY", 12, true,30.0)
        )

    }
    @Bean
    fun viagens () = ConcurrentHashMap<Int, Promocao>(viagensRealizadas.associateBy(Promocao::id))

}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
