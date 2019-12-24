package com.qovery.example.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by evoxmusic on 24/12/2019.
 */
@RestController
@RequestMapping("/")
class RootController {

    @GetMapping
    fun sayHello() = mapOf("results" to listOf(mapOf("name" to "john", "age" to 33, "city" to "Paris")))

}
