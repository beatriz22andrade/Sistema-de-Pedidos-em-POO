package br.ufg.sistemapedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct; // Importante
import java.io.BufferedReader;
import java.io.InputStreamReader; // Trocado de FileReader
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SistemaPedidos {

    private final ResourceLoader resourceLoader;
    private final List<Produto> produtosEmMemoria = new ArrayList<>();

    // O Spring injeta o ResourceLoader
    public SistemaPedidos(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) {
        SpringApplication.run(SistemaPedidos.class, args);
    }

    // Este método roda UMA VEZ quando a aplicação inicia
    @PostConstruct
    public void carregarProdutosDoCsv() {
        try {
            // 1. Carrega o arquivo do classpath (src/main/resources)
            Resource resource = resourceLoader.getResource("classpath:produtos.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            // Pula o cabeçalho
            String linha = reader.readLine();

            while ((linha = reader.readLine()) != null) {
                String colunas[] = linha.split(",");

                // IMPORTANTE: Verifique se o ID na sua classe Produto é String
                // Se for Long, use Long.parseLong(colunas[0])
                String id = colunas[0]; 
                String nome = colunas[1];
                double preco = Double.parseDouble(colunas[2]);
                String descricao = colunas[3];
                int estoque = Integer.parseInt(colunas[4]);

                // Adiciona na lista em memória
                produtosEmMemoria.add(new Produto(id, nome, preco, descricao, estoque));
            }
            reader.close();
            System.out.println(">>> PRODUTOS CARREGADOS DO CSV: " + produtosEmMemoria.size());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(">>> ERRO AO CARREGAR CSV <<<");
        }
    }

    // Agora, o endpoint é super rápido!
    @GetMapping("/produtos")
    public List<Produto> produtos() {
        // 2. Apenas retorna a lista que já está na memória
        return produtosEmMemoria;
    }
}