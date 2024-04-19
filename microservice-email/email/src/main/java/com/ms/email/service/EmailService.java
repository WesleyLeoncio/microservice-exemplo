package com.ms.email.service;

import com.ms.email.models.entity.Email;
import com.ms.email.models.enums.StatusEmail;
import com.ms.email.models.mapper.EmailMapper;
import com.ms.email.models.request.EmailRequest;
import com.ms.email.repository.EmailRepository;
import com.ms.email.service.interfaces.IEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class EmailService implements IEmailService {

    final JavaMailSender mailSender;

    final EmailRepository emailRepository;

    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;


    @Override
    @Transactional
    public void sendEmail(EmailRequest emailRequest) {
        Email email = EmailMapper.INSTANCE.emailRequestToEmail(emailRequest);
        try {
            email.setSendDateEmail(LocalDate.now());
            email.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

            emailRepository.save(email);
        }catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        }

    }
}
