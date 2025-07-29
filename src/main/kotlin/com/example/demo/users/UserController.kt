package com.example.demo.users

import org.springframework.data.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(@Autowired private val userRepository: UserRepository){
    
    // Get a list of all users
    @GetMapping("")
    fun getAllUsers(): List<User> = userRepository.findAll().toList()

    // Create a new user
    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        // Save the user entity to the database
        val savedUser = userRepository.save(user)
        // Return the saved user with HTTP 201 Created status
        return ResponseEntity(savedUser, HttpStatus.CREATED)
    }

    // Get user by id
    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") userId: Int): ResponseEntity<User> {
         // Try to find the user by ID; return null if not found
        val user = userRepository.findById(userId).orElse(null)
        // Return Http status 200 OK if found, otherwise 404 not found
        return if (user != null) {
            ResponseEntity(user, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}