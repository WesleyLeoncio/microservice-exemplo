## MICROSERVICE DE EMAIL

## DESCRIÇÃO
O desenvolvimento desse microservice tem como objetivo enviar e salvar os email.

### ✔️ TÉCNICAS E TECNOLOGIAS UTILIZADAS
- Spring Boot 3.2.5
- SGBD (PostGresSQL)
- Docker
- RabbitMQ
- 
### O QUE FOI DESENVOLVIDO
- CRIAÇÃO DAS ENTIDADES UTILIZANDO MIGRATIONS
- CONSUMER DE MESSAGES
- SERVICE PARA SALVAR OS EMAILS

### CONFIGURAÇÕES IMPORTANTES PARA O PROJETO FUNCIONAR CORRETAMENTE

#### No arquivo application.properties defina as seguintes propriedades.

- spring.rabbitmq.addresses(URL DO RABBITMQ)
- spring.mail.username(EMAIL QUE IRA ENVIAR OS EMAILS)
- spring.mail.password(SENHA DE APP DO GOOGLE)
