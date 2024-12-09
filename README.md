# 1ª Procedimento
## Criação das Entidades e Sistema de Persistência
❕Essa branch se refere somente ao 1ª Procedimento.

## Objetivos desse procedimento
1. Utilizar herança e polimorfismo na  definição de entidades.
2. Utilizar persistência de objetos em arquivos binários.
3. Utilizar o controle de exceções da plataforma Java.

## Tecnologias utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

## Diagrama das classes
```mermaid
classDiagram
    class Pessoa
      <<Abstract>> Pessoa
      Pessoa : -int id
      Pessoa : -String nome
      Pessoa : +exibir()* String
      Pessoa <|-- PessoaFisica
      Pessoa <|-- PessoaJuridica

    class PessoaFisica
      PessoaFisica : -String cpf
      PessoaFisica : -int idade
      PessoaFisica : +exibir() String

    class PessoaJuridica
      PessoaJuridica : -String cnpj
      PessoaJuridica : +exibir() String
```
