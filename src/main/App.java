import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: alacerda
 * Date: 10/29/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

        EmailSender mm = (EmailSender) context.getBean("mailMail");
        mm.sendMailWithAttachment("anaclara.lacerdas@gmail.com",
                "Check out your Bike @ Freewheelers", "Testing only \n\n Hello Spring Email Sender", "bike.jpg", "src/images/bike.png");
    }
}
