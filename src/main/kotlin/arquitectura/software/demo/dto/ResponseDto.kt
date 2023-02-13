package arquitectura.software.demo.dto

data class ResponseDto<T>(
    var data: Any?,
    var success: Boolean,
    var message: String
)