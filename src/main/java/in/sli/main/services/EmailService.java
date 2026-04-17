package in.sli.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import in.sli.main.beans.LoginRequest;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private LoginServices ls;
	
	public boolean sendEmail(String email, String subject, String body) {
		try {
			SimpleMailMessage message=new SimpleMailMessage();
			message.setTo("slshree321@gmail.com");
			message.setSubject(subject);
			message.setText(body);
			message.setFrom("slshree321@gmail.com");
			mailSender.send(message);
			
			
			SimpleMailMessage message2=new SimpleMailMessage();
			message2.setTo(email);
			message2.setSubject("Message Received");
			message2.setText("Shreyash Limbikai received your message \n You will receive a reply within 2 days");
			message2.setFrom("slshree321@gmail.com");
			mailSender.send(message2);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean sendForgotPassEmail() {
		try {
			LoginRequest lr= ls.findByEmailLoginRequest("shreyashlimbikai123@gmail.com");
			SimpleMailMessage message=new SimpleMailMessage();
			message.setTo("slshree321@gmail.com");
			message.setSubject("Forgot Password");
			message.setText("Password: "+lr.getPass());
			message.setFrom("slshree321@gmail.com");
			mailSender.send(message);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
}
