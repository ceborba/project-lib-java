package models;

import java.time.LocalDateTime;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDateTime.now();
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDateTime.now();
        this.livro.devolver();
    }

    public Livro getLivro() {
        return this.livro;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LocalDateTime getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return this.dataDevolucao;
    }

    public String toString() {
        String var10000 = this.livro.getTitulo();
        return "Livro: " + var10000 + ", Cliente: " + this.cliente.getNome() + ", Data do Empr\u00e9stimo: " + this.dataEmprestimo + (this.dataDevolucao != null ? ", Data de Devolu\u00e7\u00e3o: " + this.dataDevolucao : "");
    }
}
