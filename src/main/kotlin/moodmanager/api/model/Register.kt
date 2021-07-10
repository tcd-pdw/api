package moodmanager.api.model

import moodmanager.api.modelDTO.RegisterDTO
import moodmanager.api.modelDTO.UserDTO
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table( name = "registers")
data class Register(
    @NotBlank
    val date: LocalDateTime,
    @NotBlank
    val description: String,
    @NotBlank
    val score: Int
    ) {
    @Id @GeneratedValue var id: Long? = null
}