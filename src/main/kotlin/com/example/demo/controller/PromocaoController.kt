package com.example.demo.controller

import com.example.demo.model.Promocao
import com.example.demo.service.MensagemCreated
import com.example.demo.service.PromocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.StreamingHttpOutputMessage.Body
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping(value = ["/promocoes"])
@RestController
class PromocaoController {
    @Autowired
    lateinit var promocaoService: PromocaoService


    @GetMapping(value = ["/{id}"])
    fun getPromocao(@PathVariable id: Int): ResponseEntity<Promocao?>   {
        var parametroResponseEntity = this.promocaoService.getGetById(id)
        var statusResponseEntity = if (parametroResponseEntity == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(parametroResponseEntity, statusResponseEntity)//recebe 2 parametros objeto e status

    }


    @PostMapping
    fun addNovaViagem(@RequestBody promocao: Promocao): ResponseEntity<MensagemCreated> {
        this.promocaoService.addNovaViagem(promocao)
        var menssagemCRUD = MensagemCreated("Registro criado com sucesso", Date())
        return ResponseEntity(menssagemCRUD, HttpStatus.CREATED)
//        var promocao = this.promocaoService.addNovaViagem(promocao)
//        var status = HttpStatus.CREATED
//        return ResponseEntity(promocao, status)
    }


    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Int): ResponseEntity<Unit>{

    var status = HttpStatus.NOT_FOUND
        if (this.promocaoService.getGetById(id) != null){
            status = HttpStatus.ACCEPTED
            this.promocaoService.delete(id)
        }
        return ResponseEntity(Unit, status)
    }


    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Int, @RequestBody promocao: Promocao): ResponseEntity<Unit> {
        var status = HttpStatus.NOT_FOUND
        if (this.promocaoService.getGetById(id) != null){
            status = HttpStatus.CREATED
            this.promocaoService.update(id, promocao)
        }
        return ResponseEntity(Unit, status)
    }



    @GetMapping()
    fun allViagens(@RequestParam(required = false, defaultValue = "") localFilter: String): ResponseEntity<List<Promocao>>{
       var promocao = this.promocaoService.localFilter(localFilter)
        return ResponseEntity(promocao, HttpStatus.OK)
    }



}







