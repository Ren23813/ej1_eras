import java.util.Scanner;

/**
 * Esta clase representa el programa principal que permite interactuar con el sistema de compra de boletos para un concierto.
 */
public class Principal {
    /** Representa al comprador actual. */
    public TicketComprador comprador = null;

    /** Scanner para la entrada del usuario. */
    private Scanner scanner = new Scanner(System.in);

    /** Representa el lugar del concierto. */
    public LugarConcierto lugar = new LugarConcierto();

    /**
     * Método principal que inicia el programa.
     * @param args Los argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.menu(principal);
    }

    /**
     * Muestra el menú de opciones y maneja la interacción del usuario.
     * @param principal La instancia de la clase Principal.
     */
    public void menu(Principal principal){
        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear usuario");
            System.out.println("2. Comprar boletos regulares");
            System.out.println("3. Verificar disponibilidad de lugar individual");
            System.out.println("4. Verificar disponibilidad de lugar total");
            System.out.println("5. Comprar boleto especial con código Fibonacci");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    principal.crearUsuario();
                    break;
                case 2:
                    principal.comprarBoletos();
                    break;
                case 3:
                    principal.verificarDisponibilidadIndividual();
                    break;
                case 4:
                    principal.verificarDisponibilidadTotal();
                    break;
                case 5:
                    principal.comprarBoletosEspecial();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    /**
     * Crea un nuevo usuario y lo almacena en la variable comprador.
     * @return El nuevo objeto TicketComprador creado.
     */
    private TicketComprador crearUsuario() {
        System.out.print("Ingrese su nombre: ");
        scanner.nextLine(); // Consumir el salto de línea pendiente
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su presupuesto máximo: ");
        int presupuesto = scanner.nextInt();
        TicketComprador comprador = new TicketComprador(nombre, email, presupuesto);
        return comprador;
    }

    /**
     * Verifica la disponibilidad de boletos para una localidad individual y muestra el resultado.
     */
    private void verificarDisponibilidadIndividual() {
        System.out.print("Ingrese el número de localidad (1, 5, 10): ");
        int localidad = scanner.nextInt();

        if (lugar.esLocalidadValida(localidad)) {
            String nombreLocalidad = obtenerNombreLocalidad(localidad);
            int boletosDisponibles = lugar.obtenerBoletosDisponibles(localidad);
            System.out.println(nombreLocalidad + ": " + boletosDisponibles + " boletos disponibles");
        } else {
            System.out.println("Localidad inválida. Por favor, ingrese una localidad válida.");
        }
    }

    /**
     * Verifica la disponibilidad de boletos para todas las localidades y muestra los resultados.
     */
    private void verificarDisponibilidadTotal() {
        System.out.println("\nDisponibilidad de boletos por localidad:");
        for (int i = 1; i <= 3; i++) {
            String nombreLocalidad = obtenerNombreLocalidad(i);
            int boletosDisponibles = lugar.obtenerBoletosDisponibles(i);
            System.out.println(nombreLocalidad + ": " + boletosDisponibles + " boletos disponibles");
        }
    }

    /**
     * Obtiene el nombre legible de una localidad según su número.
     * @param localidad El número de la localidad.
     * @return El nombre de la localidad con su precio correspondiente.
     */
    private String obtenerNombreLocalidad(int localidad) {
        switch (localidad) {
            case 1:
                return "Localidad 1 (Precio: $100)";
            case 5:
                return "Localidad 5 (Precio: $500)";
            case 10:
                return "Localidad 10 (Precio: $1000)";
            default:
                return "Localidad Desconocida";
        }
    }

    /**
     * Realiza la compra de boletos regulares y muestra el resultado.
     */
    private void comprarBoletos() {
        System.out.print("Ingrese la cantidad de boletos a comprar: ");
        int numBoletos = scanner.nextInt();
        comprador.setNumBoletos(numBoletos);

        int ticket = TicketGenerator.generarTicket();
        int presupuestoUsuario = comprador.getPresupuesto();

        if (TicketGenerator.validarTicket(ticket)) {
            // ... (resto de la implementación)
        } else {
            System.out.println("Lo sentimos, su ticket no es válido.");
        }
    }

    /**
     * Realiza la compra de boletos especiales con un código y muestra el resultado.
     */
    private void comprarBoletosEspecial() {
        System.out.println("Ingrese el codigo especial");
        int codigo = scanner.nextInt();
        lugar.venderBoletosEspeciales(1, codigo);
        System.out.println("Vendido");
    }
}
