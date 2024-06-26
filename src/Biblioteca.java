import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        if (buscarLivroPorIsbn(livro.getIsbn()) != null) {
            System.out.println("Erro: Já existe um livro cadastrado com este ISBN.");
            return;
        }
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (buscarUsuarioPorId(usuario.getId()) != null) {
            System.out.println("Erro: Já existe um usuário cadastrado com este ID.");
            return;
        }
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void emprestarLivro(String isbn, String userId) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorId(userId);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Livro não está disponível para empréstimo.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(livro, usuario);
        emprestimos.add(emprestimo);
        livro.setDisponivel(false);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void devolverLivro(String isbn) {
        Emprestimo emprestimo = buscarEmprestimoPorIsbn(isbn);
        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }

        emprestimo.getLivro().setDisponivel(true);
        emprestimos.remove(emprestimo);
        System.out.println("Devolução realizada com sucesso!");
    }

    public void consultarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public void consultarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    private Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    private Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    private Emprestimo buscarEmprestimoPorIsbn(String isbn) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getIsbn().equals(isbn)) {
                return emprestimo;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Empréstimo de Livro");
            System.out.println("4. Devolução de Livro");
            System.out.println("5. Consultar Livros");
            System.out.println("6. Consultar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Categoria (1 - Técnico, 2 - Literatura, 3 - Lazer): ");
                    int categoria = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    if (categoria < 1 || categoria > 3) {
                        System.out.println("Categoria inválida.");
                        break;
                    }
                    Livro livro = new Livro(titulo, autor, isbn, categoria);
                    biblioteca.cadastrarLivro(livro);
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    Usuario usuario = new Usuario(nome, id);
                    biblioteca.cadastrarUsuario(usuario);
                    break;
                case 3:
                    System.out.print("ISBN do Livro: ");
                    isbn = scanner.nextLine();
                    System.out.print("ID do Usuário: ");
                    id = scanner.nextLine();
                    biblioteca.emprestarLivro(isbn, id);
                    break;
                case 4:
                    System.out.print("ISBN do Livro: ");
                    isbn = scanner.nextLine();
                    biblioteca.devolverLivro(isbn);
                    break;
                case 5:
                    biblioteca.consultarLivros();
                    break;
                case 6:
                    biblioteca.consultarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
