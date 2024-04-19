## MICROSERVICE DE USUARIO

## DESCRIÇÃO
O desenvolvimento desse microservice tem como objetivo testar o microservice de emails

### ✔️ TÉCNICAS E TECNOLOGIAS UTILIZADAS
- Spring Boot 3.2.5
- SGBD (PostGresSQL)
- Docker
- RabbitMQ
-
### O QUE FOI DESENVOLVIDO
- CRIAÇÃO DAS ENTIDADES UTILIZANDO MIGRATIONS
- PRODUCER DE MESSAGES
- SERVICE PARA SALVAR OS USUARIO

### CONFIGURAÇÕES IMPORTANTES PARA O PROJETO FUNCIONAR CORRETAMENTE

#### No arquivo application.properties defina as seguintes propriedades.

- spring.rabbitmq.addresses(URL DO RABBITMQ)
