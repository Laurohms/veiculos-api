package tech.laurosantos.lbveiculosapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException::class)
    fun handleVehicleNotFoundException(e: VehicleNotFoundException): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage(HttpStatus.NOT_FOUND.value(), e.message!!)
        return ResponseEntity.status(message.code).body(message)
    }

    @ExceptionHandler(VeiculoIllegalArgumentException::class)
    fun handleVeiculoIllegalArgumentException(e: VeiculoIllegalArgumentException): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage(HttpStatus.BAD_REQUEST.value(), e.message!!)
        return ResponseEntity.status(message.code).body(message)
    }
}

class ResponseMessage(
    val code: Int,
    val message: String
)