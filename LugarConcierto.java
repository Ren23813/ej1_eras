/**
 * Esta clase representa un lugar de concierto con diferentes localidades y funciones relacionadas.
 */
public class LugarConcierto {
    private int boletosDisponiblesLocalidad1 = 20;
    private int boletosDisponiblesLocalidad5 = 20;
    private int boletosDisponiblesLocalidad10 = 20;
    private int dineroRecaudado = 0;

    /**
     * Verifica si la localidad proporcionada es válida.
     *
     * @param localidad La localidad que se va a verificar.
     * @return {@code true} si la localidad es válida, {@code false} de lo contrario.
     */
    public boolean esLocalidadValida(int localidad) {
        return localidad == 1 || localidad == 5 || localidad == 10;
    }

    /**
     * Obtiene el monto total recaudado por la venta de boletos.
     *
     * @return El monto total recaudado.
     */
    public int obtenerDineroRecaudado() {
        return dineroRecaudado;
    }

    /**
     * Verifica si hay espacio disponible en una localidad específica.
     *
     * @param localidad La localidad para la que se verificará el espacio.
     * @return {@code true} si hay espacio disponible, {@code false} de lo contrario.
     */
    public boolean tieneEspacio(int localidad) {
        switch (localidad) {
            case 1:
                return boletosDisponiblesLocalidad1 > 0;
            case 5:
                return boletosDisponiblesLocalidad5 > 0;
            case 10:
                return boletosDisponiblesLocalidad10 > 0;
            default:
                return false;
        }
    }

    /**
     * Verifica si hay suficientes boletos disponibles en una localidad específica.
     *
     * @param localidad La localidad para la que se verificarán los boletos.
     * @param numBoletos El número de boletos requeridos.
     * @return {@code true} si hay suficientes boletos disponibles, {@code false} de lo contrario.
     */
    public boolean tieneSuficientesBoletos(int localidad, int numBoletos) {
        switch (localidad) {
            case 1:
                return boletosDisponiblesLocalidad1 >= numBoletos;
            case 5:
                return boletosDisponiblesLocalidad5 >= numBoletos;
            case 10:
                return boletosDisponiblesLocalidad10 >= numBoletos;
            default:
                return false;
        }
    }

    /**
     * Verifica si una localidad es asequible según un presupuesto dado.
     *
     * @param localidad La localidad para la que se verificará la asequibilidad.
     * @param presupuesto El presupuesto disponible.
     * @return {@code true} si la localidad es asequible, {@code false} de lo contrario.
     */
    public boolean esAsequible(int localidad, int presupuesto) {
        switch (localidad) {
            case 1:
                return presupuesto >= 100;
            case 5:
                return presupuesto >= 500;
            case 10:
                return presupuesto >= 1000;
            default:
                return false;
        }
    }

    /**
     * Vende una cantidad específica de boletos en una localidad determinada.
     * Actualiza los boletos disponibles y el monto recaudado.
     *
     * @param localidad La localidad en la que se venderán los boletos.
     * @param numBoletos El número de boletos a vender.
     */
    public void venderBoletos(int localidad, int numBoletos) {
        switch (localidad) {
            case 1:
                boletosDisponiblesLocalidad1 -= numBoletos;
                break;
            case 5:
                boletosDisponiblesLocalidad5 -= numBoletos;
                break;
            case 10:
                boletosDisponiblesLocalidad10 -= numBoletos;
                break;
        }
        int precioTotal = obtenerPrecioLocalidad(localidad) * numBoletos;
        dineroRecaudado += precioTotal;
    }

    /**
     * Verifica si es posible comprar boletos con un código especial en una localidad determinada.
     *
     * @param localidad La localidad en la que se intentará comprar.
     * @param numBoletos El número de boletos que se intentarán comprar.
     * @param presupuesto El presupuesto disponible.
     * @param codigoEspecial El código especial a utilizar.
     * @return {@code true} si es posible comprar con el código especial, {@code false} de lo contrario.
     */
    public boolean puedeComprarConCodigoEspecial(int localidad, int numBoletos, int presupuesto, int codigoEspecial) {
        if (esCodigoEspecial(codigoEspecial) && localidad == 10) {
            return tieneEspacio(localidad) && tieneSuficientesBoletos(localidad, numBoletos) && esAsequible(localidad, presupuesto);
        }
        return false;
    }

    /**
     * Vende boletos especiales utilizando un código especial.
     *
     * @param numBoletos El número de boletos a vender.
     * @param codigoEspecial El código especial a utilizar.
     */
    public void venderBoletosEspeciales(int numBoletos, int codigoEspecial) {
        int localidad = 10;
        int precioTotal = obtenerPrecioLocalidad(localidad) * numBoletos;
        if (puedeComprarConCodigoEspecial(localidad, numBoletos, precioTotal, codigoEspecial)){
            venderBoletos(localidad, numBoletos);
            System.out.println("Compra especial exitosa con código " + codigoEspecial + " por un total de $" + precioTotal);
        }
    }

    /**
     * Obtiene la cantidad de boletos disponibles en una localidad específica.
     *
     * @param localidad La localidad para la que se desea obtener la cantidad de boletos disponibles.
     * @return La cantidad de boletos disponibles.
     */
    public int obtenerBoletosDisponibles(int localidad) {
        switch (localidad) {
            case 1:
                return boletosDisponiblesLocalidad1;
            case 5:
                return boletosDisponiblesLocalidad5;
            case 10:
                return boletosDisponiblesLocalidad10;
            default:
                return 0;
        }
    }

    /**
     * Obtiene el precio de una localidad específica.
     *
     * @param localidad La localidad para la que se desea obtener el precio.
     * @return El precio de la localidad.
     */
    public int obtenerPrecioLocalidad(int localidad) {
        switch (localidad) {
            case 1:
                return 100;
            case 5:
                return 500;
            case 10:
                return 1000;
            default:
                return 0;
        }
    }

    private boolean esCodigoEspecial(int codigo) {
        return esNumeroFibonacci(codigo);
    }

    private boolean esNumeroFibonacci(int numero) {
        if (numero == 0 || numero == 1) {
            return true;
        }

        int a = 0;
        int b = 1;
        int fib = a + b;

        while (fib <= numero) {
            if (fib == numero) {
                return true;
            }

            a = b;
            b = fib;
            fib = a + b;
        }
        return false;
    }
}
