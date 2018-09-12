
package com.horario.upoli.horario.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Grupo")
data class GrupoK(
        @Id
        @Column(name = "id_grupo")
        var id_grupo:Long=0,
        @OneToOne
        @JoinColumn(name="id_profesor")
        var profesor:ProfesorK= ProfesorK(),
        @OneToOne
        @JoinColumn(name="id_clase")
        var clase:ClaseK= ClaseK(),
        @NotNull
        @Column(name = "nombre")
        var nombre:String="",
        @NotNull
        @Column(name = "f_creacion")
        var f_creacion:Date= Date(java.util.Date().time)
)