
package models;

public class Cliente {
    private int id;
    private String nome;
    private String dataNascimento;
    private String email;

    public Cliente(int id, String nome, String dataNascimento, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return this.id;
    }
}
