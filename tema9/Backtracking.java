package tema9;

public class Backtracking {
    public static int N = 8;
    // Esta línea declara una matriz de enteros llamada 'board' de tamaño N x N (en
    // este caso 8x8),
    // que representa el tablero para el algoritmo de backtracking (por ejemplo,
    // para el problema de las 8 reinas).
    static int board[][] = new int[N][N];

    public static void main(String[] args) {
        System.out.println("\nTABLERO INICIAL: ");
        printBoard();
        // boolean valid = validPosition(3, 5);

        if (!solve(0))
            System.out.println("TABLERO SIN SOLUCION");

        System.out.println("\nTABLERO FINAL: ");
        printBoard();
    }

    public static void printBoard() {

        for (int r = 0; r < N; r++) { // recorrer filas
            for (int c = 0; c < N; c++) { // recorrer columnas
                // Imprime el valor y '\t' para separar con tabulaciones, haciendo que la salida
                // sea más ordenada en columnas.
                System.out.print(board[r][c] + "\t");
            }
            System.out.println(); // Salto de línea después de imprimir cada fila para que la siguiente fila
                                  // comience en una nueva línea.
        }
    }

    public static boolean validPosition(int row, int col) {

        // VALIDAR RENGLON
        // for para recorrer las columnas del renglon actual
        //System.out.println("\nVALIDACION DE RENGLON: ");
        for (int c = 0; c < col; c++) {
            //System.out.println(row + " , " + c + "\t");
            if (board[row][c] == 1)
                return false;
        }

        // VALIDAR DIAGONAL SUPERIOR
        //System.out.println("VALIDACION DIAGONAL SUPERIOR: ");
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            //System.out.println(r + " , " + c + "\t");
            if (board[r][c] == 1)
                return false;
        }

        // VALIDAR DIAGONAL INFERIOR
        //System.out.println("VALIDACION DIAGONAL INFERIOR: ");
        for (int r = row, c = col; r < N && c >= 0; r++, c--) {
            //System.out.println(r + " , " + c + "\t");
            if (board[r][c] == 1)
                return false;
        }
        return true;
    }

    public static boolean solve(int currentColumn) {
        if (currentColumn >= N) {
            return true; // Todas las reinas han sido colocadas
        }

        // caso recursivo
        for (int r = 0; r < N; r++) {
            if (validPosition(r, currentColumn)) {
                board[r][currentColumn] = 1; // Colocar la reina

                // recursividad: revisa si la siguiente la columna tiene solucion
                if (solve(currentColumn + 1)) {
                    return true; // Si se resuelve, retornar true
                }

                // quitar la reina (backtracking)
                board[r][currentColumn] = 0; // Backtrack: quitar la reina
            }
        }
        return false; // No se pudo colocar una reina en esta columna
    }
}
