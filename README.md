<h1 align="center"> Crud Básico com a Api REST</h1>


## 🔖 Layout / Link de acesso 

Você pode visualizar o layout do projeto através desse link http://springboot-rest-api-2021.herokuapp.com/springboot-rest-api-sample/ É necessário esperar alguns segundos para que o banco de dados suba.


![restapi](https://user-images.githubusercontent.com/51136557/124053426-99c5ee80-d9f6-11eb-94c5-5a1ef037b76e.gif)

## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- HTML
- CSS
- Bootstrap
- JavaScript/Jquery/Ajax
- SpringBoot Rest Api
- Jdk 8
- Postgres


## 💻 Projeto
<p align="justify"> Métodos de criação de nome e idade , gerando id automáticamente pelo postgres , pesquisar por nome específico , deletar , salvar , editar </p>

```bash
#Clonar repositório
git@github.com:Dark1922/Spring-Rest-basic.git

#Executar o projeto
spring.datasource.url=jdbc:postgresql://localhost:5432/seubanco?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
Colocar as dependências igual ao do seu banco , será gerado a tabela e as colunas no banco que você apontou o projeto
```
