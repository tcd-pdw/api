package moodmanager.api.modelDTO

data class Message (val text: String, val type: String)

data class ResponseDTO (val data: ArrayList<Any>?, val message: Message)