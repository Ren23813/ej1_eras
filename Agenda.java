import java.util.*;

public class Agenda {

    public String name;
    public String email;
    public int budget;
    public int boletos;


    public void Guardar_datos(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del comprador: ");
        name = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico del comprador: ");
        email = scanner.nextLine();
        System.out.print("Ingrese el presupuesto máximo del comprador: ");
        budget = scanner.nextInt();
        System.out.print("Ingrese el la cantidad de boletos del comprador: ");
        boletos = scanner.nextInt();
        System.out.println("Comprador creado exitosamente.");
    }
}
    