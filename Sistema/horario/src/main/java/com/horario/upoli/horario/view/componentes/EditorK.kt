
package com.horario.upoli.horario.view.componentes

import com.horario.upoli.horario.constante.EstilosK
import com.horario.upoli.horario.constante.ScripsK
import com.horario.upoli.horario.model.UsuarioK

abstract class EditorK(
        var usuario:UsuarioK = UsuarioK(),
        var nuevo:Boolean = false
){
        var html:HtmlK = HtmlK()
        var scrip_m:String = ""
        abstract fun Enviar_Formulario():String

        fun GenerarEditar():String{
            var cuerpo:ArrayList<String> = arrayListOf()
            html.titulo="SDH"
            html.scrip=ScripsK.MandarScrip(arrayListOf(1,2,4))
            html.estilos=EstilosK.MandarEstilo(arrayListOf(1,2,5,6))
            html.scrip_manual=scrip_m
            cuerpo.add(NavbarK.Generar_navBar(usuario,"SDH"))
            cuerpo.add("""
               <div class="container">
                    <div class="section"></div>
                    <div class="row">

                        <div class="col s6 offset-s3">

                            <div class="card hoverable grey lighten-4">
                                ${Enviar_Formulario()}
                            </div>
                        </div>
                    </div>
                </div>
            """)
            cuerpo.add(FooterK.footer)
            html.cuerpo=cuerpo
            return html.Generar_Html()
        }
}