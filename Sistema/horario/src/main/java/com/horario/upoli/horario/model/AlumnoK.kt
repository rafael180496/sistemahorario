
package com.horario.upoli.horario.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Alumno")
data  class AlumnoK(
        @Id
        @Column(name = "id_alumno")
        var id_alumno:Long=0,
        @NotNull
        @Column(name = "carnet")
        var carnet:String="",
        @NotNull
        @Column(name = "nombre")
        var nombre:String="",
        @NotNull
        @Column(name = "apellido")
        var apellido:String="",
        @OneToOne
        @JoinColumn(name="id_carrera")
        var carrera:CarreraK= CarreraK(),
        @NotNull
        @Column(name = "f_creacion")
        var f_creacion:Date= Date(java.util.Date().time)

)
