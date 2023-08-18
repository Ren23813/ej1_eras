public class VIP {
    public int user_code;

    public static boolean Valid_code(Integer user_code){
        //declarar los arreglos
        int[] secuencia = new int[40];
        secuencia[0] = 0;
        secuencia[1] = 1;

        for (int i = 2; i < 40; i++){
            secuencia[i] = secuencia[i-1] + secuencia[i-2];  
        }

        for (int j = 0; j < 40; j++){
            if (user_code == secuencia[j]) {
                return true;
            }
        }

        return false;
    }
}
