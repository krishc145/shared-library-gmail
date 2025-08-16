import org.krishtechnologies.utils.GmailSender

def call(Map config = [:]) {
    def to = config.to ?: "krishnakumarchinnusamy@gmail.com
    def subject = config.subject ?: "Jenkins Notification"
    def body = config.body ?: "Hello from Jenkins"
    def user = config.user ?: "krishnakumarchinnusamy@gmail.com"
    def password = config.password ?: "app-specific-password" // Use Jenkins credentials ideally

    GmailSender.sendMail(to, subject, body, user, password)
}

