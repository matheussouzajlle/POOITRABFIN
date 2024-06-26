public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int categoria; // 1 - Técnico, 2 - Literatura, 3 - Lazer
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn, int categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.categoria = categoria;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getPrazoDevolucao() {
        switch (categoria) {
            case 1:
                return 7;
            case 2:
                return 14;
            case 3:
                return 30;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "Livro:\n" +
                "  Título: " + titulo + "\n" +
                "  Autor: " + autor + "\n" +
                "  ISBN: " + isbn + "\n" +
                "  Categoria: " + categoria + "\n" +
                "  Disponível: " + (disponivel ? "Sim" : "Não") + "\n";
    }
}
