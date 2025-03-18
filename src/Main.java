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
                    // Validar nombre
                    String nombre;
                    do {
                        System.out.println("Nombre del paciente: ");
                        nombre = scanner.nextLine();
                        if (!Validaciones.validarTexto(nombre)) {
                        System.out.println("Error: El nombre no puede estar vacío.");
                        }
                    } while (!Validaciones.validarTexto(nombre));

                    // Validar fecha
                    String fecha;
                    do {
                        System.out.print("Fecha de la cita (AAAA-MM-DD): ");
                        fecha = scanner.nextLine();
                        if (!Validaciones.validarFecha(fecha)) {
                            System.out.println("Error: La fecha debe estar en el formato AAAA-MM-DD y ser válida.");
                        }
                    } while (!Validaciones.validarFecha(fecha));

                    // Validar Hora
                    String hora;
                    do {
                        System.out.print("Hora de la cita (HH:MM): ");
                        hora = scanner.nextLine();
                        if (!Validaciones.validarHora(hora)) {
                            System.out.println("Error: La hora debe estar en el formato HH:MM y ser válida.");
                        }
                    } while (!Validaciones.validarHora(hora));

                    // Validar Motivo
                    String motivo;
                    do {
                        System.out.print("Motivo de la cita: ");
                        motivo = scanner.nextLine();
                        if (!Validaciones.validarTexto(motivo)) {
                            System.out.println("Error: El motivo no puede estar vacío.");
                        }
                    } while (!Validaciones.validarTexto(motivo));

                    // Crear y guardar la cita
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
