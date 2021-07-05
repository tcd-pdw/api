package moodmanager.api.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table( name = "interests")
data class Interest(
    @NotBlank
    var name: String,
    @NotBlank
    var description: String
){
    @Id @GeneratedValue var id: Long? = null

    var score: Integer? = null
}