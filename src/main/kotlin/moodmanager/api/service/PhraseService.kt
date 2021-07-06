package moodmanager.api.service

import moodmanager.api.model.Phrase
import moodmanager.api.model.Type
import moodmanager.api.modelDTO.PhraseDTO
import moodmanager.api.repository.PhraseRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class PhraseService(private val phraseRepository: PhraseRepository, private val passwordEncoder: PasswordEncoder) {
    fun fromDTO(dto: PhraseDTO): Phrase {
        return Phrase(dto.content, Type.valueOf(dto.type),dto.score)
    }

    fun add(p:Phrase):Phrase{
        return phraseRepository.save(p)
    }

    fun showAll():List<Phrase>{
        return phraseRepository.findAll()
    }

    fun findByScore(s:Int):List<Phrase>{
        return phraseRepository.findByScore(s)
    }
}