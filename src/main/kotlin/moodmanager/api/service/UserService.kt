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
        if(userRepository.existsByUsername(user.username)) {
            return false
        }else {
            var u:User = userRepository.save(user)
            return true
        }
    }
     fun fromDTO(userDTO: NewUserDTO): User {
         return User(userDTO.username,userDTO.email, userDTO.password)
     }

    fun authenticate(u:UserDTO):User{
        var user = userRepository.findByEmail(u.email)

        if(u.password == user.password)
            return user
        else
            return User("","")
    }

    fun saveauth(u:User):User{
        var user = userRepository.findByEmail(u.email)

        if(user!=null){
            if(u.password != user.password){
                return User("","")
            }else{
                return u
            }
        }else{
            return return User("","")
        }
    }

    fun save(u:User):User{
        println("Dentro do service")
        println(u)
        return userRepository.save(u)
    }
}