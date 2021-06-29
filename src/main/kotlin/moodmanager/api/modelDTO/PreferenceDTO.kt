package moodmanager.api.modelDTO

import kotlinx.serialization.Serializable
import moodmanager.api.model.Preference

@Serializable
data class PreferenceDTO (
    var id: Long = 0,

    val cherring_up: Boolean,

    val song_sugestion: Boolean,

    val self_improvment: Boolean

    ) :Any() {
    constructor(preference: Preference): this(
        id = preference.id,
        cherring_up = preference.cherring_up,
        song_sugestion = preference.song_sugestion,
        self_improvment = preference.self_improvment
    ) {
    }
}