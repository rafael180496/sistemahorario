package com.horario.upoli.horario.view.componentes

import com.horario.upoli.horario.model.CarreraK
import com.horario.upoli.horario.recursos.AccionK

fun ArrayList<CarreraK>.Generar_table(accion:AccionK):String{
    var Resultado=""
    Resultado+="""
        <table class="highlight responsive-table bordered centered">
            <thead>
                <tr>
                    <th>Cod.Reg</th>
                    <th>Nombre</th>
                    <th>Fecha</th>
                    <th>
                        <a class="btn-floating waves-effect waves-light" href="Add">
                            <i class="material-icons\">${accion.Add}</i>
                        </a>
                    </th>
                </tr>
            </thead>
            <tbody>
    """
    for (n in this){
        Resultado+="""
           <tr>
                <td>${n.id_carrera}</td>
                <td>${n.nombre}</td>
                <td>${n.f_creacion}</td>
        """
    }

    return  Resultado
}