import java.util.ArrayList;
import java.util.List;

public class CatalogoMusical {
    private List<Disco> discos;
    private List<Artista> artistas;

    public CatalogoMusical() {
        this.discos = new ArrayList<>();
        this.artistas = new ArrayList<>();
    }

    public void adicionarDisco(Disco disco) {
        discos.add(disco);
    }

    public void adicionarArtista(Artista artista) {
        artistas.add(artista);
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void removerDisco(Disco disco) {
        discos.remove(disco);
    }

    public void removerArtista(Artista artista) {
        artistas.remove(artista);
    }

    public void listarDiscos() {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
        } else {
            System.out.println("\n--- Lista de Discos ---");
            for (Disco disco : discos) {
                System.out.println(disco);
            }
        }
    }
}