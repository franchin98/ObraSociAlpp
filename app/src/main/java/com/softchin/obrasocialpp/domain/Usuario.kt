package com.softchin.obrasocialpp.domain

data class Usuario(
    val nombre: String,
    val apellido: String,
    val email: String,
    val password: String,
    val telefono: String,
    val provincia: String,
    val ciudad: String,
    val obraSocial: ObraSocial,
    val grupoSanguineo: GrupoSanguineo
) {
    companion object {
        fun getMock(): Usuario {
            return Usuario(
                "Juan",
                "Pérez",
                "juanperez2002@gmail.com",
                "123456",
                "1122334455",
                "Buenos Aires",
                "Morón",
                ObraSocial.OSDE,
                GrupoSanguineo.AB_NEGATIVO
            )
        }
    }
}
