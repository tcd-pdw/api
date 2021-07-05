package moodmanager.api.service

import moodmanager.api.model.Register
import moodmanager.api.repository.RegisterRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegisterService(private val registerRepository: RegisterRepository, private val passwordEncoder: PasswordEncoder) {
    fun saveAll(lista:MutableList<Register>):Boolean{
        return registerRepository.saveAll(lista)!=null
    }
}