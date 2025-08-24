@Grab(group='com.sun.mail', module='javax.mail', version='1.6.2')
import javax.mail.*
import javax.mail.internet.*

// ---------------- CONFIG ----------------
def user = "krishnakumarchinnusamy@gmail.com"   // your Gmail
def password = "ixsaxrbunuvaxluf"               // 16-digit App Password
def to = "krishnakumarchinnusamy@gmail.com"    // recipient
// ---------------------------------------

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

try {
    Message message = new MimeMessage(session)
    message.setFrom(new InternetAddress(user))
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to))
    message.setSubject("✅ Test Gmail from Groovy")
    message.setText("Hello Krishna,\n\nThis is a test email from Groovy script!\n\n- Groovy Gmail Test")

    Transport.send(message)
    println "✅ Email sent successfully to $to"
} catch (Exception e) {
    println "❌ Failed to send email: ${e.message}"
    e.printStackTrace()
}
