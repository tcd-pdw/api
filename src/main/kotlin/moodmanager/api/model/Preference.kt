package moodmanager.api.model

import moodmanager.api.modelDTO.PreferenceDTO
import moodmanager.api.modelDTO.RegisterDTO
import javax.persistence.*


@Entity
@Table( name = "preferences")
data class Preference(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val cherring_up: Boolean,
    val song_sugestion: Boolean,
    val self_improvment: Boolean
) {
    companion object {
        fun toDTO(obj: Preference): PreferenceDTO {
            return with(obj as Preference) {
                PreferenceDTO(obj)
            }
        }

        fun toMultipleDTO(arr: ArrayList<Preference>): ArrayList<PreferenceDTO> {
            val preferenceDTO = ArrayList<PreferenceDTO>()
            arr.forEach {
                preferenceDTO.add(this.toDTO(it))
            }
            return preferenceDTO
        }
    }
}