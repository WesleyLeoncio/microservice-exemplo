package com.ms.email.service.interfaces;


import com.ms.email.models.request.EmailRequest;

public interface IEmailService {

    void sendEmail(EmailRequest emailRequest);
}
