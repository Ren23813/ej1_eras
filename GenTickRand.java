// Generador de tickets y validaciones de randoms. 
// La clase generará los números aleatorios y se validará si el comprador tiene un ticket válido (dependiendo del número random que le haya correspondido)

// Comentado con ChatGPT. Hecho a mano con resolución de dudas en StackOverflow. 
// Creado: 17/08/23

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Esta clase genera números aleatorios y verifica si un valor se encuentra entre otros dos valores aleatorios generados.
 */
public class GenTickRand {
    public int ticket1;
    public int valid1;
    public int valid2;
    
    /**
     * Genera números aleatorios para los campos de la clase.
     */
    private void Generate() {
        ticket1 = ThreadLocalRandom.current().nextInt(1, 15000 + 1);
        valid1 = ThreadLocalRandom.current().nextInt(1, 15000 + 1);
        valid2 = ThreadLocalRandom.current().nextInt(1, 15000 + 1);
    } 
    
    /**
     * Verifica si el valor de ticket1 está entre valid1 y valid2.
     * @return true si el valor de ticket1 está entre valid1 y valid2, false en caso contrario.
     */
    public boolean Verific_Randoms(){
        Generate();
        int [] lista = {valid1, valid2};
        Arrays.sort(lista);
        valid1 = lista[0];
        valid2 = lista[1];

        if (valid1 <= ticket1 && ticket1 <= valid2 ){
            return true;
        }
        else {
            return false;
        }
    }
}
