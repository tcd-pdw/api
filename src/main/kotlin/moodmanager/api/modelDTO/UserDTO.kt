package moodmanager.api.modelDTO

import moodmanager.api.model.User
import kotlinx.serialization.Serializable
import moodmanager.api.model.Interest
import moodmanager.api.model.Preference
import moodmanager.api.model.Register
import javax.persistence.ManyToMany
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Serializable
data class UserDTO(
    var id: Long = 0,

    @NotBlank
    var username: String = "",

    @NotBlank
    var password: String = "",

    @NotBlank
    var geralScore: Int = 0,

    var preference: PreferenceDTO? = null,

    var registers: ArrayList<RegisterDTO>?,

    var interests: ArrayList<InterestDTO>?

) :Any() {
    constructor(user: User): this() {
        id = user.id
        username = user.username
        password = user.password
        geralScore = user.geralScore
        preference = Preference.toDTO(user.preference)
        registers = null
        interests = null
    }


}