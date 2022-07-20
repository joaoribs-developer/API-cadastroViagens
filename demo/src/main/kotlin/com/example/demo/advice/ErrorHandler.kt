package com.example.demo.advice

import com.example.demo.exception.PromocaoNotFoundException
import com.example.demo.model.ErrorMessage
import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception):
            ResponseEntity<String> {
        return ResponseEntity("Erro no json", HttpStatus.BAD_REQUEST)
    }



    @ExceptionHandler(PromocaoNotFoundException::class)
    fun PromocaoNotFoundExceptionHandler(
        servletRequest: HttpServletRequest,
        servletResponse: HttpServletResponse,
        exception: Exception
    ):
            ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage("Promocao não encontrada", exception.message!!), HttpStatus.NOT_FOUND)

    }
}