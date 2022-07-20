package com.example.demo.service

import com.example.demo.model.Cursos
import com.example.demo.repository.CursosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CursosServiceImpl: CursosService {
    @Autowired
    lateinit var cursosRepository: CursosRepository


    override fun getAll(): List<Cursos> {
       return this.cursosRepository.findAll().toList()
    }

    override fun getById(id: Int): Cursos? {
        return this.cursosRepository.findById(id).orElseGet(null)
    }

    override fun newCurso(cursos: Cursos) {
        this.cursosRepository.save(cursos)
    }

    override fun delete(id: Int) {
        this.cursosRepository.deleteById(id)
    }

    override fun update(id: Int, cursos: Cursos): Cursos {
        return this.cursosRepository.save(cursos)
    }


}