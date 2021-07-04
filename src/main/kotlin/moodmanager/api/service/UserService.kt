package moodmanager.api.service

import moodmanager.api.model.User
import moodmanager.api.modelDTO.Message
import moodmanager.api.modelDTO.NewUserDTO
import moodmanager.api.modelDTO.ResponseDTO
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {

    fun usernameExist( username: String) : Boolean {
        return userRepository.existsByUsername(username)
    }

    fun add(user:User):Boolean{
        return !userRepository.existsByUsername(user.username)
    }
     fun fromDTO(userDTO: NewUserDTO): User {
         return User(userDTO.username,userDTO.email, userDTO.password)
     }

}