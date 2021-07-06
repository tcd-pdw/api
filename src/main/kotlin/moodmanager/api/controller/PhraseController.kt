package moodmanager.api.controller

import moodmanager.api.model.Phrase
import moodmanager.api.model.Type
import moodmanager.api.modelDTO.PhraseDTO
import moodmanager.api.service.PhraseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/phrases")
class PhraseController(
    private val pr:PhraseService
) {

    @GetMapping
    fun showPhrases():ResponseEntity<List<Phrase>>{
        return ResponseEntity.ok(pr.showAll())
    }

    @PostMapping("/new")
    fun addPhrase(@RequestBody @Valid dto:PhraseDTO):Phrase{
        return pr.add(pr.fromDTO(dto))
    }

}