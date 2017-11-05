package com.horario.upoli.horario.recursos;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;
public class Correo {
private String Username="sistemahorarioSDH@gmail.com";
private String PassWord="upoli123";
private  String Asunto="";
private String Mensage="";
private  String Para="";

    public Correo(String username, String passWord, String asunto, String mensage, String para) {
        Username = username;
        PassWord = passWord;
        Asunto = asunto;
        Mensage = mensage;
        Para = para;
    }

    public Correo(String asunto, String mensage, String para) {
        Asunto = asunto;
        Mensage = mensage;
        Para = para;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String asunto) {
        Asunto = asunto;
    }

    public String getMensage() {
        return Mensage;
    }

    public void setMensage(String mensage) {
        Mensage = mensage;
    }

    public String getPara() {
        return Para;
    }

    public void setPara(String para) {
        Para = para;
    }

    public void SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(Para));
            message.setSubject(Asunto);
            message.setText(Mensage);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
