package tech.laurosantos.lbveiculosapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.laurosantos.lbveiculosapi.model.Veiculo

@Repository
interface VeiculoRepository : JpaRepository<Veiculo, String> {
    fun findAllByApartamento(apartamento: Int): MutableList<Veiculo>
}
