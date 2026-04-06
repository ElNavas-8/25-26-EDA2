public class Reto {

    public static final char[] LETTERS = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
    
    static boolean[] used = new boolean[10];
    
    static int[] valores = new int[256];

    static boolean moreMoney(int indice){

        if (indice == LETTERS.length) {
            return comprobarSuma();
        }

        char caracterActual = LETTERS[indice];

        for (int digit = 0; digit <= 9; digit++) {
            if (digit == 0 && (caracterActual == 'S' || caracterActual == 'M')){ 
                continue; 
            }

            if (!used[digit]) {
                used[digit] = true;
                valores[caracterActual] = digit;
                
                if (moreMoney(indice + 1)) {
                    return true;
                }

                used[digit] = false;
            }
        }

        return false;
    }

    static boolean comprobarSuma() {
        int send = valores['S'] * 1000 + valores['E'] * 100 + valores['N'] * 10 + valores['D'];
        int more = valores['M'] * 1000 + valores['O'] * 100 + valores['R'] * 10 + valores['E'];
        int money = valores['M'] * 10000 + valores['O'] * 1000 + valores['N'] * 100 + valores['E'] * 10 + valores['Y'];

        if (send + more == money) {
            System.out.println("Encontrado:");
            System.out.println("  " + send);
            System.out.println("+ " + more);
            System.out.println("-------");
            System.out.println(" " + money);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        System.out.println("Iniciando la búsqueda...");

        if (!moreMoney(0)) {
            System.out.println("No se encontró solución.");
        }
    }

}