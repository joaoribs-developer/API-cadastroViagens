package com.example.demo.repository

import com.example.demo.model.Cursos
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CursosRepository: CrudRepository<Cursos, Int> {
}