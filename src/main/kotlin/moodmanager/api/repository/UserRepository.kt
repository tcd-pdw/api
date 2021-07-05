package moodmanager.api.repository

import moodmanager.api.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, Long> {
     fun existsByUsername(username: String): Boolean
     fun findByEmail(email:String): User
}