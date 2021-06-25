package moodmanager.api.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table( name = "registries")
data class Register(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val date: LocalDateTime,
    val description: String
)