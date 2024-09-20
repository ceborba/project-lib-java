
package models;

import java.time.LocalDateTime;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Livro(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = this.dataCadastro;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public void devolver() {
        this.disponivel = true;
        this.dataAtualizacao = LocalDateTime.now();
    }
}
