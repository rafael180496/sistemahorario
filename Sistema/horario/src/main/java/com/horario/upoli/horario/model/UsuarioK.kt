@file:JvmName("model")
package com.horario.upoli.horario.model

import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "Usuario")
data class UsuarioK(
        @Id
        @Column(name = "id_usuario")
        var id_usuario:Long=0,
        @OneToOne
        @JoinColumn(name="id_profesor")
        var profesor:ProfesorK= ProfesorK(),
        @NotNull
        @Column(name = "nom_usr")
        var nom_usr:String="",
        @NotNull
        @Column(name = "clave")
        var clave:String="",
        @NotNull
        @Column(name = "correo")
        var correo:String="",
        @NotNull
        @Column(name = "ind_rest")
        var ind_rest:Boolean=false,
        @NotNull
        @Column(name = "ind_adm")
        var ind_adm:Boolean=false,
        @NotNull
        @Column(name = "f_creacion")
        var  f_creacion:Date= Date(java.util.Date().time)

)