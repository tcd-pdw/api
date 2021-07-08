package moodmanager.api.service

import moodmanager.api.model.Register
import moodmanager.api.model.User
import moodmanager.api.repository.RegisterRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegisterService(private val registerRepository: RegisterRepository, private val passwordEncoder: PasswordEncoder) {
    fun saveAll(lista:MutableList<Register>):Boolean{
        return registerRepository.saveAll(lista)!=null
    }
    fun returnDifference(userBd: User, userRequest: User): ArrayList<Register> {
        var registerResult: ArrayList<Register> = ArrayList()
        userRequest.registers.forEach { r ->
            var exist: Boolean = false
            userBd.registers.forEach { b ->
                if(r.description.equals(b.description) && r.date.equals(b.date)){
                    exist = true
                }
            }
            if(!exist) registerResult.add(r)
        }
        return registerResult
    }


}