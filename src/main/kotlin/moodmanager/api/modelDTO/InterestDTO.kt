package moodmanager.api.modelDTO

import kotlinx.serialization.Serializable
import moodmanager.api.model.Interest
import moodmanager.api.model.Preference
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Serializable
data class InterestDTO(
    val id: Long = 0,

    val name: String,
    val description: String,
    val score: Int
) :Any() {
    constructor(interest: Interest): this(
        id = interest.id,
        name = interest.name,
        description = interest.description,
        score = interest.score
    ) {
    }
}
