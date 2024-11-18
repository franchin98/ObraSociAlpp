package com.softchin.obrasocialpp.domain

data class CentroResultado(
    val nombre: String,
    val horarios: String,
    val ubicacion: String,
    val obrasSociales: List<ObraSocial>,
    val especialidades: List<Especialidad>,
    val foto: String,
    val coincideObraSocial: Boolean = false,
    val esFavorito: Boolean = false
) {
    companion object {
        fun getMock(): CentroResultado {
            return CentroResultado(
                "CEMODO",
                "Lunes a Viernes, 8HS - 20HS",
                "República Oriental del Uruguay 353, Morón",
                listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS),
                listOf(Especialidad.OTORRINOLARINGOLOGIA),
                "https://lh3.googleusercontent.com/p/AF1QipN_7wtiWzLHzA0rYMXIQDu9ia_aRfSxrXjuCj8d=s680-w680-h510",
                false,
                true
            )
        }

        fun getMocks(): List<CentroResultado> {
            return listOf(
                CentroResultado(
                    "CEMODO",
                    "Lunes a Viernes, 8HS - 20HS",
                    "República Oriental del Uruguay 353, Morón",
                    listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS),
                    listOf(Especialidad.OTORRINOLARINGOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipN_7wtiWzLHzA0rYMXIQDu9ia_aRfSxrXjuCj8d=s680-w680-h510",
                    false,
                    true
                ),
                CentroResultado(
                    "CEPEM Consultorios Médicos",
                    "Lunes a Sábados, 8HS - 20HS",
                    "Gral. Machado 729, Morón",
                    listOf(ObraSocial.OSDE, ObraSocial.SWISS),
                    listOf(Especialidad.CARDIOLOGIA, Especialidad.TRAUMATOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipP3zgUEuy1aB3etSdKJvFrvTx58WgF7jS2VM9L6=s680-w680-h510",
                    true,
                    true
                ),
                CentroResultado(
                    "Clínica Modelo de Morón",
                    "Abierta las 24HS",
                    "República Oriental del Uruguay 234, Morón",
                    listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS, ObraSocial.GALENO),
                    listOf(Especialidad.CARDIOLOGIA, Especialidad.TRAUMATOLOGIA, Especialidad.PODOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipOeDZZuILThx0rIYNPdXjbQHcQbdHGC_kB-o7sC=s680-w680-h510",
                    false,
                    false
                ),
                CentroResultado(
                    "Ospedyc - Centro Medico Zona Oeste",
                    "Lunes a Viernes, 8HS - 19HS",
                    "Maestra Cueto 723, Morón",
                    listOf(ObraSocial.LUIS_PASTEUR, ObraSocial.SANCOR),
                    listOf(Especialidad.PSICOLOGIA, Especialidad.CARDIOLOGIA, Especialidad.PSIQUIATRIA),
                    "https://lh3.googleusercontent.com/p/AF1QipOU2U2Y3zjBXGZF-t_eBxLCzs3dtZ4Cgq1JmJ9h=s680-w680-h510",
                    false,
                    true
                ),
                CentroResultado(
                    "Hospital de Morón",
                    "Abierto las 24HS",
                    "Dr. Rodolfo Monte 848, Morón",
                    listOf(ObraSocial.GRATUITO),
                    listOf(Especialidad.CARDIOLOGIA, Especialidad.TRAUMATOLOGIA, Especialidad.OTORRINOLARINGOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipPfj7XRz97ziuF-wKd-4wWoe9cNI6JjFhRCq4Md=s680-w680-h510",
                    true,
                    false
                )
            )
        }
    }
}