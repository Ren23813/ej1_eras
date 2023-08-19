public class LugarConcierto {
    private int boletosDisponiblesLocalidad1 = 20;
    private int boletosDisponiblesLocalidad5 = 20;
    private int boletosDisponiblesLocalidad10 = 20;
    private int dineroRecaudado = 0;

    public boolean esLocalidadValida(int localidad) {
        return localidad == 1 || localidad == 5 || localidad == 10;
    }
    public int obtenerDineroRecaudado() {
        return dineroRecaudado;
    }
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

    public boolean puedeComprarConCodigoEspecial(int localidad, int numBoletos, int presupuesto, int codigoEspecial) {
        if (esCodigoEspecial(codigoEspecial) && localidad == 10) {
            return tieneEspacio(localidad) && tieneSuficientesBoletos(localidad, numBoletos) && esAsequible(localidad, presupuesto);
        }
        return false;
    }

    public void venderBoletosEspeciales(int numBoletos, int codigoEspecial) {
        int localidad = 10;
        int precioTotal = obtenerPrecioLocalidad(localidad) * numBoletos;
        if (puedeComprarConCodigoEspecial(localidad, numBoletos, precioTotal, codigoEspecial)){
            venderBoletos(localidad, numBoletos);
            System.out.println("Compra especial exitosa con código " + codigoEspecial + " por un total de $" + precioTotal);
        }
    }

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
