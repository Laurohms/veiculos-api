package tech.laurosantos.lbveiculosapi.service

import org.springframework.stereotype.Service
import tech.laurosantos.lbveiculosapi.model.Veiculo
import tech.laurosantos.lbveiculosapi.repository.VeiculoRepository

@Service
class VeiculoService(
    val veiculoRepository: VeiculoRepository
) {
    fun create(veiculo: Veiculo): Veiculo {
        return veiculoRepository.save(veiculo)
    }
}
