package com.qovery.example.controllers

import com.qovery.example.models.User
import com.qovery.example.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by evoxmusic on 25/12/2019.
 */
@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @GetMapping
    fun list(): Iterable<User> = userRepository.findAll()

    @PostMapping
    fun create(@RequestBody user: User): User = userRepository.save(user)

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable id: Long) = userRepository.deleteById(id)

}
