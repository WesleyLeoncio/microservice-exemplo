package com.ms.user.producers;


import com.ms.user.models.entity.Usuario;
import com.ms.user.producers.request.EmailRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {

    final RabbitTemplate rabbitTemplate;

    public UsuarioProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routinKey;

    public void publishMessageEmail(Usuario usuario) {
        EmailRequest email = new EmailRequest();
        email.setUserId(usuario.getUserId());
        email.setEmailTo(usuario.getEmail());
        email.setSubject("Email enviado com sucesso!");
        email.setText(usuario.getNome() + ", seja bem vindo(a)! Agradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");
        rabbitTemplate.convertAndSend("", routinKey, email);
    }

}
