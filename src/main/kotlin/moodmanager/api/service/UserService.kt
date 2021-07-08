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

        fun add(user:User):Boolean{
        if(userRepository.existsByEmail(user.email)) {
            return false
        }else {
            user.password = passwordEncoder.encode(user.password)
            var u:User = userRepository.save(user)
            return true
        }
    }
     fun fromDTO(userDTO: NewUserDTO): User {
         return User(userDTO.username,userDTO.email, userDTO.password)
     }

    fun authenticate(u:UserDTO):User{
        var user = userRepository.findByEmail(u.email)

        if(passwordEncoder.matches(u.password, user.password))
            return user
        else
            return User("","")
    }

    fun saveauth(u:User):User{
        var user = userRepository.findByEmail(u.email)

        if(user!=null){
            if(!passwordEncoder.matches(u.password, user.password)){
                return User("","")
            }else{
                u.id = user.id
                u.username = user.username
                u.preference.id = user.preference.id
                return u
            }
        }else{
            return return User("","")
        }
    }

    fun save(u:User):User{
        u.password = passwordEncoder.encode(u.password)
        return userRepository.save(u)
    }
}