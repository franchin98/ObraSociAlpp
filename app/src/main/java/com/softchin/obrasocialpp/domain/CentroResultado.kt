package com.softchin.obrasocialpp.domain

data class CentroResultado(
    val nombre: String,
    val horarios: String,
    val ubicacion: String,
    val obrasSociales: List<ObraSocial>,
    val especialidades: List<Especialidad>
) {
    companion object {
        fun getMock(): CentroResultado {
            return CentroResultado(
                "CEMODO",
                "Lunes a Viernes, 8HS - 20HS",
                "República Oriental del Uruguay 353, Morón",
                listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS),
                listOf(Especialidad.OTORRINOLARINGOLOGIA)
            )
        }
    }
}