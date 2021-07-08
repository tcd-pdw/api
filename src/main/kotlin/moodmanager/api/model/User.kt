package moodmanager.api.model

import moodmanager.api.modelDTO.UserDTO
import javax.persistence.*

@Entity
@Table( name = "users")
data class User (
    var username: String = "",
    val email: String = "",
    var password: String = "",
    val geralScore: Int = 0
)
{
    @Id @GeneratedValue var id: Long? = null

    @OneToOne(cascade = [(CascadeType.ALL)],fetch = FetchType.LAZY)
    var preference: Preference = Preference()

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    val registers: MutableList<Register> = arrayListOf<Register>()

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    val interests: MutableList<Interest> = arrayListOf<Interest>()

    override fun toString(): String {
        return "Id: ${id}, Username: ${username}, email: ${email}, password: ${password}, geralScore: ${geralScore}"
    }
}