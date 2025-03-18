import java.sql.Struct;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        CitaDAO citaDAO = new CitaDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agendar cita");
            System.out.println("2. Ver todas las citas");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Fecha de la cita (AAAA-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Hora de la cita (HH:MM): ");
                    String hora = scanner.nextLine();
                    System.out.print("Motivo de la cita: ");
                    String motivo = scanner.nextLine();

                    Cita nuevaCita = new Cita(nombre, fecha, hora, motivo);
                    citaDAO.insertarCita(nuevaCita);
                    System.out.println("Cita agendada con éxito!");
                    break;

                case 2:
                    List<Cita> citas = citaDAO.obtenerTodasLasCitas();
                    for (Cita cita : citas) {
                        System.out.println("ID: " + cita.getId());
                        System.out.println("Paciente: " + cita.getNombrePaciente());
                        System.out.println("Fecha: " + cita.getFechaCita());
                        System.out.println("Hora: " + cita.getHoraCita());
                        System.out.println("Motivo: " + cita.getMotivo());
                        System.out.println("------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.print("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
