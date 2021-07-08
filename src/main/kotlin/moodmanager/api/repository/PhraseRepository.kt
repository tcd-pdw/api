package moodmanager.api.repository

import moodmanager.api.model.Phrase
import moodmanager.api.model.Type
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PhraseRepository: JpaRepository<Phrase, Long> {

    fun findByScore(scoreUser: Int):List<Phrase>
    fun findByScoreAndTypeNotIn(scoreUser: Int, phrases: List<Type>): List<Phrase>
}