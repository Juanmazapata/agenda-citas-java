import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Validaciones {
    public static boolean validarFecha(String fecha) {
        // Expresión regular para validar el formato YYYY-MM-DD
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        if (!Pattern.matches(regex, fecha)) {
            return false;
        }

        // Verificar si la fecha es válida
        try {
            LocalDate.parse(fecha, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public static boolean validarHora(String hora) {
        // Expresión regular para validar el formato HH:MM
        String regex = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        return Pattern.matches(regex, hora);
    }

    public static boolean validarTexto(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
}
