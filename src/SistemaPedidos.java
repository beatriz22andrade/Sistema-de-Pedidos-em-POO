package Pratica;

import java.time.LocalDate;

public class SistemaPedidos {

    public static void main(String[] args) {

        // --- INICIALIZAÇÃO DE DADOS ---
        // Produtos
        Produto teclado = new Produto("Teclado Mecânico", 350.00, 10, "PROD-001");
        Produto mouse = new Produto("Mouse Gamer", 150.00, 20, "PROD-002");
        Produto monitor = new Produto("Monitor Ultrawide", 4800.00, 5, "PROD-003");

        // Clientes
        Cliente clientePF = new ClientePF("João Silva", "joao@email.com", "111.222.333-44", "CLI-PF-01", "11987654321", LocalDate.of(1990, 5, 20));
        Cliente clientePJ = new ClientePJ("Tech Corp", "contato@techcorp.com", "55.666.777/0001-88", "CLI-PJ-01", "1123456789", "Tech Corporation LTDA");

        // Métodos de Pagamento
        IPagamento cartao = new PagamentoCartaoCredito("1234-5678-9012-3456", "João Silva", LocalDate.of(2028, 12, 31));
        IPagamento boleto = new PagamentoBoleto("8765412312345678901234567890", 0, LocalDate.now().plusDays(5));


        // --- EXECUÇÃO DOS TESTES ---

        // Teste 1: Pagamento com Cartão de Crédito APROVADO (valor < 5000)
        System.out.println("--- Teste 1: Cartão de Crédito - Pedido APROVADO ---");
        Pedido pedido1 = new Pedido(clientePF);
        pedido1.adicionarItem(teclado, 2); // 2 * 350 = 700
        pedido1.adicionarItem(mouse, 1);   // 1 * 150 = 150
        pedido1.setMetodoPagamento(cartao);
        pedido1.confirmarPedido();
        System.out.println("Status final do Pedido 1: " + pedido1.getStatusPedido());
        System.out.println("------------------------------------------------------\n");


        // Teste 2: Pagamento com Cartão de Crédito RECUSADO (valor > 5000)
        System.out.println("--- Teste 2: Cartão de Crédito - Pedido RECUSADO ---");
        Pedido pedido2 = new Pedido(clientePJ);
        pedido2.adicionarItem(monitor, 1); // 1 * 4800 = 4800
        pedido2.adicionarItem(teclado, 2); // 2 * 350  = 700
        // Total = 5500.00
        pedido2.setMetodoPagamento(cartao);
        pedido2.confirmarPedido();
        System.out.println("Status final do Pedido 2: " + pedido2.getStatusPedido());
        System.out.println("------------------------------------------------------\n");


        // Teste 3: Pagamento com Boleto (sempre aprovado)
        System.out.println("--- Teste 3: Boleto Bancário - Pedido APROVADO ---");
        Pedido pedido3 = new Pedido(clientePJ);
        pedido3.adicionarItem(monitor, 2); // Total 9600.00
        pedido3.setMetodoPagamento(boleto);
        pedido3.confirmarPedido();
        System.out.println("Status final do Pedido 3: " + pedido3.getStatusPedido());
        System.out.println("------------------------------------------------------\n");
        
        
        // Teste 4: Remoção de Item antes de confirmar o pedido
        System.out.println("--- Teste 4: Remoção de Item e Pedido APROVADO ---");
        Pedido pedido4 = new Pedido(clientePF);
        pedido4.adicionarItem(monitor, 1); // Adiciona item caro
        pedido4.adicionarItem(teclado, 1);
        System.out.println("Total antes da remoção: R$" + pedido4.calcularTotal());
        
        pedido4.removerItem(monitor); // Remove o item caro
        System.out.println("Total após a remoção: R$" + pedido4.calcularTotal());
        
        pedido4.setMetodoPagamento(cartao);
        pedido4.confirmarPedido(); // Agora o valor é baixo e será aprovado
        System.out.println("Status final do Pedido 4: " + pedido4.getStatusPedido());
        System.out.println("------------------------------------------------------\n");

        System.out.println("### TESTES FINALIZADOS ###");
    }
}