package com.example.demo.controller

import com.example.demo.model.Promocao
import com.example.demo.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping(value = ["/promocoes"])
@RestController
class PromocaoController {
    @Autowired
    lateinit var promocaoService: PromocaoService

    //  @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.GET])
    @GetMapping(value = ["/{id}"])
    fun getPromocao(@PathVariable id: Int) = this.promocaoService.getGetById(id)

    //  @RequestMapping(value = ["/promocoes"], method = [RequestMethod.POST])
    @PostMapping
    fun addNovaViagem(@RequestBody promocao: Promocao) = this.promocaoService.addNovaViagem(promocao)

    // @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.DELETE])
    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Int) = this.promocaoService.delete(id)

    //  @RequestMapping(value = ["/promocoes/{id}"], method = [RequestMethod.PUT])
    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Int, @RequestBody promocao: Promocao) = this.promocaoService.update(id, promocao)


    // @RequestMapping(value = ["/promocoes"], method = [RequestMethod.GET])
    @GetMapping()
    fun allViagens(@RequestParam(required = false, defaultValue = "") localFilter: String) =
        this.promocaoService.localFilter(localFilter)


}







