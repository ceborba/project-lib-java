package models;

public class Autor {
    private int id;
    private String nome;
    private String dataNascimento;

    public Autor(int id, String nome, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return this.nome;
    }
}
