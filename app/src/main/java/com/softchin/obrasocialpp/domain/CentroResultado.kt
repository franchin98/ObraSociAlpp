package com.softchin.obrasocialpp.domain

data class CentroResultado(
    val id: Int,
    val nombre: String,
    val horarios: String,
    val ubicacion: String,
    val obrasSociales: List<ObraSocial>,
    val especialidades: List<Especialidad>,
    val foto: String,
    val coincideObraSocial: Boolean = false,
    val esFavorito: Boolean = false,
    val descripcion: String = ""
) {
    companion object {
        fun getMock(): CentroResultado {
            return CentroResultado(
                1,
                "CEMODO",
                "Lunes a Viernes, 8HS - 20HS",
                "República Oriental del Uruguay 353, Morón",
                listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS),
                listOf(Especialidad.OTORRINOLARINGOLOGIA),
                "https://lh3.googleusercontent.com/p/AF1QipN_7wtiWzLHzA0rYMXIQDu9ia_aRfSxrXjuCj8d=s680-w680-h510",
                false,
                true,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
            )
        }

        fun getMocks(): List<CentroResultado> {
            return listOf(
                CentroResultado(
                    1,
                    "CEMODO",
                    "Lunes a Viernes, 8HS - 20HS",
                    "República Oriental del Uruguay 353, Morón",
                    listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS),
                    listOf(Especialidad.OTORRINOLARINGOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipN_7wtiWzLHzA0rYMXIQDu9ia_aRfSxrXjuCj8d=s680-w680-h510",
                    false,
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                ),
                CentroResultado(
                    2,
                    "CEPEM Consultorios Médicos",
                    "Lunes a Sábados, 8HS - 20HS",
                    "Gral. Machado 729, Morón",
                    listOf(ObraSocial.OSDE, ObraSocial.SWISS),
                    listOf(Especialidad.CARDIOLOGIA, Especialidad.TRAUMATOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipP3zgUEuy1aB3etSdKJvFrvTx58WgF7jS2VM9L6=s680-w680-h510",
                    true,
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                ),
                CentroResultado(
                    3,
                    "Clínica Modelo de Morón",
                    "Abierta las 24HS",
                    "República Oriental del Uruguay 234, Morón",
                    listOf(ObraSocial.OSDE, ObraSocial.OSECAC, ObraSocial.SWISS, ObraSocial.GALENO),
                    listOf(Especialidad.CARDIOLOGIA, Especialidad.TRAUMATOLOGIA, Especialidad.PODOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipOeDZZuILThx0rIYNPdXjbQHcQbdHGC_kB-o7sC=s680-w680-h510",
                    false,
                    false,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                ),
                CentroResultado(
                    4,
                    "Ospedyc Zona Oeste",
                    "Lunes a Viernes, 8HS - 19HS",
                    "Maestra Cueto 723, Morón",
                    listOf(ObraSocial.LUIS_PASTEUR, ObraSocial.SANCOR),
                    listOf(Especialidad.PSICOLOGIA, Especialidad.CARDIOLOGIA, Especialidad.PSIQUIATRIA),
                    "https://scontent.fepa8-1.fna.fbcdn.net/v/t39.30808-6/458782935_2554401421426637_4385683363808710426_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=cf85f3&_nc_ohc=05JeWsSEO88Q7kNvgHlHwF4&_nc_zt=23&_nc_ht=scontent.fepa8-1.fna&_nc_gid=Ab5_xdf6UtIsBmr2HeKAjRH&oh=00_AYAxgvah9HOtjI0OK_98jcJBRCZJPG_Y18Crsxxe7mRoIQ&oe=674303D9",
                    false,
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                ),
                CentroResultado(
                    5,
                    "Hospital de Morón",
                    "Abierto las 24HS",
                    "Dr. Rodolfo Monte 848, Morón",
                    listOf(ObraSocial.GRATUITO),
                    listOf(Especialidad.CARDIOLOGIA, Especialidad.TRAUMATOLOGIA, Especialidad.OTORRINOLARINGOLOGIA),
                    "https://lh3.googleusercontent.com/p/AF1QipPfj7XRz97ziuF-wKd-4wWoe9cNI6JjFhRCq4Md=s680-w680-h510",
                    true,
                    false,
                    "Nuestro Hospital Municipal, ubicado en la calle Dr. Rodolfo Monte 848, es una institución\n" +
                            "fundamental de la Red de Salud de Morón. Cuenta con un plantel profesional altamente\n" +
                            "calificado que brinda atención a las personas derivadas desde los Centros de Atención\n" +
                            "Primaria (CAPS) por problemas de mediana y alta complejidad así como a quienes se\n" +
                            "acercan de manera espontánea a sus Consultorios Externos que funcionan en la sede de\n" +
                            "Carlos Pellegrini 620.\n" +
                            "\n" +
                            "Atiende múltiples especialidades y cuenta con un sistema de emergencia (Guardia)\n" +
                            "pediátrica, de adultos, de tocoginecología y de neonatología.\n" +
                            "Su edificio posee habitaciones de internación de adultos y pediátricas equipadas con las\n" +
                            "comodidades necesarias para pacientes y acompañantes. Los servicios de mayor\n" +
                            "complejidad y menor acceso de público se ubican en los niveles más altos del edificio."
                ),
                CentroResultado(
                    6,
                    "IOSFA Morón",
                    "Lunes a Viernes, 8HS - 20HS",
                    "Río Piedras 346, Morón",
                    listOf(ObraSocial.IOSFA),
                    listOf(Especialidad.GINECOLOGIA, Especialidad.PEDIATRIA, Especialidad.MEDICINA_FAMILIAR),
                    "https://upload.wikimedia.org/wikipedia/commons/1/1c/Letrero_del_Hospital_de_Medina_del_Campo.JPG",
                    false,
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                ),
                CentroResultado(
                    7,
                    "Hospital Nacional Posadas",
                    "Abierto las 24HS",
                    "Presidente Illia s/n y Marconi, El Palomar",
                    listOf(ObraSocial.GRATUITO),
                    listOf(Especialidad.CIRUGIA_CARDIOVASCULAR, Especialidad.NEUROCIRUGIA),
                    "https://www.clarin.com/img/2022/07/11/k4Y6bn-AG_2000x1500__1.jpg",
                    true,
                    false,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                ),
                CentroResultado(
                    8,
                    "Hospital Italiano",
                    "Lunes a Viernes, 8HS - 20HS",
                    "Av. Rivadavia 17955, Morón",
                    listOf(ObraSocial.HOSPITAL_ITALIANO),
                    listOf(Especialidad.CLINICA_MEDICA, Especialidad.PEDIATRIA, Especialidad.GINECOLOGIA),
                    "https://www.hospitalitaliano.org.ar/images/centros/moron.jpg",
                    false,
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris at lacinia ante. Aenean quis turpis faucibus, facilisis ante sed, aliquam nisl. Sed quis ultricies arcu. Curabitur in scelerisque enim, sit amet venenatis justo. Maecenas quis massa rhoncus, eleifend purus vel, vulputate ligula. Phasellus vel venenatis nisl. Aliquam et lorem ut massa lobortis tempor. Donec at pretium magna. In in pharetra ante. Integer volutpat urna aliquet, aliquet sapien ac, dapibus lectus. Nunc tincidunt velit enim, tristique laoreet eros fringilla vel. "
                )
            )
        }
    }
}