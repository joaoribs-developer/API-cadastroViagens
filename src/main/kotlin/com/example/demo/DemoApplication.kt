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
class DemoApplication


fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
