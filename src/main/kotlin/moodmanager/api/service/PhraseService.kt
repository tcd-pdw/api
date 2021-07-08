package moodmanager.api.service

import moodmanager.api.model.Phrase
import moodmanager.api.model.Preference
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

    fun getTypesByPreference(preference: Preference): ArrayList<Type> {
        val types: ArrayList<Type> = ArrayList()
        if(!preference.song_sugestion) {
            types.add(Type.SONG_REC)
        }
        if(!preference.self_improvment) {
            types.add(Type.HABIT)
        }

        if(!preference.cherring_up) {
            types.add(Type.MOTIVATIONAL)
        }
        return types
    }

    fun findByScoreAndPreferences(s:Int, preferences: Preference):List<Phrase>{
        val typesValidator = getTypesByPreference(preferences)
        print(typesValidator.toString())
        if(typesValidator.size > 0) {
            return phraseRepository.findByScoreAndTypeNotIn(s, typesValidator)
        }
        return phraseRepository.findByScore(s)
    }

}