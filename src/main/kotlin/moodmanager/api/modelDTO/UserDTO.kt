package moodmanager.api.modelDTO

import kotlinx.serialization.Serializable
import javax.validation.constraints.NotBlank

@Serializable
data class UserDTO(
    var id: Long = 0,

    @NotBlank
    var username: String = "",

    @NotBlank
    var password: String = "",

    @NotBlank
    var geralScore: Int = 0

)
