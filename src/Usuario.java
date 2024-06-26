public class Usuario {
    private String nome;
    private String id;

    public Usuario(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuário:\n" +
                "  Nome: " + nome + "\n" +
                "  ID: " + id + "\n";
    }
}
