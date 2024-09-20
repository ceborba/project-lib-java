// Source code is decompiled from a .class file using FernFlower decompiler.
package models;

public class Multa {
    private int id_multa;
    private int id_cliente;
    private String descricao;
    private float valor;
    private boolean pago;

    public Multa(int id_multa, int id_cliente, String descricao, float valor) {
        this.id_multa = id_multa;
        this.id_cliente = id_cliente;
        this.descricao = descricao;
        this.valor = valor;
        this.pago = false;
    }

    public Multa() {
    }

    public int getId_multa() {
        return this.id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public int getId_cliente() {
        return this.id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return this.pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String toString() {
        return "Multa{id_multa=" + this.id_multa + ", id_cliente=" + this.id_cliente + ", descricao='" + this.descricao + "', valor=" + this.valor + ", pago=" + this.pago + "}";
    }
}
