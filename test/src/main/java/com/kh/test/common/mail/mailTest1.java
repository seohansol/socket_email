package com.kh.test.common.mail;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mailTest1 {
	
	
	@GetMapping("/save")
	public void mail() {
		
		// 메일 보내는 객체
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		// 계정설정
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("snake9602");
		sender.setPassword("uvrngxarvrbxrunu");
		
		// 옵션 설정
		Properties options = new Properties();
		options.put("mail.smtp.auth", true);
		options.put("mail.smtp.starttls.enable", true);
		
		sender.setJavaMailProperties(options);
		
		// 메시지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		
		// 메시지 정보 : 제목, 내용 ,받는사람, 참조, 숨은참조, 첨부파일 (SimpleMailMessage: 불가능)
		
		message.setSubject("제목입니다~");	// 제목
		message.setText("내용입니다~~ 인증번호 쓰십시요~");  // 내용
		message.setTo("snake9602@gmail.com");
		
		sender.send(message);
		
	}
}
