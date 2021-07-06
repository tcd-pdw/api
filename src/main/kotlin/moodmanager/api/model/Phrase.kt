package moodmanager.api.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table( name = "Phrases")
data class Phrase(
    @NotBlank
    var content: String,
    var type:Type,
    var score:Int
){
    @Id
    @GeneratedValue
    var id: Long? = null
}