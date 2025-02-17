package tech.laurosantos.lbveiculosapi.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Veiculo(
    @Id val placa: String,
    val marca: String?,
    val modelo: String?,
    val cor: String?,
    val apartamento: Int,
    var vagaAlugada: Int?
)
