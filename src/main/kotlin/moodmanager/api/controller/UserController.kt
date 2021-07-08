package moodmanager.api.controller

import moodmanager.api.model.Phrase
import moodmanager.api.model.User
import moodmanager.api.modelDTO.NewUserDTO
import moodmanager.api.modelDTO.UserDTO
import moodmanager.api.service.InterestService
import moodmanager.api.service.PhraseService
import moodmanager.api.service.RegisterService
import moodmanager.api.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
    private val registerService: RegisterService,
    private val interestService: InterestService,
    private val phraseService: PhraseService
    ) {

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
        val ps:List<Phrase> = phraseService.findByScoreAndPreferences(u.geralScore, u.preference)

        if(u!=null){
            return object {
                val user = u
                val phrases = ps
            }
        }else {
            return false
        }
    }

    @PostMapping("/save")
    fun save(@RequestBody @Valid user:User): ResponseEntity<User> {

        println(user)
        var userBd = userService.saveauth(user)
        println(userBd)

        if(userBd!=null){
            userBd.registers.addAll(registerService.returnDifference(user,userBd))
            userBd.interests.addAll(interestService.returnDifference(user, userBd))
            userBd.preference.setPreference(user.preference.cherring_up,user.preference.song_sugestion,user.preference.self_improvment)
        }
        println(userBd)
        var newuser = userService.save(userBd)
        println(newuser)
        return ResponseEntity.ok(newuser)
    }
}