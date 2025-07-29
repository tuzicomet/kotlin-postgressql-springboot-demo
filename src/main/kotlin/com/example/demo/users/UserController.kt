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

    // Update an existing user
    @PutMapping("/{id}")
    fun updateUserById(@PathVariable("id") userId: Int, @RequestBody user: User): ResponseEntity<User> {
        // Try to find the existing user by ID
        val existingUser = userRepository.findById(userId).orElse(null)

        // Return error 404 if user not found
        if (existingUser == null) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        // Create a copy of the existing user with updated fields
        val updatedUser = existingUser.copy(name = user.name, email = user.email)

        // Save the updated user back to the database
        userRepository.save(updatedUser)

        // Return the updated user with HTTP 200 OK
        return ResponseEntity(updatedUser, HttpStatus.OK)
    }
}