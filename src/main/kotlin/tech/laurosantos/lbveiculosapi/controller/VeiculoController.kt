package tech.laurosantos.lbveiculosapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.laurosantos.lbveiculosapi.model.Veiculo
import tech.laurosantos.lbveiculosapi.service.VeiculoService

@RestController
@RequestMapping("/veiculos")
class VeiculoController(
    val veiculoService: VeiculoService
) {

    @PostMapping
    fun createVeiculo(@RequestBody veiculo: Veiculo): ResponseEntity<Veiculo> {
        val newVeiculo = veiculoService.create(veiculo)
        return ResponseEntity.status(HttpStatus.CREATED).body(newVeiculo)
    }

    @GetMapping("/{placa}")
    fun buscarPorPlaca(@PathVariable placa: String): ResponseEntity<Veiculo> {
        val veiculo = veiculoService.getByPlaca(placa)
        return ResponseEntity.ok(veiculo)
    }
}