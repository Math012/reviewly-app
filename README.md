# Reviewly App

## Descrição

- A proposta do projeto é realizar a postagem, edição e exclusão de resenhas e notas sobre filmes, series e livros. Alinhado com o front-end o usuário terá que escolher qual categoria ele gostaria de postar a resenha, após escolher a categoria o usuário deve informar o título, resenha e a nota e de forma automática a aplicação pegará a data do momento da postagem.

  - O projeto conta com o sistema de autenticação implementado pelo Spring Security fornecendo tokens JWT para o acesso aos endpoints privados.

- Como esse projeto foi desenvolvido para um desafio na plataforma DIO, não foi implementado o front-end e tem algumas questões de segurança que serão implementadas futuramente
  - Não tem controle para saber se a edição/exclusão está sendo feita pelo usuário responsável pela postagem.
 
## Endpoints

- O projeto implementa os métodos de requisição GET, POST, PUT e DELETE.


### Endpoint de cadastro - /users/register
  - endpoint público

```jason
{
    "name": "Nome completo",
    "lastname": "Sobrenome",
    "age": 18,
    "username": "username",
    "password": "senha"
}
```

### Endpoint de login - /users/login
  - Endpoint público

```jason
{
    "username": "username",
    "password": "senha"
}
```
response: ![image](https://github.com/user-attachments/assets/d47f3a42-3865-4045-a53d-a758e8609904)

### Endpoint para a criação da resenha - /reviews/publications/{username}/books
  - É necessário informar o nome de usuário.
  - Endpoint bloqueado.
```jason
{
    "title":"titulo",
    "review":"resenha",
    "rating": 5
}
```
### Endpoint para recuperar todas as resenhas com base no nome da categoria - /reviews/all/category/{categoria}
  - É necessário informar o nome da categoria.
  - Endpoint público.
    
response:
```jason
[
    {
        "id": 1,
        "titleOfTheWork": "titulo da resenha",
        "rating": 5,
        "review": "resenha",
        "date": "data",
        "category": "categoria"
    }
]
```
### Endpoint para recuperar todas as resenhas com base no nome de usuário - /reviews/all/reviews/{username}
  - É necessário informar o nome de usuário.
  - Endpoint público.
    
response:

```jason
[
    {
        "id": 1,
        "titleOfTheWork": "titulo da resenha",
        "rating": 5,
        "review": "resenha",
        "date": "data",
        "category": "categoria"
    }
]
```
### Endpoint para editar uma resenha com base em seu id - /reviews/update/reviews/by/{id}
  - É necessário informar o id da categoria.
  - Endpoint privado.

```jason
{
    "title":"titulo editado",
    "review":"resenha editada"
}
```

response: "Alteração feita com sucesso!"
### Endpoint para escluir uma resenha com base em seu id - /reviews/delete/reviews/by/{id}
  - É necessário informar o id da categoria.
  - Endpoint privado.
    
response: 200 - OK

Créditos: math012
