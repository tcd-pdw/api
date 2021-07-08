package moodmanager.api.repository

import moodmanager.api.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
     fun existsByEmail(username: String): Boolean
     fun findByEmail(email:String): User
}