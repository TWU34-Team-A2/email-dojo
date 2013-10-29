import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alacerda
 * Date: 10/29/13
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmailSender {

    // add jar javax.mail
    // create images folder

    private final String FROM = "freewheelers.test@gmail.com";
    private JavaMailSenderImpl mailSender;

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String to, String subject, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(FROM);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
    }

    public void sendMailToMoreThanOne(List<String> to, String subject, String msg) {
        for (String email : to) {
            sendMail(email, subject, msg);
        }
    }

    public void sendMailWithAttachment(String to, String subject, String msg, String filename, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(FROM);
            helper.setSubject(subject);
            helper.setText(msg);

            FileSystemResource fileBike = new FileSystemResource(new File(filePath));
            helper.addAttachment(filename, fileBike);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(message);
    }

}
