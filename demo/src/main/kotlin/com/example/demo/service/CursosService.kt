package com.example.demo.service

import com.example.demo.model.Cursos

interface CursosService {
    fun getAll(): List<Cursos>
    fun getById(id: Int): Cursos?
    fun newCurso(cursos: Cursos)
    fun delete(id: Int)
    fun update(id: Int, cursos: Cursos): Cursos
}