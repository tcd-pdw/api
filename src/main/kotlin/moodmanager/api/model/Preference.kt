package moodmanager.api.model

import javax.persistence.*


@Entity
@Table( name = "preferences")
data class Preference(
    var cherring_up: Boolean = false,
    var song_sugestion: Boolean = false,
    var self_improvment: Boolean = false
) {
    @Id @GeneratedValue var id: Long? = null
    fun setPreference(c:Boolean,s:Boolean,i:Boolean){
        cherring_up = c
        song_sugestion = s
        self_improvment = i
    }
}