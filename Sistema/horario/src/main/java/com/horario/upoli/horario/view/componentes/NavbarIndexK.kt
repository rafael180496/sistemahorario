@file:JvmName("componentes")
package com.horario.upoli.horario.view.componentes

data class NavbarIndexK(
        var titulo:String="",
        var navegacion:String="",
        var ul_nombre:String=""
){
    fun Generar_navbar():String ="""
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper white">
                    <a href="#!" class=" color brand-logo ">
                        <img class="responsive-img" id="logo" src="https://firebasestorage.googleapis.com/v0/b/horario-8c987.appspot.com/o/Img%2Flogo.png?alt=media&token=8b556b15-bb58-4f1c-9043-4983d559fe45"
                            alt="">
                    </a>

                    <a href="#" data-activates="mobile-demo" class="button-collapse ">
                        <i class="material-icons tealicon">menu</i>
                    </a>
                    <ul class="right hide-on-med-and-down ">
                        <li>
                            <a href="$navegacion"><i class="material-icons left">account_circle</i>$ul_nombre</a>
                        </li>

                    </ul>
                    <ul class="side-nav" id="mobile-demo">

                        <li>
                            <a href="$navegacion"><i class="material-icons left">account_circle</i>$ul_nombre</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
"""
}