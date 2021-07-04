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

    @OneToOne()
    val preference: Preference = Preference()

    @ManyToMany(fetch = FetchType.LAZY)
    val registers: MutableList<Register> = arrayListOf<Register>()

    @ManyToMany( fetch = FetchType.LAZY )
    val interests: MutableList<Interest> = arrayListOf<Interest>()
}