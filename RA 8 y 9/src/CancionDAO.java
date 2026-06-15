import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CancionDAO {

    public void mostrarCanciones() {

        String sql = "SELECT c.id_cancion, c.titulo, c.duracion, a.titulo AS album, ar.nombre AS artista " +
                "FROM cancion c " +
                "JOIN album a ON c.id_album = a.id_album " +
                "JOIN artista ar ON a.id_artista = ar.id_artista";

        try (Connection con = ConexionBD.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id_cancion") + " - " +
                                rs.getString("titulo") + " - " +
                                rs.getInt("duracion") + "s - " +
                                rs.getString("album") + " - " +
                                rs.getString("artista")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarPorArtista(String artista) {

        String sql = "SELECT c.titulo, c.duracion, a.titulo AS album " +
                "FROM cancion c " +
                "JOIN album a ON c.id_album = a.id_album " +
                "JOIN artista ar ON a.id_artista = ar.id_artista " +
                "WHERE ar.nombre = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, artista);
            ResultSet rs = ps.executeQuery();

            boolean encontrado = false;

            while (rs.next()) {
                encontrado = true;
                System.out.println(
                        rs.getString("titulo") + " - " +
                                rs.getInt("duracion") + "s - " +
                                rs.getString("album")
                );
            }

            if (!encontrado) {
                System.out.println("No hay canciones de ese artista");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarCancion(String titulo, int duracion, int idAlbum) {

        String sql = "INSERT INTO cancion (titulo, duracion, id_album) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setInt(2, duracion);
            ps.setInt(3, idAlbum);

            ps.executeUpdate();

            System.out.println("Canción insertada correctamente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}