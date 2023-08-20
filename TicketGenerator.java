import java.util.Random;

/**
 * Esta clase proporciona funcionalidad para generar y validar tickets.
 */
public class TicketGenerator {
    private static Random random = new Random();

    /**
     * Genera un número de ticket aleatorio.
     *
     * @return Número de ticket generado.
     */
    public static int generarTicket() {
        return random.nextInt(15000) + 1;
    }

    /**
     * Valida si un número de ticket está dentro del rango permitido.
     *
     * @param ticket Número de ticket a validar.
     * @return true si el ticket es válido, false en caso contrario.
     */
    public static boolean validarTicket(int ticket) {
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ticket >= min && ticket <= max;
    }
}