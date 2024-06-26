import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(livro.getPrazoDevolucao());
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public String toString() {
        return "Empréstimo:\n" +
                "  Livro:\n" + livro.toString() +
                "  Usuário:\n" + usuario.toString() +
                "  Data de Empréstimo: " + dataEmprestimo + "\n" +
                "  Data de Devolução: " + dataDevolucao + "\n";
    }
}
