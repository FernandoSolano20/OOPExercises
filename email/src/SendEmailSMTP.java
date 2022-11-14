import com.sun.mail.smtp.SMTPTransport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmailSMTP {

    // for example, smtp.mailgun.org


    public static void main(String[] args) throws MessagingException {
        sendMail(EMAIL_TO);
    }


}