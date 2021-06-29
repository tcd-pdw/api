package moodmanager.api.controller

import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users/preference")
class PreferenceController(private val userService: UserService){
//    @GetMapping
//    fun getAllUsers():ArrayList<UserDTO> {
////        return userService.getAllUsers()
//    }

}