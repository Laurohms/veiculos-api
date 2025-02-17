package tech.laurosantos.lbveiculosapi.service

import org.springframework.stereotype.Service
import tech.laurosantos.lbveiculosapi.exceptions.VehicleNotFoundException
import tech.laurosantos.lbveiculosapi.exceptions.VeiculoIllegalArgumentException
import tech.laurosantos.lbveiculosapi.model.Veiculo
import tech.laurosantos.lbveiculosapi.repository.VeiculoRepository

@Service
class VeiculoService(
    val veiculoRepository: VeiculoRepository
) {
    fun create(veiculo: Veiculo): Veiculo {
        val newVeiculo = veiculo.copy(
            placa = veiculo.placa.uppercase(),
            marca = veiculo.marca?.lowercase(),
            modelo = veiculo.modelo?.lowercase(),
            cor = veiculo.cor?.lowercase(),
        )
        return veiculoRepository.save(newVeiculo)
    }

    fun getByPlaca(placa: String): Veiculo {
        if (placa.isBlank() || placa.length != 7) {
            throw VeiculoIllegalArgumentException()
        }
        return veiculoRepository.findById(placa.uppercase())
            .orElseThrow { throw VehicleNotFoundException(placa) }
    }

    fun getAll(): List<Veiculo>? {
        val vehicles: List<Veiculo> = veiculoRepository.findAll()
        if (vehicles.isEmpty()) {
            throw VehicleNotFoundException("Nenhum veículo encontrado")
        }
        return vehicles.toList()
    }

    fun getByApartamento(apartamento: Int): List<Veiculo> {
        val veiculos = veiculoRepository.findAllByApartamento(apartamento).toList()
        if (veiculos.isEmpty()) throw VehicleNotFoundException("Nenhum veículo encontrado")
        return veiculos
    }

    fun update(placa: String, veiculo: Veiculo): Veiculo {
        val veiculoToBeUpdated = getByPlaca(placa)
        val updatedVeiculo = veiculoToBeUpdated.copy(
            marca = veiculo.marca,
            modelo = veiculo.modelo,
            cor = veiculo.cor,
            apartamento = veiculo.apartamento,
            vagaAlugada = veiculo.vagaAlugada
        )
        return veiculoRepository.save(updatedVeiculo)
    }

    fun delete(placa: String) {
        val veiculo = getByPlaca(placa)
        veiculoRepository.delete(veiculo)
    }
}
