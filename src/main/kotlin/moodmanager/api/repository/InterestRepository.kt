package moodmanager.api.repository

import moodmanager.api.model.Interest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InterestRepository: JpaRepository<Interest, Long> {

}