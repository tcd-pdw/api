package moodmanager.api.model

import moodmanager.api.modelDTO.UserDTO
import javax.persistence.*

@Entity
@Table( name = "users")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val username: String = "",
    val password: String = "",

    val geralScore: Int = 0,


    @OneToOne(mappedBy = "users")
    val preference: Preference,

    @ManyToMany(mappedBy = "users")
    val registers: ArrayList<Register>,

    @ManyToMany(mappedBy = "users")
    val interests: ArrayList<Interest>


)
{
    companion object {
        fun toDTO( obj: User): UserDTO {
            return with(obj as User) {
                UserDTO(obj)
            }
        }

        fun toMultipleDTO(arr: ArrayList<User>): ArrayList<UserDTO> {
            val userDTOS = ArrayList<UserDTO>()
            arr.forEach {
                userDTOS.add(this.toDTO(it))
            }
            return userDTOS
        }
    }
}