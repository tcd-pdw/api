package moodmanager.api.model

import javax.persistence.*


@Entity
@Table( name = "preferences")
data class Preference(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val cherring_up: Boolean,
    val song_sugestion: Boolean,
    val self_improvment: Boolean
)