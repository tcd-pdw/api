package moodmanager.api.model

import moodmanager.api.modelDTO.UserDTO
import javax.persistence.*

@Entity
@Table( name = "users")
data class User (

    val username: String = "",
    val email: String = "",
    val password: String = "",
    val geralScore: Int = 0

)
{
    @Id @GeneratedValue var id: Long? = null

    @OneToOne(cascade = [(CascadeType.ALL)],fetch = FetchType.LAZY)
    val preference: Preference = Preference()

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val registers: MutableList<Register> = arrayListOf<Register>()

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    val interests: MutableList<Interest> = arrayListOf<Interest>()

    override fun toString(): String {
        return "Id: ${id}, Username: ${username}, email: ${email}, password: ${password}, geralScore: ${geralScore}"
    }
}