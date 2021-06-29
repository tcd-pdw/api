package moodmanager.api.controller

import moodmanager.api.model.Interest
import moodmanager.api.model.Register
import moodmanager.api.model.User
import moodmanager.api.modelDTO.ResponseDTO
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.service.UserService
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid


@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

//    @GetMapping
//    fun getAllUsers():ArrayList<UserDTO> {
//        return userService.getAllUsers()
//    }

    @GetMapping
    fun getUser():User {
        return User(10.toLong(), "felipejhordan123","felp",2)
    }

    @PostMapping("/new")
    fun register(@RequestBody @Valid user: UserDTO): User {
        var newuser = this.userService.fromDTO(user)
        this.userService.addUser(user)
        newuser.registers.add(Register(1, LocalDateTime.now(),"Este é o primeiro registro"))
        newuser.interests.add(Interest(1, "RAÇÃO DE CACHORRO", "RAÇÃO DE CACHORRO", 5))
        return newuser
    }


}