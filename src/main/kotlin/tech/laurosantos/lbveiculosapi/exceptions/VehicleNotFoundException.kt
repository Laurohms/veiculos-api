package tech.laurosantos.lbveiculosapi.exceptions

class VehicleNotFoundException(placa: String) : RuntimeException("Veículo com placa não encontrado: $placa")