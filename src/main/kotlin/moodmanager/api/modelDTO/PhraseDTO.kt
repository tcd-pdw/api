package moodmanager.api.modelDTO

import javax.validation.constraints.NotBlank

class PhraseDTO(
    @NotBlank
    var content:String,
    @NotBlank
    var type:String,
    var score:Int
) {
}