package com.ms.email.consumers;


import com.ms.email.models.request.EmailRequest;
import com.ms.email.service.interfaces.IEmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final IEmailService emailService;

    public EmailConsumer(IEmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest);
    }

}
