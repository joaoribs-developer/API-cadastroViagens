package com.example.demo.controller

import com.example.demo.DemoApplication.Companion.viagensRealizadas
import com.example.demo.model.Promocao
import com.fasterxml.jackson.annotation.JacksonInject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Delayed
@RequestMapping(value = ["/promocoes"])
@RestController
class PromocaoController {
    @Autowired
    lateinit var viagens: ConcurrentHashMap<Int, Promocao>

  //  @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.GET])
    @GetMapping(value = ["/{id}"])
    fun getPromocao(@PathVariable id: Int) = viagens[id]

  //  @RequestMapping(value = ["/promocoes"], method = [RequestMethod.POST])
    @PostMapping
    fun addNovaViagem(@RequestBody promocao: Promocao) {
        viagens[promocao.id] = promocao
    }

   // @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.DELETE])
    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Int) {
        viagens.remove(id)
    }

  //  @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.PUT])
    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Int, @RequestBody promocao: Promocao) {
        viagens.remove(id)
        viagens[promocao.id] = promocao
    }

   // @RequestMapping(value = ["/promocoes"], method = [RequestMethod.GET])
    @GetMapping()
    fun allViagens(@RequestParam(required = false, defaultValue = "") localFilter: String) =
       viagens.filter {
            it.value.local.contains(localFilter, true)
        }.map(Map.Entry<Int, Promocao>::value).toList()
    }






