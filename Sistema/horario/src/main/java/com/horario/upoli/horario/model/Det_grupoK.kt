@file:JvmName("model")
package com.horario.upoli.horario.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Det_grupo")
data class Det_grupoK(
        @Id
        @Column(name = "id_det_grupo")
        var id_det_grupo:Long=0,
        @OneToOne
        @JoinColumn(name="id_alumno")
        var alumno:AlumnoK= AlumnoK(),
        @OneToOne
        @JoinColumn(name="id_grupo")
        var grupo:GrupoK= GrupoK(),
        @NotNull
        @Column(name = "f_creacion")
        var f_creacion:Date= Date(java.util.Date().time)
)