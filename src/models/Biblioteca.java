package models;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList();
    private List<Cliente> clientes = new ArrayList();
    private List<Emprestimo> emprestimos = new ArrayList();
    private List<Multa> multas = new ArrayList();

    public Biblioteca() {
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void cadastrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void listarClientes() {
        System.out.println("Clientes cadastrados:");
        Iterator var1 = this.clientes.iterator();

        while(var1.hasNext()) {
            Cliente cliente = (Cliente)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = cliente.getId();
            var10000.println("ID: " + var10001 + " - Nome: " + cliente.getNome() + " - Email: " + cliente.getEmail());
        }

    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros dispon\u00edveis para empr\u00e9stimo:");
        Iterator var1 = this.livros.iterator();

        while(var1.hasNext()) {
            Livro livro = (Livro)var1.next();
            if (livro.isDisponivel()) {
                PrintStream var10000 = System.out;
                int var10001 = livro.getId();
                var10000.println("ID: " + var10001 + " - T\u00edtulo: " + livro.getTitulo() + " - Autor: " + livro.getAutor().getNome());
            }
        }

    }

    public void realizarEmprestimo(int livroId, int clienteId) {
        Livro livroSelecionado = null;
        Cliente clienteSelecionado = null;
        Iterator var5 = this.livros.iterator();

        while(var5.hasNext()) {
            Livro livro = (Livro)var5.next();
            if (livro.getId() == livroId && livro.isDisponivel()) {
                livroSelecionado = livro;
                break;
            }
        }

        var5 = this.clientes.iterator();

        while(var5.hasNext()) {
            Cliente cliente = (Cliente)var5.next();
            if (cliente.getId() == clienteId) {
                clienteSelecionado = cliente;
                break;
            }
        }

        if (livroSelecionado != null && clienteSelecionado != null) {
            livroSelecionado.emprestar();
            Emprestimo emprestimo = new Emprestimo(livroSelecionado, clienteSelecionado);
            this.emprestimos.add(emprestimo);
            PrintStream var10000 = System.out;
            String var10001 = clienteSelecionado.getNome();
            var10000.println("Empr\u00e9stimo realizado com sucesso! " + var10001 + " emprestou o livro '" + livroSelecionado.getTitulo() + "'.");
        } else {
            System.out.println("Livro ou cliente n\u00e3o encontrado ou livro indispon\u00edvel.");
        }

    }

    public void listarEmprestimos() {
        System.out.println("Hist\u00f3rico de empr\u00e9stimos:");
        Iterator var1 = this.emprestimos.iterator();

        while(var1.hasNext()) {
            Emprestimo emprestimo = (Emprestimo)var1.next();
            System.out.println(emprestimo);
        }

    }

    public void adicionarMulta(int id_cliente, String descricao, float valor) {
        Cliente cliente = this.encontrarClientePorId(id_cliente);
        if (cliente != null) {
            Multa multa = new Multa(this.multas.size() + 1, id_cliente, descricao, valor);
            this.multas.add(multa);
            System.out.println("Multa adicionada com sucesso:");
            PrintStream var10000 = System.out;
            int var10001 = multa.getId_multa();
            var10000.println("ID da Multa: " + var10001);
            var10000 = System.out;
            var10001 = multa.getId_cliente();
            var10000.println("ID do Cliente: " + var10001);
            var10000 = System.out;
            String var6 = multa.getDescricao();
            var10000.println("Descri\u00e7\u00e3o: " + var6);
            var10000 = System.out;
            var6 = String.format("%.2f", multa.getValor());
            var10000.println("Valor: R$ " + var6);
            System.out.println("Status: " + (multa.isPago() ? "Pago" : "N\u00e3o pago"));
        } else {
            System.out.println("Cliente n\u00e3o encontrado com o ID: " + id_cliente);
        }

    }

    private Cliente encontrarClientePorId(int id) {
        Iterator var2 = this.clientes.iterator();

        while(var2.hasNext()) {
            Cliente c = (Cliente)var2.next();
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    public void listarMultas() {
        System.out.println("Multas registradas:");
        Iterator var1 = this.multas.iterator();

        while(var1.hasNext()) {
            Multa multa = (Multa)var1.next();
            PrintStream var10000 = System.out;
            int var10001 = multa.getId_multa();
            var10000.println("ID da Multa: " + var10001);
            var10000 = System.out;
            var10001 = multa.getId_cliente();
            var10000.println("ID do Cliente: " + var10001);
            var10000 = System.out;
            String var3 = multa.getDescricao();
            var10000.println("Descri\u00e7\u00e3o: " + var3);
            var10000 = System.out;
            var3 = String.format("%.2f", multa.getValor());
            var10000.println("Valor: R$ " + var3);
            System.out.println("Status: " + (multa.isPago() ? "Pago" : "N\u00e3o pago"));
        }

    }
}
