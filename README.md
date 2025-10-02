# 🛒 Sistema de Pedidos - POO

Esta atividade foi desenvolvida na disciplina de **Programação Orientada a Objetos (POO)**.  
O objetivo foi praticar os conceitos fundamentais de **abstração, herança, e interfaces**, através da implementação de um **sistema de pedidos**.

---

## 🚀 Funcionalidades
- Cadastro de clientes (Pessoa Física e Pessoa Jurídica).
- Criação de pedidos e associação de itens.
- Implementação de uma **interface de pagamento**, permitindo diferentes estratégias (ex: cartão e boleto).
- Uso de **classe abstrata `Cliente`** como base para `ClientePF` e `ClientePJ`.
- Demonstração prática dos princípios de **POO**.

---

## 📌 Conceitos de POO aplicados

- **Abstração:** Classe `Cliente` como modelo genérico.  
- **Herança:** `ClientePF` e `ClientePJ` herdam de `Cliente`.   
- **Interfaces:** `IPagamento` define o contrato para os métodos de pagamento.  
- **Composição:** Pedido composto por itens (`ItemPedido`) e associado a um cliente.  

---
