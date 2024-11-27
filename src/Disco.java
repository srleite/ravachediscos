import java.util.List;

public class Disco {
    private String titulo;
    private int ano;
    private List<String> faixas;
    private Artista artista;

    public Disco(String titulo, int ano, List<String> faixas) {
        this.titulo = titulo;
        this.ano = ano;
        this.faixas = faixas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<String> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<String> faixas) {
        this.faixas = faixas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Ano: %d | Artista: %s | Faixas: %s",
                titulo, ano, artista != null ? artista.getNome() : "Desconhecido", faixas);
    }
}