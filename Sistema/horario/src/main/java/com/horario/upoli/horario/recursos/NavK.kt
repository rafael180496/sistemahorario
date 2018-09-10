@file:JvmName("recursos")
package com.horario.upoli.horario.recursos

data class NavK(private var titulo:String="",private var navegacion:String=""){
    fun Generar_ul():String{
        return """
            <li>
                <a href="$navegacion">$titulo</a>
            </li>
        """
    }
}