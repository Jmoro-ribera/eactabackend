package isst.eacta.app.servicio;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(String to, String subject, String content) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(email);
	}
	
	public void sendEmailGrades(List<String> listEmails, String subject, List<String> grades) {

        for (int i = 0; i<listEmails.size(); ++i) 
        { 
            SimpleMailMessage email = new SimpleMailMessage();

            //recorremos la lista y enviamos a cada cliente el mismo correo
            email.setTo(listEmails.get(i));
            email.setSubject(subject);
            email.setText(grades.get(i));

            javaMailSender.send(email);
        }
    }
	
	
}