package com.example.demo.controller

import com.example.demo.model.Cursos
import com.example.demo.model.ErrorMessage
import com.example.demo.service.CursosService
import com.example.demo.service.CursosServiceImpl
import com.example.demo.service.MensageCreated
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.persistence.Id

@RestController
@RequestMapping(value = ["/cursos"])
class CursosController {
    @Autowired
    lateinit var cursosService: CursosService

    @GetMapping
    fun getAll(): ResponseEntity<List<Cursos>>{
        var curso = this.cursosService.getAll()
        return ResponseEntity(curso, HttpStatus.OK)
    }

    @PostMapping
    fun saveCurso(@RequestBody cursos: Cursos): ResponseEntity<MensageCreated>{
        this.cursosService.newCurso(cursos)
        val menssage = MensageCreated("Criado com sucesso", date = Date())
        return ResponseEntity(menssage, HttpStatus.OK)
    }

    @GetMapping(value = ["/{id}"])
    fun getById (@PathVariable id: Int): ResponseEntity<Any>{
        var pesquisa = this.cursosService.getById(id)
        return if (pesquisa != null) ResponseEntity(pesquisa, HttpStatus.OK)
        else ResponseEntity(ErrorMessage("Erro na consulta", "Id: ${id} não foi encontrado"), HttpStatus.NOT_FOUND)
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Int, @RequestBody cursos: Cursos): ResponseEntity<MensageCreated>{
        this.cursosService.newCurso(cursos)
        var mensage = MensageCreated("Atualizado com sucesso", Date())
        return ResponseEntity(mensage, HttpStatus.OK)
    }
    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Int,): ResponseEntity<MensageCreated>{
        this.cursosService.delete(id)
        var message = MensageCreated("Deletado com sucesso", Date())
        return ResponseEntity(message, HttpStatus.OK)
    }
}