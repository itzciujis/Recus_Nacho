import java.io.*;
import java.util.ArrayList;

public class GestorUsuarios {

    private static final String ARCHIVO = "usuarios.dat";

    public static void guardar(ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            oos.writeObject(usuarios);

        } catch (IOException e) {
            System.out.println("Error al guardar usuarios.");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Usuario> cargar() {

        File fichero = new File(ARCHIVO);

        if (!fichero.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(ARCHIVO))) {

            return (ArrayList<Usuario>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar usuarios.");
            return new ArrayList<>();
        }
    }
}