import java.util.Random;

public class TicketGenerator {
    private static Random random = new Random();

    public static int generarTicket() {
        return random.nextInt(15000) + 1;
    }

    public static boolean validarTicket(int ticket) {
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return ticket >= min && ticket <= max;
    }
}
