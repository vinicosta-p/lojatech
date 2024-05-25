# Api para e-commerce dropshipping 

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
## Sobre 
Essa é uma API que gerencia os cadastros de produtos e-commerce com a técnica de dropshipping. Com ela é possível fazer cadastros de produtos em estoque ou um produto da Aliexpress apenas passando o ID e informações extras do produto.
## Tabela de conteúdos

- [Sobre](#Sobre)
- [Tecnologias](#Tecnologias)
- [Como usar](#Como-usar)
	- [Pré Requisitos](#pre-requisitos)
	- [Rodando a aplicação](#Rodando-a-aplicacao)
	- [API Endpoints](#api-endpoints)

## Tecnologias

[![Java](https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/b0648ef7a9b6980ea27c1caaeb06d5c8503dbb4f9b4d9d7ca1df60a5edc14340/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465) [![Spring](https://camo.githubusercontent.com/c2a58428fe9b38967494da3b0a098f1d28f9cc395e3bbf123cbc14fb36bc1b07/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/c2a58428fe9b38967494da3b0a098f1d28f9cc395e3bbf123cbc14fb36bc1b07/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465) [![Postgres](https://camo.githubusercontent.com/bf590679058d9d1074a82721726ea4a5bf048b4b8cce82d01ba8ca32585e0298/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706f7374677265732d2532333331363139322e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d706f737467726573716c266c6f676f436f6c6f723d7768697465)](https://camo.githubusercontent.com/bf590679058d9d1074a82721726ea4a5bf048b4b8cce82d01ba8ca32585e0298/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706f7374677265732d2532333331363139322e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d706f737467726573716c266c6f676f436f6c6f723d7768697465) 

Esse projeto é uma API utiliza **Java, Java Spring, Flyway Migrations e PostgresSQL para armazenamento dos produtos.
## Como usar

### Pré Requisitos

Você vai precisar ter instalado em sua máquina as seguintes ferramentas:

- [Git](https://git-scm.com/)
- [PostgresSQL](https://www.postgresql.org/)
- Java 17 ou melhor
- [Maven](https://maven.apache.org/)

Preferencialmente utilizar a IDE Visual Studio Code.

Também é necessário uma conta, se inscrever na API [Aliexpress DataHub API](https://rapidapi.com/ecommdatahub/api/aliexpress-datahub)e guardar a chave no projeto.
### Rodando a aplicação

1. Clone o repositório

```shell
git clone https://github.com/vinicosta-p/lojatech.git
```

2. Instale as dependências do Maven

3. Dentro do projeto crie um arquivo com o nome **application.properties** dentro do path *lojatech\\src\\main\\resources* com os seguintes parametros

```
#database

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/lojatech
spring.datasource.username=INSIRA O USERNAME POSTGRES
spring.datasource.password=INSIRA A SENHA DO POSTGRES

#Env
api.key=${API_KEY:COLOQUE SUA CHAVE DA API ALIEXPRESS DATAHUB}
```

4. Rode a aplicação apertando F5 ou execute o arquivo lojatech\\src\\main\\java\\com\\pecastech\\app\\AppApplication.java 

5. A API está acessível na no endereço [http://localhost:8080](http://localhost:8080/)

### API Endpoints

**PRODUTO**

A api product é possível manipular os produtos em estoque como adicionar, alterar, deletar e mostrar todos os produtos disponíveis.

**API PRODUCT**
```markdown
POST /api/product - Create a new product  
GET /api/product - Retrieve all products 
PUT /api/product/{id} - Updates a product  
DELETE /api/product/{id} - Delete a product  
```

**BODY**
```json
{
	"ownerId":"0004", // ID dado pelo admnistrador
    "name":"Marca - Nome do produto", 
	"category":"Perfume",
	"shopId":"38123021", // ID de produtos da aliexpress
	"price":100000, // preço em centavos
	"promotionPrice": 90000,
	"description":"Este produto possui funcionalidades",
	"image":"https//",
	"quantity": 100
}
```

**ERROR**
```JSON
{
	"timestamp":"Fri May 24 21:38:41 BRT 2024",
	"status":"Error",
	"code":404,
	"stausCode":"Not found",
	"messageError":"Product not found try another id"
}
```

**DROPSHIPPING**

Nesse endpoint é possível adicionar um produto da Aliexpress apenas com o id do produto na loja online.

**API ALIEXPRESS**
```markdown
POST /api/product/aliexpress - Create a new product by aliexpress
```

**REQUEST BODY**
```json
{
    "ownerID":"004",
    "price":4000,
	"category":"Jogos",
	"promotionPrice":3000 
}
```

**RESPONSE BODY**
```json
{
	"ownerId":"0004", // ID dado pelo admnistrador
    "name":"Marca - Nome do produto", 
	"category":"Perfume",
	"shopId":"38123021", // ID de produtos da aliexpress
	"price":100000, // preço em centavos
	"promotionPrice": 90000,
	"description":"Este produto possui funcionalidades",
	"image":"https//",
	"quantity": 100
}
```
