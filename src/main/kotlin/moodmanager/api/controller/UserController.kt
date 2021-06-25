package moodmanager.api.controller

import moodmanager.api.modelDTO.ResponseDTO
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers():ArrayList<UserDTO> {
        return userService.getAllUsers()
    }
//
//    @GetMapping("/{username}")
//    fun addUser(@PathVariable("id") username: String): String{
//        val dataList = mapOf(Pair("Deu certo", 404))
//        userService.addUser(UserDTO(0,username))
//        return dataList.toString()
//    }

    @PostMapping("")
    fun register(@RequestBody @Valid user: UserDTO): ResponseDTO {
        return this.userService.register(user)
    }
}