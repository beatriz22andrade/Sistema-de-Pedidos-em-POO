# 🛒 Sistema de Pedidos - POO

Esta atividade foi desenvolvida na disciplina de **Programação Orientada a Objetos (POO)**.
O objetivo foi praticar os conceitos fundamentais de **abstração, herança, e interfaces**, através da implementação de um **sistema de pedidos**.

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

- **Abstração:** Classe `Cliente` como modelo genérico, escondendo detalhes de implementação.
- **Herança:** `ClientePF` e `ClientePJ` herdam atributos e métodos de `Cliente`.
- **Interfaces:** `IPagamento` define um contrato que `PagamentoCartaoCredito` e `PagamentoBoleto` devem seguir para processar um pagamento.
- **Composição:** O `Pedido` é composto por uma lista de `ItemPedido`, associado a um `Cliente` e a uma estratégia de `IPagamento`.
- **Enumerações (Enums):** Classes `StatusPedido` e `StatusPagamento` foram adicionadas para garantir um controle de estado robusto, seguro e legível em todo o fluxo do sistema.
