import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CancionDAO dao = new CancionDAO();

        dao.mostrarCanciones();

        System.out.println("Introduce artista:");
        String artista = sc.nextLine();
        dao.buscarPorArtista(artista);

        System.out.println("Nueva canción:");
        String titulo = sc.nextLine();
        int duracion = Integer.parseInt(sc.nextLine());
        int idAlbum = Integer.parseInt(sc.nextLine());

        dao.insertarCancion(titulo, duracion, idAlbum);

        System.out.println("Comprobación:");
        artista = sc.nextLine();
        dao.buscarPorArtista(artista);

        sc.close();
    }
}