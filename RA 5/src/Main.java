import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> usuarios = GestorUsuarios.cargar();

        int opcion;

        do {

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar por DNI");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    usuarios.add(
                            new Usuario(nombre, edad, correo,
                                    dni, telefono)
                    );

                    GestorUsuarios.guardar(usuarios);

                    System.out.println("Usuario añadido.");
                    break;

                case 2:

                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios.");
                    } else {
                        for (Usuario u : usuarios) {
                            System.out.println(u);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Introduce DNI: ");
                    String dniBuscar = sc.nextLine();

                    boolean encontrado = false;

                    for (Usuario u : usuarios) {
                        if (u.getDni().equalsIgnoreCase(dniBuscar)) {
                            System.out.println(u);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Usuario no encontrado.");
                    }

                    break;

                case 4:

                    System.out.print("DNI del usuario a eliminar: ");
                    String dniEliminar = sc.nextLine();

                    usuarios.removeIf(
                            u -> u.getDni().equalsIgnoreCase(dniEliminar)
                    );

                    GestorUsuarios.guardar(usuarios);

                    System.out.println("Operación realizada.");

                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 5);

        sc.close();
    }
}