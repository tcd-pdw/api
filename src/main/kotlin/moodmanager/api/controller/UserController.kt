package moodmanager.api.controller

import moodmanager.api.model.Interest
import moodmanager.api.model.Phrase
import moodmanager.api.model.Register
import moodmanager.api.model.User
import moodmanager.api.modelDTO.NewUserDTO
import moodmanager.api.modelDTO.ResponseDTO
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.service.InterestService
import moodmanager.api.service.PhraseService
import moodmanager.api.service.RegisterService
import moodmanager.api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val registerService: RegisterService,
    private val interestService: InterestService,
    private val phraseService: PhraseService
    ) {

//    @GetMapping
//    fun getAllUsers():ArrayList<UserDTO> {
//        return userService.getAllUsers()
//    }

    @PostMapping("/new")
    fun register(@RequestBody @Valid user: NewUserDTO): ResponseEntity<User> {

        var newuser = this.userService.fromDTO(user)
        if(this.userService.add(newuser))
            return ResponseEntity.ok(newuser)
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(newuser)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid user: UserDTO): Any{
        val u = userService.authenticate(user)
        val ps:List<Phrase> = phraseService.findByScore(u.geralScore)

        if(u!=null){
            return object {
                val newuser = u
                val phrases = ps
            }
        }else {
            return false
        }
    }

    @PostMapping("/save")
    fun save(@RequestBody @Valid user:User): ResponseEntity<User> {

        println(user)
        var u = userService.saveauth(user)
        println(u)

        if(u!=null){
            if(registerService.saveAll(user.registers)){
                u.registers.addAll(user.registers)
            }
            if(interestService.saveAll(user.interests)){
                u.interests.addAll(user.interests)
            }
            u.preference.setPreference(user.preference.cherring_up,user.preference.song_sugestion,user.preference.self_improvment)
        }
        println(u)
        var newuser = userService.save(u)
        println(newuser)
        return ResponseEntity.ok(newuser)
    }
}