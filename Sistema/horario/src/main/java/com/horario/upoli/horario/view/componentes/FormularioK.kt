
package com.horario.upoli.horario.view.componentes

data  class  FormularioK(
        var Cuerpo_formulario:ArrayList<String> = arrayListOf(),
        var Accion:String="",
        var metodo:String="",
        var id_f:String="Sin"
){
    fun Generar_formulario():String="""
       <form action="$Accion" method="$metodo" id="$id_f" >
            ${Cuerpo_formulario.mostrarList()}
       </form>
    """
}