package models;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Autor autor1 = new Autor(1, "J.K. Rowling", "31/07/1965");
        Autor autor2 = new Autor(2, "J.R.R. Tolkien", "03/01/1892");
        Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "O Senhor dos An\u00e9is", autor2);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        Cliente cliente1 = new Cliente(1, "Carlos Borba", "13/07/2000", "carlos.borba@example.com");
        Cliente cliente2 = new Cliente(2, "Ana Cordeiro", "14/10/2001", "ana.carolina@example.com");
        biblioteca.cadastrarCliente(cliente1);
        biblioteca.cadastrarCliente(cliente2);

        while(true) {
            System.out.println("\n1. Lista de Livros Dispon\u00edveis");
            System.out.println("2. Realizar Empr\u00e9stimo");
            System.out.println("3. Lista de Clientes");
            System.out.println("4. Lista de Hist\u00f3rico de Empr\u00e9stimos");
            System.out.println("5. Adicionar Multa");
            System.out.println("6. Listar Multas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma op\u00e7\u00e3o: ");
            int opcao = Integer.parseInt(scanner.nextLine());
            int clienteId;
            switch (opcao) {
                case 1:
                    biblioteca.listarLivrosDisponiveis();
                    break;
                case 2:
                    try {
                        System.out.print("Digite o ID do livro que deseja emprestar: ");
                        int livroId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o ID do cliente: ");
                        clienteId = Integer.parseInt(scanner.nextLine());
                        biblioteca.realizarEmprestimo(livroId, clienteId);
                    } catch (NumberFormatException var14) {
                        System.out.println("Por favor, insira um ID v\u00e1lido.");
                    }
                    break;
                case 3:
                    biblioteca.listarClientes();
                    break;
                case 4:
                    biblioteca.listarEmprestimos();
                    break;
                case 5:
                    try {
                        System.out.print("Digite o ID do cliente que receber\u00e1 a multa: ");
                        clienteId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a descri\u00e7\u00e3o da multa: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Digite o valor da multa: ");
                        float valor = Float.parseFloat(scanner.nextLine());
                        biblioteca.adicionarMulta(clienteId, descricao, valor);
                    } catch (NumberFormatException var13) {
                        System.out.println("Por favor, insira um valor v\u00e1lido.");
                    }
                    break;
                case 6:
                    biblioteca.listarMultas();
                    break;
                case 7:
                    System.out.println("Sistema encerrado. Obrigado por utilizar a biblioteca!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Op\u00e7\u00e3o inv\u00e1lida.");
            }
        }
    }
}
