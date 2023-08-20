/**
 * La clase TicketComprador representa a un comprador de boletos con información relevante.
 */
public class TicketComprador {
    private String nombre;
    private String email;
    private int numBoletos;
    private int presupuesto;

    /**
     * Constructor para inicializar un objeto TicketComprador con información básica.
     *
     * @param nombre     El nombre del comprador.
     * @param email      El correo electrónico del comprador.
     * @param presupuesto El presupuesto disponible del comprador.
     */
    public TicketComprador(String nombre, String email, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.presupuesto = presupuesto;
    }

    /**
     * Establece la cantidad de boletos que el comprador desea adquirir.
     *
     * @param numBoletos La cantidad de boletos a establecer.
     */
    public void setNumBoletos(int numBoletos){
        this.numBoletos = numBoletos;
    }

    /**
     * Obtiene el nombre del comprador.
     *
     * @return El nombre del comprador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del comprador.
     *
     * @return El correo electrónico del comprador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la cantidad de boletos que el comprador desea adquirir.
     *
     * @return La cantidad de boletos que el comprador desea adquirir.
     */
    public int getNumBoletos() {
        return numBoletos;
    }

    /**
     * Obtiene el presupuesto disponible del comprador.
     *
     * @return El presupuesto disponible del comprador.
     */
    public int getPresupuesto() {
        return presupuesto;
    }
}
