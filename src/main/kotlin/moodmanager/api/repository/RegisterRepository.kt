package moodmanager.api.repository

import moodmanager.api.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository: JpaRepository<Register, Long> {

}