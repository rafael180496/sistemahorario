
package com.horario.upoli.horario.recursos

import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

data class CorreoK(
        var Username:String="sistemahorarioSDH@gmail.com",
        var PassWord:String="upoli123",
        var Asunto:String="",
        var Mensage:String="",
        var Para:String=""
){
    fun SendMail(){
        var props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.port"] = "587"
        /*
        *
        * instancia de clases abstractas en kotlin
        * */
        var auth=object :Authenticator(){
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(Username,PassWord)
            }
        }
        var session=Session.getInstance(props,auth)

        try {
            var message= MimeMessage(session)
            message.setFrom(InternetAddress(Username))
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Para))
            message.subject = Asunto
            message.setText(Mensage)

            Transport.send(message)

        }catch (e:MessagingException ){
            throw RuntimeException(e)
        }


    }



}
