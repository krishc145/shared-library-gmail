package org.krishtechnologies.utils

import javax.mail.*
import javax.mail.internet.*

class GmailSender {
    static void sendMail(String to, String subject, String body, String user, String password) {
        Properties props = new Properties()
        props.put("mail.smtp.auth", "true")
        props.put("mail.smtp.starttls.enable", "true")
        props.put("mail.smtp.host", "smtp.gmail.com")
        props.put("mail.smtp.port", "587")

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password)
            }
        })

        Message message = new MimeMessage(session)
        message.setFrom(new InternetAddress(user))
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
        message.setSubject(subject)
        message.setText(body)

        Transport.send(message)
        println "✅ Email sent to ${to}"
    }
}

