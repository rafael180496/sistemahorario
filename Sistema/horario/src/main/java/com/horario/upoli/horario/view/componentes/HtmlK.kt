@file:JvmName("componentes")
package com.horario.upoli.horario.view.componentes

data class HtmlK(
        var estilos:ArrayList<String> = arrayListOf(),
        var scrip:ArrayList<String> = arrayListOf(),
        var cuerpo:ArrayList<String> = arrayListOf(),
        var scrip_manual:String = "",
        var estilo_manual:String = ""
){
    var titulo:String="<title>Prueba</title>"
    get()="<title>$field</title>"

    companion object {
        val head_ini:String="""
            <!DOCTYPE html>
                <html xmlns:th="http://www.thymeleaf.org">
                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                        <meta name="viewport" content="width=device-width, initial-scale=1" />
        """
        val head_fin:String="""
            </head>
        """
        val body_ini:String="""
            <body>
                <main>
        """
        val body_fin:String="""
           </body>
        </html>
        """
    }

    fun Generar_Html():String="""
        $head_ini
        $titulo
        ${estilos.mostrarList()}
        $estilo_manual
        $head_fin
        $body_ini
        ${cuerpo.mostrarList()}
        $scrip
        $scrip_manual
        $body_fin
    """
}

fun ArrayList<String>.mostrarList():String{
    var rel:String=""
    for(i in this)rel+=i
    return rel
}