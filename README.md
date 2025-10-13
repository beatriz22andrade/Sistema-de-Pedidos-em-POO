# 🛒 Sistema de Pedidos - POO

Esta atividade foi desenvolvida na disciplina de **Programação Orientada a Objetos (POO)**.
O objetivo foi praticar os conceitos fundamentais de **abstração, herança, polimorfismo e interfaces**, através da implementação de um **sistema de pedidos**.

---

## 🚀 Funcionalidades
- Cadastro de clientes (Pessoa Física e Pessoa Jurídica).
- Criação de pedidos e associação de itens.
- Implementação de uma **interface de pagamento**, permitindo diferentes estratégias (ex: cartão e boleto).
- **Lógica de confirmação de pedido** que processa o pagamento e atualiza o status automaticamente.
- **Gerenciamento de status** para pedidos e pagamentos (`Pendente`, `Aprovado`, `Processando`, etc.) através de `Enums`.
- Uso de **classe abstrata `Cliente`** como base para `ClientePF` e `ClientePJ`.
- Demonstração prática dos princípios de **POO**.

---

## 📌 Conceitos de POO aplicados

- **Abstração:** A classe `Cliente` e a interface `IPagamento` definem contratos e modelos genéricos, escondendo os detalhes complexos de suas implementações específicas.

- **Herança:** As classes `ClientePF` e `ClientePJ` herdam atributos e comportamentos comuns da classe abstrata `Cliente`, especializando-se com seus próprios atributos (CPF, CNPJ).

- **Polimorfismo:** Permite que objetos de diferentes classes respondam à mesma mensagem de maneiras distintas. Isso é visto principalmente em dois pontos:
    - **Através de Interfaces:** A classe `Pedido` manipula um objeto do tipo `IPagamento`. Em tempo de execução, este objeto pode ser uma instância de `PagamentoCartaoCredito` ou `PagamentoBoleto`. Ao chamar o método `processarPagamento()`, o comportamento correto é executado dinamicamente, sem que a classe `Pedido` precise conhecer os detalhes de cada tipo de pagamento.
    - **Através de Herança:** Uma variável do tipo `Cliente` pode referenciar um objeto `ClientePF` ou `ClientePJ`. A chamada ao método `getIdentificadorUnico()` executará a implementação específica da subclasse, retornando o CPF ou o CNPJ conforme o tipo real do objeto.

- **Interfaces:** `IPagamento` define um contrato obrigatório para todas as classes de pagamento, garantindo que qualquer método de pagamento terá a funcionalidade `processarPagamento()`.

- **Composição:** O `Pedido` é composto por uma lista de `ItemPedido`, associado a um `Cliente` e a uma estratégia de `IPagamento`.

- **Enumerações (Enums):** As classes `StatusPedido` e `StatusPagamento` garantem um controle de estado robusto, seguro e legível em todo o fluxo do sistema.
