package isst.eacta.app.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import isst.eacta.app.servicio.MailService;


@RestController
@RequestMapping("/api/email")
public class MailRest {
	
	@Autowired
	private MailService notificationService;
	
	@RequestMapping("/sendMail")
	public void send(@RequestBody @Valid List<String> email) {
		
		try {
			notificationService.sendEmail(email.get(0),email.get(1), email.get(2));
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	}
	
	@RequestMapping("/sendAllMails")
	public void sendAll(@RequestBody @Valid List<List<String>> vars) {
		List<String> a = new ArrayList<String>();
		List<String> c = new ArrayList<String>();
		String b = "";
		try {
			a = vars.get(0);
			b = vars.get(1).get(0);
			c = vars.get(2);
			notificationService.sendEmailGrades(a,b,c);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	}

}
