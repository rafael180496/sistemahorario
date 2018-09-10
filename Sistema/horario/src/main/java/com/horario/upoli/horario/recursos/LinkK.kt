@file:JvmName("recursos")
package com.horario.upoli.horario.recursos

data class LinkK(private var titulo:String="",private var navegacion:String=""){
    fun Generar_a():String{
        return """
            <a href="$navegacion">$titulo</a>
        """
    }
}