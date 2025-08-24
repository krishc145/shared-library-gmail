@Grab(group='com.sun.mail', module='javax.mail', version='1.6.2')
import org.krishtechnologies.utils.GmailSender

// Replace with your Gmail + App Password
def user = "krishnakumarchinnusamy@gmail.com"
def password = "Abishna@145256"  // your 16-digit Gmail App Password
def to = "krishnakumarchinnusamy@gmail.com"

GmailSender.sendMail(
    to,
    "✅ Local Test Mail",
    "Hello Krishna,\n\nThis is a test mail from your local Groovy script.\n\n- GmailSender",
    user,
    password
)
