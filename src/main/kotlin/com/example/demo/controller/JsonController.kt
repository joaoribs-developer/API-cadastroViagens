package com.example.demo.controller

import com.example.demo.model.Cliente
import com.example.demo.model.ObjectJson
import com.example.demo.model.Telefone
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date
import javax.xml.crypto.Data

@RequestMapping(value = ["/promocoes"])
@RestController
class JsonController {

    @GetMapping("/json")
    fun getJson() = ObjectJson ()

    @GetMapping("/cliente")
    fun getCliente() :Cliente {
        var telefone = Telefone("027"," 992986559", "Celular")
        var cliente = Cliente("1", "JoãoVitor", Date(), telefone )//pode receber valor null ou nao
        return cliente
    }
//    fun getCliente():Cliente = Cliente("1","João Vitor",tel)
//    var tel = Telefone("027", "992986559","Celular")



    }



