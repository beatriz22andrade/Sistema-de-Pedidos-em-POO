package Pratica;

import java.time.LocalDate;

public class SistemaPedidos {
    public static void main(String[] args) {
        
        Produto teclado = new Produto("Teclado Mecânico", 350.00, 10);
        Produto mouse = new Produto("Mouse Gamer", 150.00, 20);

        Cliente clientePF = new ClientePF("João Silva", "joao@email.com", "111.222.333-44");
        Cliente clientePJ = new ClientePJ("Tech Corp", "contato@techcorp.com", "55.666.777/0001-88");

        IPagamento cartao = new PagamentoCartaoCredito("1234-5678-9012-3456");
        IPagamento boleto = new PagamentoBoleto("87654123 12345678 90123456 7890");

        // Teste 1: Cartão com valor alto (REPROVADO)
        System.out.println("\n--- Teste 1: Cartão, Valor R$ 650.00 ---");
        Pedido pedido1 = new Pedido(LocalDate.now(), clientePF, cartao);
        pedido1.adicionarItem(teclado, 1);
        pedido1.adicionarItem(mouse, 2);
        
        double totalPedido1 = pedido1.calcularTotal();
        boolean foiAprovado1 = pedido1.getMetodoPagamento().processarPagamento(totalPedido1);
        System.out.println("Status final do teste: " + (foiAprovado1 ? "APROVADO" : "REPROVADO"));


        // Teste 2: Boleto com valor alto (REPROVADO)
        System.out.println("\n--- Teste 2: Boleto, Valor R$ 3500.00 ---");
        Pedido pedido2 = new Pedido(LocalDate.now(), clientePJ, boleto);
        pedido2.adicionarItem(teclado, 10);

        double totalPedido2 = pedido2.calcularTotal();
        boolean foiAprovado2 = pedido2.getMetodoPagamento().processarPagamento(totalPedido2);
        System.out.println("Status final do teste: " + (foiAprovado2 ? "APROVADO" : "REPROVADO"));


        // Teste 3: Cartão com valor baixo (APROVADO)
        System.out.println("\n--- Teste 3: Cartão, Valor R$ 150.00 ---");
        Pedido pedido3 = new Pedido(LocalDate.now(), clientePF, cartao);
        pedido3.adicionarItem(mouse, 1);

        double totalPedido3 = pedido3.calcularTotal();
        boolean foiAprovado3 = pedido3.getMetodoPagamento().processarPagamento(totalPedido3);
        System.out.println("Status final do teste: " + (foiAprovado3 ? "APROVADO" : "REPROVADO"));


        // Teste 4: Boleto com valor médio (APROVADO)
        System.out.println("\n--- Teste 4: Boleto, Valor R$ 700.00 ---");
        Pedido pedido4 = new Pedido(LocalDate.now(), clientePJ, boleto);
        pedido4.adicionarItem(teclado, 2);

        double totalPedido4 = pedido4.calcularTotal();
        boolean foiAprovado4 = pedido4.getMetodoPagamento().processarPagamento(totalPedido4);
        System.out.println("Status final do teste: " + (foiAprovado4 ? "APROVADO" : "REPROVADO"));

        System.out.println("\n### TESTES FINALIZADOS ###");

    }
}
