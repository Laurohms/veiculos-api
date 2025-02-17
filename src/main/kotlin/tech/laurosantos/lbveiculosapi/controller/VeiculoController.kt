package tech.laurosantos.lbveiculosapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.laurosantos.lbveiculosapi.model.Veiculo

@RestController
@RequestMapping("/veiculos")
class VeiculoController {

    @PostMapping
    fun createVeiculo(@RequestBody veiculo: Veiculo): ResponseEntity<Veiculo> {

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }
}