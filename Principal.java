import java.util.Scanner;

public class Principal {
    public TicketComprador comprador = null;
    private Scanner scanner = new Scanner(System.in);
    public LugarConcierto lugar = new LugarConcierto();
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.menu(principal);
        
    }
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

    private void verificarDisponibilidadTotal() {
        System.out.println("\nDisponibilidad de boletos por localidad:");
        for (int i = 1; i <= 3; i++) {
            String nombreLocalidad = obtenerNombreLocalidad(i);
            int boletosDisponibles = lugar.obtenerBoletosDisponibles(i);
            System.out.println(nombreLocalidad + ": " + boletosDisponibles + " boletos disponibles");
        }
    }

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
    private void comprarBoletos() {
        System.out.print("Ingrese la cantidad de boletos a comprar: ");
        int numBoletos = scanner.nextInt();
        comprador.setNumBoletos(numBoletos);
    
        int ticket = TicketGenerator.generarTicket();
        int presupuestoUsuario = comprador.getPresupuesto();
    
        if (TicketGenerator.validarTicket(ticket)) {
            int localidadAleatoria = (int) (Math.random() * 3) + 1;
    
            if (lugar.esLocalidadValida(localidadAleatoria) && lugar.tieneEspacio(localidadAleatoria) && lugar.tieneSuficientesBoletos(localidadAleatoria, numBoletos) && lugar.esAsequible(localidadAleatoria, presupuestoUsuario)) {
    
                System.out.println("¡Localidad seleccionada: " + localidadAleatoria + "!");
                lugar.venderBoletos(localidadAleatoria, numBoletos);
    
                int precioTotal = lugar.obtenerPrecioLocalidad(localidadAleatoria) * numBoletos;
                System.out.println("Compra exitosa para " + comprador.getNombre() + " por un total de $" + precioTotal);
            } else {
                System.out.println("Lo sentimos, no se pudo completar la compra en esta localidad.");
            }
        } else {
            System.out.println("Lo sentimos, su ticket no es válido.");
        }
    }

    private void comprarBoletosEspecial() {
        System.out.println("Ingrese el codigo especial");
        int codigo = scanner.nextInt();
        lugar.venderBoletosEspeciales(1, codigo);
        System.out.println("Vendido");
    }
    
}
