package moodmanager.api.model

import moodmanager.api.modelDTO.RegisterDTO
import moodmanager.api.modelDTO.UserDTO
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table( name = "registries")
data class Register(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val date: LocalDateTime,
    val description: String
    ) {
//    companion object {
//        fun toDTO( obj: Register): RegisterDTO {
//            return with(obj as Register) {
//                RegisterDTO(obj)
//            }
//        }
//
//        fun toMultipleDTO(arr: ArrayList<Register>): ArrayList<RegisterDTO> {
//            val registerDTO = ArrayList<RegisterDTO>()
//            arr.forEach {
//                registerDTO.add(this.toDTO(it))
//            }
//            return registerDTO
//        }
//    }
}