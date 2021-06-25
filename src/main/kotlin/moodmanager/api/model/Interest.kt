package moodmanager.api.model

import javax.persistence.*

@Entity
@Table( name = "interests")
data class Interest(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val description: String,
    val score: Int
)