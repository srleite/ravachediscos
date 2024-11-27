import java.util.*;

public class Main {
    public static void main(String[] args) {
        CatalogoMusical catalogo = new CatalogoMusical();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Catálogo de Discos Musicais ---");
            System.out.println("1. Cadastrar novo disco");
            System.out.println("2. Cadastrar novo artista e associar a um disco");
            System.out.println("3. Listar discos disponíveis");
            System.out.println("4. Editar disco ou artista");
            System.out.println("5. Remover disco ou artista");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarDisco(scanner, catalogo);
                case 2 -> cadastrarArtistaEmDisco(scanner, catalogo);
                case 3 -> catalogo.listarDiscos();
                case 4 -> editarEntidade(scanner, catalogo);
                case 5 -> removerEntidade(scanner, catalogo);
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void cadastrarDisco(Scanner scanner, CatalogoMusical catalogo) {
        System.out.print("Título do disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite as faixas: ");
        String[] arrayFaixas = scanner.nextLine().split(",");
        List<String> faixas = new ArrayList<>(Arrays.asList(arrayFaixas));

        Disco novoDisco = new Disco(titulo, ano, faixas);
        catalogo.adicionarDisco(novoDisco);
        System.out.println("Disco cadastrado com sucesso!");
    }

    private static void cadastrarArtistaEmDisco(Scanner scanner, CatalogoMusical catalogo) {
        if (catalogo.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado. Cadastre um disco primeiro.");
            return;
        }

        System.out.print("Nome do artista: ");
        String nome = scanner.nextLine();
        System.out.print("Gênero musical: ");
        String genero = scanner.nextLine();

        System.out.println("Escolha um disco para associar o artista:");
        List<Disco> discos = catalogo.getDiscos();
        for (int i = 0; i < discos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, discos.get(i).getTitulo());
        }

        int escolhaDisco = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolhaDisco >= 0 && escolhaDisco < discos.size()) {
            Artista novoArtista = new Artista(nome, genero);
            catalogo.adicionarArtista(novoArtista);
            discos.get(escolhaDisco).setArtista(novoArtista);
            System.out.println("Artista associado ao disco com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void editarEntidade(Scanner scanner, CatalogoMusical catalogo) {
        System.out.println("\n--- Editar Entidade ---");
        System.out.println("1. Editar Disco");
        System.out.println("2. Editar Artista");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) {
            editarDisco(scanner, catalogo);
        } else if (escolha == 2) {
            editarArtista(scanner, catalogo);
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void editarDisco(Scanner scanner, CatalogoMusical catalogo) {
        if (catalogo.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }

        System.out.println("Escolha o disco para editar:");
        List<Disco> discos = catalogo.getDiscos();
        for (int i = 0; i < discos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, discos.get(i).getTitulo());
        }

        int escolhaDisco = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolhaDisco >= 0 && escolhaDisco < discos.size()) {
            Disco disco = discos.get(escolhaDisco);
            System.out.print("Novo título: ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isBlank()) disco.setTitulo(novoTitulo);

            System.out.print("Novo ano: ");
            int novoAno = scanner.nextInt();
            scanner.nextLine();
            if (novoAno > 0) disco.setAno(novoAno);

            System.out.println("Disco editado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void editarArtista(Scanner scanner, CatalogoMusical catalogo) {
        if (catalogo.getArtistas().isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
            return;
        }

        System.out.println("Escolha o artista para editar:");
        List<Artista> artistas = catalogo.getArtistas();
        for (int i = 0; i < artistas.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, artistas.get(i).getNome());
        }

        int escolhaArtista = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolhaArtista >= 0 && escolhaArtista < artistas.size()) {
            Artista artista = artistas.get(escolhaArtista);
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isBlank()) artista.setNome(novoNome);

            System.out.print("Novo gênero: ");
            String novoGenero = scanner.nextLine();
            if (!novoGenero.isBlank()) artista.setGenero(novoGenero);

            System.out.println("Artista editado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void removerEntidade(Scanner scanner, CatalogoMusical catalogo) {
        System.out.println("\n--- Remover Entidade ---");
        System.out.println("1. Remover Disco");
        System.out.println("2. Remover Artista");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) {
            removerDisco(scanner, catalogo);
        } else if (escolha == 2) {
            removerArtista(scanner, catalogo);
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void removerDisco(Scanner scanner, CatalogoMusical catalogo) {
        if (catalogo.getDiscos().isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }

        System.out.println("Escolha o disco para remover:");
        List<Disco> discos = catalogo.getDiscos();
        for (int i = 0; i < discos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, discos.get(i).getTitulo());
        }

        int escolhaDisco = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolhaDisco >= 0 && escolhaDisco < discos.size()) {
            Disco disco = discos.remove(escolhaDisco);
            System.out.printf("Disco '%s' removido com sucesso!\n", disco.getTitulo());
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void removerArtista(Scanner scanner, CatalogoMusical catalogo) {
        if (catalogo.getArtistas().isEmpty()) {
            System.out.println("Nenhum artista cadastrado.");
            return;
        }

        System.out.println("Escolha o artista para remover:");
        List<Artista> artistas = catalogo.getArtistas();
        for (int i = 0; i < artistas.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, artistas.get(i).getNome());
        }

        int escolhaArtista = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolhaArtista >= 0 && escolhaArtista < artistas.size()) {
            Artista artista = artistas.remove(escolhaArtista);
            System.out.printf("Artista '%s' removido com sucesso!\n", artista.getNome());
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
