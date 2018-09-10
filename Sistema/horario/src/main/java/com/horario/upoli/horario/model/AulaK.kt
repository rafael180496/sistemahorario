@file:JvmName("model")
package com.horario.upoli.horario.model

import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Aula")
data class AulaK(
        @Id
        @Column(name = "id_aula")
        var  id_aula:Long=0,
        @NotNull
        @Column(name = "desc_aula")
        var desc_aula:String="",
        @NotNull
        @Column(name = "ind_mant")
        var ind_mant:Boolean=false,
        @NotNull
        @Column(name = "f_creacion")
         var f_creacion:Date= Date(java.util.Date().time)
)
