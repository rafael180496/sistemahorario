@file:JvmName("view")
package com.horario.upoli.horario.view

import com.horario.upoli.horario.constante.EstilosK
import com.horario.upoli.horario.constante.ScripsK
import com.horario.upoli.horario.model.UsuarioK
import com.horario.upoli.horario.view.componentes.FooterK
import com.horario.upoli.horario.view.componentes.HtmlK
import com.horario.upoli.horario.view.componentes.NavbarK

data class HomeK(
        var usuario: UsuarioK = UsuarioK()

        ){
    fun Generar_Home():String{
        var html:HtmlK = HtmlK()
        var cuerpo:ArrayList<String> = arrayListOf()
        html.titulo="SDH"
        html.scrip=ScripsK.MandarScrip(arrayListOf(1,2))
        html.estilos=EstilosK.MandarEstilo(arrayListOf(1,2,5,6))
        html.scrip_manual="""
            <script>
                ${'$'}('.carousel.carousel-slider').carousel({
                        fullWidth: true
                        });
                ${'$'}(".button-collapse").sideNav();
            </script>
        """
        cuerpo.add(NavbarK.Generar_navBar(usuario,"SDH"))
        cuerpo.add("""
            <div class="container">
                <div class="row">
                    <div class="col s12">
                        <br>
                        <div class="carousel carousel-slider center " data-indicators="true">

                            <div class="carousel-item red white-text" href="#one!">

                                <h2>Prueba1</h2>
                                <p class="white-text">Prueba1</p>
                            </div>
                            <div class="carousel-item amber white-text" href="#two!">
                                <h2>Prueba2</h2>
                                <p class="white-text">Prueba2</p>
                            </div>
                            <div class="carousel-item green white-text" href="#three!">
                                <h2>Prueba3</h2>
                                <p class="white-text">Prueba3</p>
                            </div>
                            <div class="carousel-item blue white-text" href="#four!">
                                <h2>Prueba4</h2>
                                <p class="white-text">Prueba4</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        """)
        cuerpo.add(FooterK.footer)
        html.cuerpo=cuerpo
        return  html.Generar_Html()
    }
}

