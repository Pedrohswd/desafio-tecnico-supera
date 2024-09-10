# Configuração da API Desafio Técnico

Este guia irá ajudá-lo a configurar o banco de dados, ajustar as propriedades da aplicação e garantir que você está usando o Java 17 para executar a API.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes itens instalados:

- [Java 17](https://adoptium.net/)
- [PostgreSQL](https://www.postgresql.org/)
- [Maven](https://maven.apache.org/)

## Configuração do Banco de Dados

1. **Instale o PostgreSQL**

   Se ainda não tiver o PostgreSQL instalado, você pode baixá-lo e instalá-lo a partir do [site oficial](https://www.postgresql.org/download/).

2. **Crie o Banco de Dados**

   Após instalar o PostgreSQL, crie um banco de dados chamado `desafio`:

   ```sql
   CREATE DATABASE desafio;
   ````

3. **Configuração do Usuário**

  Certifique-se de que você tem um usuário com acesso ao banco de dados. Por padrão, o usuário postgres é criado. Se estiver usando outro usuário, ajuste as credenciais de acordo.

  **Configuração do Arquivo de Propriedades**
  Localize o Arquivo de Propriedades: 
  O arquivo application.properties está localizado em src/main/resources/.
  
  Ajuste as Propriedades do Banco de Dados.
  Configure as propriedades de conexão com o banco de dados no application.properties:

  Ajuste spring.datasource.username e spring.datasource.password conforme as credenciais do seu banco de dados.

 ## Executando a Aplicação
  
  Compile e Execute a Aplicação


  A aplicação será iniciada na porta padrão 8080.
  Verifique se a Aplicação Está Funcionando.
  Acesse a aplicação e a documentação Swagger UI:
  
  API Base URL: http://localhost:8080
  Documentação Swagger UI: http://localhost:8080/swagger-ui.html
