# 🛒 Sistema de Pedidos - POO e Spring Boot

Esta atividade foi desenvolvida na disciplina de **Programação Orientada a Objetos (POO)**. O objetivo inicial foi praticar os conceitos fundamentais de **abstração, herança, polimorfismo e interfaces** através da implementação de um sistema de pedidos.

O projeto foi **evoluído** para uma aplicação web moderna usando o **Spring Boot**, expondo a lógica de negócios através de uma API REST e servindo dados de produtos a partir de um arquivo `.csv`.

---

## 🚀 Funcionalidades da Lógica de Negócios (POO)
- Cadastro de clientes (Pessoa Física e Pessoa Jurídica).
- Criação de pedidos e associação de itens.
- Implementação de uma **interface de pagamento**, permitindo diferentes estratégias (ex: cartão e boleto).
- **Lógica de confirmação de pedido** que processa o pagamento e atualiza o status automaticamente.
- **Gerenciamento de status** para pedidos e pagamentos (`Pendente`, `Aprovado`, `Processando`, etc.) através de `Enums`.
- Uso de **classe abstrata `Cliente`** como base para `ClientePF` e `ClientePJ`.
- Demonstração prática dos princípios de **POO**.

## 🌐 Funcionalidades da API REST (Spring Boot)
- **Servidor Web Embutido:** A aplicação roda em um servidor Tomcat embutido, facilitado pelo Spring Boot.
- **API REST de Produtos:** Expõe um endpoint `GET /produtos` para consultar o catálogo de produtos.
- **Carregamento de Dados:** Os produtos são carregados dinamicamente do arquivo `produtos.csv` localizado em `src/main/resources/`.
- **Inicialização Eficiente:** Os dados do CSV são carregados **apenas uma vez** na inicialização da aplicação (usando `@PostConstruct` e `ResourceLoader`) e mantidos em memória para performance.
- **Conversão Automática para JSON:** A `List<Produto>` retornada pelo endpoint é automaticamente convertida para o formato JSON pelo Spring Web.

---

## 💻 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot:** Framework principal para a criação da aplicação web.
- **Spring Web:** Dependência para a criação de endpoints RESTful.
- **Maven:** Gerenciador de dependências e build do projeto.

---

## 📌 Conceitos de POO Aplicados

- **Abstração:** A classe `Cliente` e a interface `IPagamento` definem contratos e modelos genéricos, escondendo os detalhes complexos de suas implementações específicas.

- **Herança:** As classes `ClientePF` e `ClientePJ` herdam atributos e comportamentos comuns da classe abstrata `Cliente`, especializando-se com seus próprios atributos (CPF, CNPJ).

- **Polimorfismo:** Permite que objetos de diferentes classes respondam à mesma mensagem de maneiras distintas. Isso é visto principalmente em dois pontos:
    - **Através de Interfaces:** A classe `Pedido` manipula um objeto do tipo `IPagamento`. Em tempo de execução, este objeto pode ser uma instância de `PagamentoCartaoCredito` ou `PagamentoBoleto`. Ao chamar o método `processarPagamento()`, o comportamento correto é executado dinamicamente, sem que a classe `Pedido` precise conhecer os detalhes de cada tipo de pagamento.
    - **Através de Herança:** Uma variável do tipo `Cliente` pode referenciar um objeto `ClientePF` ou `ClientePJ`. A chamada ao método `getIdentificadorUnico()` executará a implementação específica da subclasse, retornando o CPF ou o CNPJ conforme o tipo real do objeto.

- **Interfaces:** `IPagamento` define um contrato obrigatório para todas as classes de pagamento, garantindo que qualquer método de pagamento terá a funcionalidade `processarPagamento()`.

- **Composição:** O `Pedido` é composto por uma lista de `ItemPedido`, associado a um `Cliente` e a uma estratégia de `IPagamento`.

- **Enumerações (Enums):** As classes `StatusPedido` e `StatusPagamento` garantem um controle de estado robusto, seguro e legível em todo o fluxo do sistema.

---

## ⚡ Como Executar

**Pré-requisitos:**
- Java 17 (ou superior)
- Maven 3.x.x

**Passos:**

1.  Clone este repositório:
    ```bash
    git clone [SUA-URL-DO-GIT-AQUI]
    ```
2.  Navegue até a pasta raiz do projeto.
3.  Execute a aplicação usando o Maven:
    ```bash
    mvn spring-boot:run
    ```
    *(Alternativamente, você pode abrir o projeto em sua IDE (como VS Code ou IntelliJ) e executar o método `main` da classe `SistemaPedidos.java`)*

4.  O servidor será iniciado na porta `8080`.

## 🧪 Testando o Endpoint
Após iniciar a aplicação, abra seu navegador ou cliente de API (como Postman) e acesse:

`http://localhost:8080/produtos`

O servidor deve retornar uma resposta com o status **200 OK** e um corpo em JSON contendo a lista de produtos do arquivo `produtos.csv`.
