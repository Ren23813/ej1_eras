import java.util.*;

class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int op;
        
        do {
            System.out.println("Eras Tour System Menu");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Código Especial");
            System.out.println("7. Salir");
            System.out.print("Ingrese su elección: ");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    agenda.Guardar_datos();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (op != 7);
        scanner.close();
    }

}

