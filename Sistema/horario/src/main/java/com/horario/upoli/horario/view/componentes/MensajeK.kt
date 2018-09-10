@file:JvmName("componentes")
package com.horario.upoli.horario.view.componentes

import com.horario.upoli.horario.constante.EstilosK
import com.horario.upoli.horario.constante.MensajeIcoK
import com.horario.upoli.horario.constante.ScripsK
import com.horario.upoli.horario.model.UsuarioK
import com.horario.upoli.horario.recursos.PermisoK
import com.horario.upoli.horario.seguridad.PermisosK

data class MensajeK(
        var Cuerpo:String="",
        var btn_cancelar:Boolean=false,
        var btn_verde: PermisoK=PermisoK(),
        var btn_rojo: PermisoK=PermisoK(),
        var tipo:String= MensajeIcoK.Advertencia.mostrar,
        var html:HtmlK= HtmlK()
){
    fun Enviar_scrip():ArrayList<String>{
        return arrayListOf(
                ScripsK.jquery.mostrar,
                ScripsK.materialize.mostrar
        )
    }
    fun Enviar_Estilo():ArrayList<String>{
        return arrayListOf(
                EstilosK.Material_Icons.mostrar,
                EstilosK.materialize.mostrar,
                EstilosK.general.mostrar,
                EstilosK.fonts.mostrar
        )
    }

    fun Generar_Mensaje(user: UsuarioK):String{
        html.titulo="SDH"
        html.estilos=Enviar_Estilo()
        html.scrip=Enviar_scrip()
        var cuerpo:ArrayList<String> = arrayListOf()
        cuerpo.add(NavbarK.Generar_navBar(user,"SDH"))
        cuerpo.add("""
           <div class="container">
                <div class="section"></div>
                <div class="row">
                    <div class="col s6 offset-s3">
                        <div class="card hoverable horizontal grey lighten-3">
                            <div class="card-image  ">
                                <img src="$tipo" alt="">
                            </div>
                            <div class="card-stacked">
                                <div class="card-content ">
                                    <p class="card-title">$Cuerpo</p>
                                </div>
                                <div class="card-action ">
                                    <a class="waves-effect waves-light btn verde" href="${btn_verde.accion}">${btn_verde.nombre}</a>
        """)
                            if (btn_cancelar){
                                cuerpo.add("""
                                    <a class="waves-effect waves-light btn red rojo" href="${btn_rojo.accion}">${btn_rojo.nombre}</a>
                                """)
                            }
                        cuerpo.add("""
                                </div>
                            </div>
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