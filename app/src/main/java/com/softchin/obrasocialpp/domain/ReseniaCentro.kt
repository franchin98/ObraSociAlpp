package com.softchin.obrasocialpp.domain

data class ReseniaCentro(
    val id: Int,
    val idCentro: Int,
    val usuario: String,
    val resenia: String,
    val avatar: String = "https://i.pravatar.cc/150?img=${id}"
) {

    companion object {
        fun getMocks(): List<ReseniaCentro> {
            return listOf(
                ReseniaCentro(
                    id = 3,
                    idCentro = 1,
                    usuario = "Jorge Pérez",
                    resenia = "Muy buen lugar, me encantó"
                ),
                ReseniaCentro(
                    id = 2,
                    idCentro = 1,
                    usuario = "Pedro Pascal",
                    resenia = "No me gustó, no volvería"
                ),
                ReseniaCentro(
                    id = 1,
                    idCentro = 2,
                    usuario = "Ana de Armas",
                    resenia = "Muy bueno todo!"
                ),
                ReseniaCentro(
                    id = 5,
                    idCentro = 2,
                    usuario = "María Rosa Pérez",
                    resenia = "Los doctores fueron muy amables, recomiendo"
                ),
                ReseniaCentro(
                    id = 0,
                    idCentro = 3,
                    usuario = "Agustín López",
                    resenia = "El trato de los doctores podría ser mejor"
                ),
                ReseniaCentro(
                    id = 6,
                    idCentro = 6,
                    usuario = "Ricardo Fort",
                    resenia = "El trato y la atención son excelentes, pero la espera fue muy larga"
                ),
                ReseniaCentro(
                    id = 7,
                    idCentro = 6,
                    usuario = "Germán López",
                    resenia = "Muy buena atención, pero tardaron bastante por la cantidad excesiva de gente"
                )
            )
        }
    }
}