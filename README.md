# 🐾 Sistema para Clínica Veterinária

Um aplicativo desktop simples e eficiente desenvolvido em **Java** para o gerenciamento de pequenas clínicas veterinárias. 

Este projeto foi criado com o objetivo de ser uma solução prática para o controle de pets, tutores, consultas e registros básicos de serviços, como vacinas e exames. Ele possui uma interface limpa, sendo ideal tanto para uso em clínicas de pequeno porte quanto como um projeto de estudo em Java.

## ✨ Funcionalidades

* **Gestão de Tutores (Clientes) e Pets:** Cadastro, edição, busca e remoção de registros de donos e seus respectivos animais.
* **Agendamento de Consultas:** Controle de horários e datas para atendimento.
* **Histórico Médico:** Registro e visualização do histórico de cada animal, incluindo consultas, exames e tratamentos.
* **Controle de Veterinários e Espécies:** Gerenciamento dos profissionais da clínica e catálogo de espécies atendidas.
* **Interface Simples (CRUD):** Telas limpas e formulários diretos para as ações principais, facilitando o uso no dia a dia.

## 🛠️ Tecnologias e Arquitetura

O projeto foi estruturado com foco na clareza e facilidade de expansão, utilizando padrões de projeto clássicos:

* **Linguagem:** Java
* **Interface Gráfica:** Java Swing (utilizando `TableModels` personalizados)
* **Banco de Dados:** MySQL
* **Arquitetura:** MVC (Model-View-Controller)
* **Acesso a Dados:** Padrão DAO (Data Access Object)

### Estrutura de Pacotes
O código está organizado da seguinte forma para facilitar o entendimento:
* `model`: Classes de domínio (`Animal`, `Cliente`, `Consulta`, etc.) e classes de acesso ao banco (`AnimalDAO`, `ClienteDAO`, etc.).
* `view`: Classes responsáveis pela interface com o usuário (`TableModels` e telas).
* `controller`: Lógica de controle que intermedeia a *View* e o *Model*.
* `main`: Ponto de entrada da aplicação.

## 🚀 Como Executar

O projeto foi configurado para rodar facilmente a partir de qualquer IDE moderna (VS Code, Eclipse, IntelliJ ou NetBeans) sem a necessidade de configurações complexas.

### Pré-requisitos
* **Java JDK** (versão 8 ou superior)
* **MySQL Server** instalado e rodando
* Uma IDE de sua preferência

### Passos
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
   ```
2. **Configure o Banco de Dados:**
   * Crie um banco de dados no MySQL para o projeto.
   * *Nota: Inclua aqui instruções sobre onde alterar as credenciais de banco de dados (ex: usuário e senha do MySQL na classe de conexão) ou disponibilize um script `.sql` na raiz do projeto para criar as tabelas com dados de exemplo (Sample Data).*
3. **Abra o projeto na sua IDE:**
   * O projeto possui suporte tanto para Maven (`pom.xml`) quanto estrutura padrão do Eclipse/VS Code.
4. **Execute a aplicação:**
   * Navegue até o pacote `main` e execute a classe `Main.java`.

## 🌱 Dados de Exemplo (Sample Data)

Para facilitar os testes imediatos, o projeto foi pensado para rodar com dados de exemplo. Certifique-se de importar o script de banco de dados (se disponível) para visualizar clientes, pets e consultas preenchidas assim que abrir o sistema.

## 🤝 Contribuição

Este é um projeto com estilo acadêmico (student-style), construído de forma simples e direta. Sinta-se à vontade para fazer um *fork*, abrir *issues* ou enviar *pull requests* com melhorias na interface ou novas funcionalidades!

---
*Desenvolvido com dedicação para facilitar o cuidado com os animais.* 🐶🐱
