import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CitaDAO citaDAO = new CitaDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú de Citas ---");
            System.out.println("1. Agendar cita");
            System.out.println("2. Ver todas las citas");
            System.out.println("3. Editar cita");
            System.out.println("4. Eliminar cita");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agendarCita(citaDAO, scanner);
                    break;
                case 2:
                    verTodasLasCitas(citaDAO);
                    break;
                case 3:
                    editarCita(citaDAO, scanner);
                    break;
                case 4:
                    eliminarCita(citaDAO, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agendarCita(CitaDAO citaDAO, Scanner scanner) {
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();

        System.out.print("Fecha de la cita (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        System.out.print("Hora de la cita (HH:MM): ");
        String hora = scanner.nextLine();

        System.out.print("Motivo de la cita: ");
        String motivo = scanner.nextLine();

        Cita nuevaCita = new Cita(nombre, fecha, hora, motivo);
        citaDAO.insertarCita(nuevaCita);
        System.out.println("Cita agendada con éxito!");
    }

    private static void verTodasLasCitas(CitaDAO citaDAO) {
        List<Cita> citas = citaDAO.obtenerTodasLasCitas();
        for (Cita cita : citas) {
            System.out.println("ID: " + cita.getId());
            System.out.println("Paciente: " + cita.getNombrePaciente());
            System.out.println("Fecha: " + cita.getFechaCita());
            System.out.println("Hora: " + cita.getHoraCita());
            System.out.println("Motivo: " + cita.getMotivo());
            System.out.println("-----------------------------");
        }
    }

    private static void editarCita(CitaDAO citaDAO, Scanner scanner) {
        System.out.print("Ingrese el ID de la cita a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Obtener la cita actual
        Cita cita = citaDAO.obtenerCitaPorId(id);
        if (cita == null) {
            System.out.println("No se encontró una cita con el ID proporcionado.");
            return;
        }

        System.out.println("Editando la cita: " + cita.getNombrePaciente());

        // Solicitar nuevos datos
        System.out.print("Nuevo nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva fecha de la cita (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Nueva hora de la cita (HH:MM): ");
        String hora = scanner.nextLine();
        System.out.print("Nuevo motivo de la cita: ");
        String motivo = scanner.nextLine();

        // Actualizar la cita
        cita.setNombrePaciente(nombre);
        cita.setFechaCita(fecha);
        cita.setHoraCita(hora);
        cita.setMotivo(motivo);
        citaDAO.editarCita(cita);

        System.out.println("Cita actualizada con éxito!");
    }

    private static void eliminarCita(CitaDAO citaDAO, Scanner scanner) {
        System.out.print("Ingrese el ID de la cita a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Confirmar eliminación
        System.out.print("¿Está seguro de que desea eliminar esta cita? (s/n): ");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            citaDAO.eliminarCita(id);
            System.out.println("Cita eliminada con éxito!");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }
}
