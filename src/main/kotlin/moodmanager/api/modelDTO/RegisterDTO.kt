package moodmanager.api.modelDTO

import kotlinx.serialization.Contextual
import moodmanager.api.model.User
import kotlinx.serialization.Serializable
import moodmanager.api.model.Interest
import moodmanager.api.model.Preference
import moodmanager.api.model.Register
import java.time.LocalDateTime
import javax.persistence.ManyToMany
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Serializable
data class RegisterDTO (
    var id: Long = 0,



    @NotBlank
    @Contextual
    var date: LocalDateTime,
    var description: String,

    ) :Any() {
    constructor(register: Register): this(
        id = register.id,
        date = register.date,
        description = register.description) {
    }


}