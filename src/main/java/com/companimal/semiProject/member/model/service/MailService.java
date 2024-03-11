package com.companimal.semiProject.member.model.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendMail(String email, HttpSession session) {

        SimpleMailMessage simpleMessage = new SimpleMailMessage();

        simpleMessage.setTo(email);

        simpleMessage.setSubject("컴패니몰 회원 가입 인증");

        String authCode = createAuthCode();

        simpleMessage.setText("안녕하세요. 반려동물의 건강과 행복한 삶의 동반자, 컴패니몰입니다. 회원 가입을 위한 본인 확인용 이메일입니다. 아래의 인증 번호를 입력해주세요. (인증번호의 형식은 6개의 랜덤 숫자로 구성됩니다.)\n인증번호는" + authCode + " 입니다.");

        javaMailSender.send(simpleMessage);

        System.out.println(authCode);
        session.setAttribute(email, authCode);
    }

    private String createAuthCode() {

        int randomNumber = (int)(Math.random() * 1000000);
        return String.format("%06d", randomNumber);
    }

}