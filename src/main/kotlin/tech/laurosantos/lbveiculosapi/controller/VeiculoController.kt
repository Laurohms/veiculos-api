package tech.laurosantos.lbveiculosapi.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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

    @GetMapping
    fun listarVeiculos(): ResponseEntity<List<Veiculo>> {
        val veiculos = veiculoService.getAll()
        return ResponseEntity.ok(veiculos)
    }

    @GetMapping("/apartamento/{apartamento}")
    fun buscarPorApartamento(@PathVariable apartamento: Int): ResponseEntity<List<Veiculo>> {
        val veiculos = veiculoService.getByApartamento(apartamento)
        return ResponseEntity.ok(veiculos)
    }

    @PutMapping("/{placa}")
    fun atualizarVeiculo(@PathVariable placa: String, @RequestBody veiculo: Veiculo): ResponseEntity<Veiculo> {
        val updatedVeiculo = veiculoService.update(placa, veiculo)
        return ResponseEntity.ok(updatedVeiculo)
    }

    @DeleteMapping("/{placa}")
    fun deletarVeiculo(@PathVariable placa: String): ResponseEntity<Unit> {
        veiculoService.delete(placa)
        return ResponseEntity.noContent().build()
    }
}