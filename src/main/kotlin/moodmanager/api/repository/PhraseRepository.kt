package moodmanager.api.repository

import moodmanager.api.model.Phrase
import moodmanager.api.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhraseRepository: JpaRepository<Phrase, Long> {
    fun findByScore(s:Int):List<Phrase>
}