import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionException;


public class CitaDAO {
    public void insertarCita(Cita cita) {
        String sql = "INSERT INTO citas (nombre_paciente, fecha_cita, hora_cita, motivo) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cita.getNombrePaciente());
            pstmt.setString(2, cita.getFechaCita());
            pstmt.setString(3, cita.getHoraCita());
            pstmt.setString(4, cita.getMotivo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cita> obtenerTodasLasCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try (Connection conn = ConexionBd.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cita cita = new Cita(
                        rs.getString("nombre_paciente"),
                        rs.getString("fecha_cita"),
                        rs.getString("hora_cita"),
                        rs.getString("motivo")
                );
                cita.setId (rs.getInt("id"));
                citas.add(cita);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    // Método para obtener una cita por su ID
    public Cita obtenerCitaPorId(int id) {
        String sql = "SELECT * FROM citas WHERE id = ?";
        try (Connection conn = ConexionBd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Cita cita = new Cita(
                            rs.getString("nombre_paciente"),
                            rs.getString("fecha_cita"),
                            rs.getString("hora_cita"),
                            rs.getString("motivo")
                    );
                    cita.setId(rs.getInt("id"));
                    return cita;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editarCita(Cita cita) {
        String sql = "UPDATE citas SET nombre_paciente = ?, fecha_cita = ?, hora_cita = ?, motivo = ? WHERE id = ?";
        try (Connection conn = ConexionBd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cita.getNombrePaciente());
            pstmt.setString(2, cita.getFechaCita());
            pstmt.setString(3, cita.getHoraCita());
            pstmt.setString(4, cita.getMotivo());
            pstmt.setInt(5, cita.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCita(int id) {
        String sql = "DELETE FROM citas WHERE id = ?";
        try (Connection conn = ConexionBd.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
