package moodmanager.api.service

import moodmanager.api.model.Interest
import moodmanager.api.repository.InterestRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class InterestService(private val interestRepository: InterestRepository, private val passwordEncoder: PasswordEncoder) {
    fun saveAll(lista:MutableList<Interest>):Boolean{
        return interestRepository.saveAll(lista)!=null
    }
}