public class Reto {
    static boolean[] used = new boolean[10];
    
    static int[] values = new int[256];

    public static final char[] LETTERS_1 = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
    
    public static final char[] LETTERS_2 = {'F', 'O', 'R', 'T', 'Y', 'E', 'N', 'S', 'I', 'X'};
    
    public static final char[] LETTERS_3 = {'O', 'D', 'E', 'V', 'N'};

    static boolean resolve(char[] letters, int indice, int option){

        if (indice == letters.length) {
            return verifySum(option);
        }

        char caracterActual = letters[indice];

        for (int digit = 0; digit <= 9; digit++) {
            if (digit == 0) {
                if (!( (option == 1 && (caracterActual == 'S' || caracterActual == 'M')) ||
                       (option == 2 && (caracterActual == 'F' || caracterActual == 'T' || caracterActual == 'S')) ||
                       (option == 3 && (caracterActual == 'O' || caracterActual == 'E')) )) {
                    
                    if (!used[digit]) {
                        used[digit] = true;
                        values[caracterActual] = digit;

                        if (resolve(letters, indice + 1, option)) {
                            return true;
                        }

                        used[digit] = false;
                    }
                }
            }
        }

        return false;
    }

    static boolean verifySum(int option) {
        if (option == 1) {
            int send = values['S'] * 1000 + values['E'] * 100 + values['N'] * 10 + values['D'];
            int more = values['M'] * 1000 + values['O'] * 100 + values['R'] * 10 + values['E'];
            int money = values['M'] * 10000 + values['O'] * 1000 + values['N'] * 100 + values['E'] * 10 + values['Y'];

            if (send + more == money) {
                System.out.println("Caso 1 Resuelto: " + send + " + " + more + " = " + money);
                return true;
            }
        } 
        else if (option == 2) {
            int forty = values['F'] * 10000 + values['O'] * 1000 + values['R'] * 100 + values['T'] * 10 + values['Y'];
            int ten = values['T'] * 100 + values['E'] * 10 + values['N'];
            int sixty = values['S'] * 10000 + values['I'] * 1000 + values['X'] * 100 + values['T'] * 10 + values['Y'];

            if (forty + ten + ten == sixty) {
                System.out.println("Caso 2 Resuelto: " + forty + " + " + ten + " + " + ten + " = " + sixty);
                return true;
            }
        } 
        else if (option == 3) {
            int odd = values['O'] * 100 + values['D'] * 10 + values['D'];
            int even = values['E'] * 1000 + values['V'] * 100 + values['E'] * 10 + values['N'];

            if (odd + odd == even) {
                System.out.println("Caso 3 Resuelto: " + odd + " + " + odd + " = " + even);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        System.out.println("Iniciando la búsqueda...\n");

        used = new boolean[10];
        if (!resolve(LETTERS_1, 0, 1)) System.out.println("No se encontró solución para el caso 1.");

        used = new boolean[10];
        if (!resolve(LETTERS_2, 0, 2)) System.out.println("No se encontró solución para el caso 2.");

        used = new boolean[10];
        if (!resolve(LETTERS_3, 0, 3)) System.out.println("No se encontró solución para el caso 3.");
    }

}
