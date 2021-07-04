package moodmanager.api.modelDTO

import kotlinx.serialization.Serializable
import javax.validation.constraints.NotBlank

@Serializable
data class NewUserDTO(

    @NotBlank
    var username: String = "",

    @NotBlank
    var email: String = "",

    @NotBlank
    var password: String = ""

) {

}