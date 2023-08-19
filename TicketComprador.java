public class TicketComprador {
    private String nombre;
    private String email;
    private int numBoletos;
    private int presupuesto;

    public TicketComprador(String nombre, String email, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
    }
    public void setNumBoletos(int numBoletos){
        this.numBoletos = numBoletos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getNumBoletos() {
        return numBoletos;
    }

    public int getPresupuesto() {
        return presupuesto;
    }
}
