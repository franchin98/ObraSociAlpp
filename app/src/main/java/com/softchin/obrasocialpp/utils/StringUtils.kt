package com.softchin.obrasocialpp.utils

import com.softchin.obrasocialpp.domain.Especialidad
import com.softchin.obrasocialpp.domain.ObraSocial

object StringUtils {

    fun getObrasSociales(lista: List<ObraSocial>): String {
        var texto: String = ""

        lista.forEach {
            texto += "${it.nombre}, "
        }

        return if (texto.isNotEmpty()) texto.dropLast(2) else texto
    }

    fun getEspecialidades(lista: List<Especialidad>): String {
        var texto: String = ""

        lista.forEach {
            texto += "${it.nombre}, "
        }

        return if (texto.isNotEmpty()) texto.dropLast(2) else texto
    }
}