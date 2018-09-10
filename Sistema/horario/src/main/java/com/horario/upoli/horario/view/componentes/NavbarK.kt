@file:JvmName("componentes")
package com.horario.upoli.horario.view.componentes

import com.horario.upoli.horario.recursos.NavK

data class NavbarK(
      var proyecto:String="",
      private var ul:ArrayList<NavK> = arrayListOf()
){


    fun Agregar_propiedad(titulo:String,navegacion:String)=ul.add(NavK(titulo,navegacion))

    fun Generar_lista():String{
        var Resultado:String=""
        for( n in ul ) Resultado+=n.Generar_ul()

        return  Resultado
    }

    fun Generar_Navbar():String{
        return """
           <div class="navbar-fixed">
                <nav class="teal accent-4">
                    <div class="nav-wrapper ">
                        <a href="/inicio" class="brand-logo">$proyecto</a>
                        <a href="#" data-activates="mobile-demo" class="button-collapse">
                            <i class="material-icons">menu</i>
                        </a>
                        <ul class="right hide-on-med-and-down">
                            ${Generar_lista()}
                        </ul>
                        <ul class="side-nav" id="mobile-demo">
                            ${Generar_lista()}
                        </ul>
                    </div>
                </nav>
            </div>
        """
    }
}