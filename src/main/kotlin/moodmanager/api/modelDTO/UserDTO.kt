package moodmanager.api.modelDTO

import moodmanager.api.model.User
import kotlinx.serialization.Serializable
import javax.validation.constraints.NotBlank

@Serializable
data class UserDTO (
    val id: Long = 0,

    @get: NotBlank
    var username: String = "",
) :Any() {
    constructor(user: User): this() {
        username = user.username
    }
}