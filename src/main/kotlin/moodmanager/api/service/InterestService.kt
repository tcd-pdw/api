package moodmanager.api.service

import moodmanager.api.model.Interest
import moodmanager.api.model.User
import moodmanager.api.repository.InterestRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class InterestService(private val interestRepository: InterestRepository, private val passwordEncoder: PasswordEncoder) {
    fun saveAll(lista:MutableList<Interest>):Boolean{
        return interestRepository.saveAll(lista)!=null
    }

    fun returnDifference(userBd: User, userRequest: User): ArrayList<Interest> {
        var interestsResult: ArrayList<Interest> = ArrayList()
        userRequest.interests.forEach { r ->
            var exist: Boolean = false
            userBd.interests.forEach { b ->
                if(r.description.equals(b.description) && r.name.equals(b.name)){
                    exist = true
                }
            }
            if(!exist) interestsResult.add(r)
        }
        return interestsResult
    }
}