package moodmanager.api.service

import moodmanager.api.model.User
import moodmanager.api.modelDTO.Message
import moodmanager.api.modelDTO.ResponseDTO
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val passwordEncoder: PasswordEncoder) {

    fun getAllUsers():ArrayList<UserDTO> {
         val arrayUsers: ArrayList<UserDTO> = User.toMultipleDTO(this.userRepository.findAll() as ArrayList<User>)
         return arrayUsers
    }

    fun addUser(userDTO: UserDTO):  ResponseDTO {
        if(usernameExist(userDTO.username)){
            return ResponseDTO(null, Message("Usuário já existente.", "ENVALID-USERNAME"))
        } else {
            this.userRepository.save(this.fromDTO(userDTO))
            return ResponseDTO(null, Message("Usuário cadastrado com sucesso!","SUCCESS"))
        }
    }

    fun register(userDTO: UserDTO): ResponseDTO {
        userDTO.password = passwordEncoder.encode(userDTO.password)
        return addUser(userDTO)
    }

    fun usernameExist( username: String) : Boolean {
        return userRepository.existsByUsername(username)
    }

     fun fromDTO(userDTO: UserDTO): User {
         return User(0, userDTO.username, userDTO.password, userDTO.geralScore, userDTO.)
     }
}