# api-usuario-enderecos

API criada para controlar endereços de usuários. Há um cadastro de usuários,
sendo obrigatório dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos.
Tambem ha um cadastro de enderecos, sendo obrigatório dados mínimos para cadastro como: logradouro, 
número, complemento, bairro, cidade, estado e CEP, com um relacionamento de muitos endereços para um usuário.

Endpoint base -> http://localhost:8080/api

Possui os seguintes verbos:

GET/usuario/{id}\
GET/cep{cep}\
POST/usuario\
POST/endereco

Tambem pode ser acessado pelo link seguinte:
### https://api-usuario-enderecos.herokuapp.com/api

