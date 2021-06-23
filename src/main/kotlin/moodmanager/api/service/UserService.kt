package moodmanager.api.service

import moodmanager.api.model.User
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUsers():ArrayList<UserDTO> {
        return toMultipleDTO(this.userRepository.findAll() as ArrayList<User>)
    }

    fun addUser(userDTO: UserDTO) {
        userRepository.save(fromDTO(userDTO))
    }


     fun fromDTO(userDTO: UserDTO): User {
         return User(0, userDTO.username)
     }

     fun toDTO( obj: User): UserDTO {
         return with(obj as User) {
             UserDTO(obj)
         }
    }

     fun toMultipleDTO(arr: ArrayList<User>): ArrayList<UserDTO> {
        val userDTOS = ArrayList<UserDTO>()
        arr.forEach {
            userDTOS.add(this.toDTO(it))
        }
        return userDTOS
    }
}