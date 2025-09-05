import java.util.*;

public class Hanoi {

    public static Stack<Character> stack1 = new Stack<>();
    public static Stack<Character> stack2 = new Stack<>();
    public static Stack<Character> stack3 = new Stack<>();

    static Scanner sc = new Scanner(System.in);
    static int countMoves = 0;

    public static void main(String[] args) {
        initializeStack(4);
        System.out.println("\nPILAS INICIALES");
        showStacks();

        hanoi(stack1, stack2, stack3, 4);

        System.out.println("PILAS FINALES");
        showStacks();
    }

    public static void initializeStack(int elements) {
        /*
         * llenar la pila1 , en base a el codigo ascii del abecedario, iniciando en 97 =
         * a 0 en 65 = A
         */

        // variables

        // for(variable control; condicion; actualizar de la variable)
        for (int i = 0; i < elements; i++) {
            // push
            stack1.push((char) (i + 97));
            // mover el caracter
        }
    }

    public static void show(Stack currentStack) {
        // for para mostrar los elementos de la pila
        for (int i = currentStack.size() - 1; i >= 0; i--) {
            System.out.println(currentStack.get(i));
        }
    }

    public static void showStacks() {
        System.out.println("PILA 1");
        show(stack1);
        System.out.println("------\n\nPILA 2");
        show(stack2);
        System.out.println("------\n\nPILA 3");
        show(stack3);
    }

    public static void move(Stack origin, Stack destination) {
        try {
            destination.push(origin.pop());
        } catch (Exception e) {
            System.out.println("ERROR AL INTENTAR MOVER ENTRE PILAS");
        }
    }

    public static void hanoi(Stack a, Stack b, Stack c, int n) {
        if (n == 1) {
            move(a, b);
            countMoves++;

            System.out.println("MOVIMIENTO " + countMoves);
            showStacks();
            sc.nextLine();  
        } else {
            hanoi(a,c,b,n- 1);
            move(a,c);
            countMoves++;
            System.out.println("MOVIMIENTO" + countMoves);
            showStacks();
            sc.nextLine();
            hanoi(c,b,a,n- 1);
        }
    }
}
