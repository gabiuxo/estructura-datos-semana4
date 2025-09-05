public class act3 { 
    public static int SIZE = 9; // Declaración que define el tamaño del tablero 

    // Sudoku nivel facil
    static int sudokuFacil[][] = { // Declaración de una matriz para el sudoku fácil
            { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
            { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
            { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
            { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
            { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
            { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
            { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
            { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
    };

    // Sudoku nivel medio
    static int sudokuMedio[][] = { // Declaración de una matriz para el sudoku medio
            { 0, 2, 0, 6, 0, 8, 0, 0, 0 },
            { 5, 8, 0, 0, 0, 9, 7, 0, 0 },
            { 0, 0, 0, 0, 4, 0, 0, 0, 0 },
            { 3, 7, 0, 0, 0, 0, 5, 0, 0 },
            { 6, 0, 0, 0, 0, 0, 0, 0, 4 },
            { 0, 0, 8, 0, 0, 0, 0, 1, 3 },
            { 0, 0, 0, 0, 2, 0, 0, 0, 0 },
            { 0, 0, 9, 8, 0, 0, 0, 3, 6 },
            { 0, 0, 0, 3, 0, 6, 0, 9, 0 }
    };

    // Sudoku nivel dificil
        static int sudokuDificil[][] = { // Declaración de una matriz para el sudoku difícil
            { 0, 0, 0, 6, 0, 0, 4, 0, 0 },
            { 7, 0, 0, 0, 0, 3, 6, 0, 0 },
            { 0, 0, 0, 0, 9, 1, 0, 8, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 5, 0, 1, 8, 0, 0, 0, 3 },
            { 0, 0, 0, 3, 0, 6, 0, 4, 5 },
            { 0, 4, 0, 2, 0, 0, 0, 6, 0 },
            { 9, 0, 3, 0, 0, 0, 0, 0, 0 },
            { 0, 2, 0, 0, 0, 0, 1, 0, 0 }
    };

    // Variable que almacenará el tablero seleccionado aleatoriamente
    static int tablero[][]; // Declaración de la matriz que contendrá el sudoku seleccionado

    public static void main(String[] args) {
        // Selección aleatoria de sudoku
        seleccionarSudokuAleatorio(); // Llama al método para seleccionar un sudoku al azar

        System.out.println("SUDOKU INICIAL: ");
        imprimirTablero(); // Llama al método imprimirTablero para mostrar el estado inicial del sudoku

        if (resolverSudoku()) // Condicional que verifica si el método resolverSudoku retorna true (si se resolvio)
            System.out.println("\nSUDOKU RESUELTO: ");
        else // Caso contrario si resolverSudoku retorna false (no se resolvio)
            System.out.println("\nSUDOKU SIN SOLUCION");

        imprimirTablero(); // Llama nuevamente al método imprimirTablero para mostrar el resultado final
    }

    // Método para seleccionar aleatoriamente uno de los tres sudokus
    public static void seleccionarSudokuAleatorio() {
        int seleccion = (int) (Math.random() * 3); // Genera un número aleatorio entre 0 y 2 para seleccionar el sudoku

        switch (seleccion) { // Estructura switch que evalúa el número aleatorio generado
            case 0:
                tablero = copiarMatriz(sudokuFacil); // Copia el sudoku fácil a la variable tablero
                System.out.println("\n*** NIVEL: FACIL ***");
                break;
            case 1:
                tablero = copiarMatriz(sudokuMedio); // Copia el sudoku medio a la variable tablero
                System.out.println("\n*** NIVEL: MEDIO ***");
                break;
            case 2:
                tablero = copiarMatriz(sudokuDificil); // Copia el sudoku difícil a la variable tablero
                System.out.println("\n*** NIVEL: DIFICIL ***");
                break;
        }
    }

    // Método para copiar una matriz
    public static int[][] copiarMatriz(int[][] original) { // Método que crea una copia de una matriz bidimensional(dos dimensiones, filas y columnas)
        int[][] copia = new int[SIZE][SIZE]; // Crea una nueva matriz de tamaño SIZE x SIZE
        for (int i = 0; i < SIZE; i++) { // Bucle for que recorre cada fila de la matriz
            for (int j = 0; j < SIZE; j++) { // Bucle for que recorre cada columna de la matriz
                copia[i][j] = original[i][j]; // Copia el valor de la matriz original a la nueva matriz
            }
        }
        return copia; // Retorna la matriz copiada
    }

    public static void imprimirTablero() { 
        for (int fila = 0; fila < SIZE; fila++) { // Bucle for que recorre cada fila desde 0 hasta SIZE-1
            if (fila % 3 == 0 && fila != 0) { // Condicional que verifica si la fila es múltiplo de 3 y no es la primera fila
                System.out.println("------+-------+------");
            }
            for (int columna = 0; columna < SIZE; columna++) { // Bucle for que recorre cada columna desde 0 hasta SIZE-1
                if (columna % 3 == 0 && columna != 0) { // Condicional que verifica si la columna es múltiplo de 3 y no es la primera columna
                    System.out.print("| ");
                }
                // Imprime el valor o un espacio si es 0
                if (tablero[fila][columna] == 0) { // Condicional que verifica si el valor en la posición actual es 0 (o esta vacío)
                    System.out.print(". ");
                } else { // Caso contrario cuando la celda tiene un número
                    System.out.print(tablero[fila][columna] + " ");
                }
            }
            System.out.println();
        }
    }

    // Verificar si es seguro colocar un número en una posición
    public static boolean esSeguro(int fila, int columna, int numero) {
        // Verificar fila
        for (int x = 0; x < SIZE; x++) { // Bucle for que recorre todas las columnas de la fila especificada
            if (tablero[fila][x] == numero) { // Condicional que verifica si el número ya existe en alguna columna de esa fila
                return false; // Retorna false si el número ya está presente en la fila
            }
        }

        // Verificar columna
        for (int x = 0; x < SIZE; x++) { // Bucle for que recorre todas las filas de la columna especificada
            if (tablero[x][columna] == numero) { // Condicional que verifica si el número ya existe en alguna fila de esa columna
                return false; // Retorna false si el número ya está presente en la columna
            }
        }

        // Verificar cuadro 3x3
        int inicioFila = fila - fila % 3; // Calcula la fila de inicio del cuadro 3x3 que contiene la posición actual
        int inicioColumna = columna - columna % 3; // Calcula la columna de inicio del cuadro 3x3 que contiene la posición actual

        for (int i = inicioFila; i < inicioFila + 3; i++) { // Bucle for que recorre las 3 filas del cuadro 3x3
            for (int j = inicioColumna; j < inicioColumna + 3; j++) { // Bucle for que recorre las 3 columnas del cuadro 3x3
                if (tablero[i][j] == numero) { // Condicional que verifica si el número ya existe en el cuadro 3x3
                    return false; // Retorna false si el número ya está presente en el cuadro 3x3
                } 
            } 
        } 

        return true; // Retorna true si el número es seguro de colocar en la posición especificada
    }

    // Resolver el Sudoku usando backtracking
    public static boolean resolverSudoku() { // Método recursivo que resuelve el sudoku usando la técnica backtracking
        for (int fila = 0; fila < SIZE; fila++) { // Bucle for que recorre cada fila del tablero desde 0 hasta SIZE-1
            for (int columna = 0; columna < SIZE; columna++) { // Bucle for que recorre cada columna del tablero desde 0 hasta SIZE-1
                if (tablero[fila][columna] == 0) { // Condicional que verifica si la celda actual está vacía (valor 0)
                    for (int numero = 1; numero <= 9; numero++) { // Bucle for que prueba números del 1 al 9 en la vacía
                        if (esSeguro(fila, columna, numero)) { // Condicional que verifica si es seguro colocar el número en esta posición
                            tablero[fila][columna] = numero; // Asigna el número a la celda actual del tablero

                            if (resolverSudoku()) { // Llamada recursiva para resolver el resto del sudoku
                                return true; // Retorna true si la solución es exitosa
                            } // Fin del condicional de llamada recursiva

                            // Backtrack
                            tablero[fila][columna] = 0; // Restaura la celda a 0 (backtracking) si la solución no
                                                        // funciona
                        }
                    }
                    return false; // Retorna false si ningún número del 1 al 9 funciona en esta posición
                }
            }
        }
        return true; // Retorna true cuando todas las celdas están llenas y el sudoku está resuelto
    }
}
