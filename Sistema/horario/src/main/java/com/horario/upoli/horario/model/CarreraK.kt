
package com.horario.upoli.horario.model

import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Carrera")
data class CarreraK(
        @Id
        @Column(name = "id_carrera")
        var id_carrera:Long=0,
        @NotNull
        @Column(name = "nombre")
        var nombre:String="",
        @NotNull
        @Column(name = "f_creacion")
        var f_creacion:Date= Date(java.util.Date().time)
)

