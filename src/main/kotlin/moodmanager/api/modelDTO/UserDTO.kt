package moodmanager.api.modelDTO

import kotlinx.serialization.Serializable
import javax.validation.constraints.NotBlank

@Serializable
class UserDTO(
    @NotBlank
    var email: String = "",

    @NotBlank
    var password: String = ""

) {

}
