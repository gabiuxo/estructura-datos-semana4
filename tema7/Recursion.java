public class Recursion {
    public static void main(String[] args) {
        System.out.println("\nFACTORIAL DE 5 : " + FACTORIAL(5));
        System.out.println("EL NUMERO FIBONACCI DE LA SERIE EN LA POSICION 6 ES:" + fibonacci(6));
    }

    // CREAR METODO RECURSIVO PARA EL CÁLCULO DEL FACTORIAL
    public static long FACTORIAL(long num) {
        long result = 1;
        // CASO DE SALIDA
        if (num <= 1) {
            result = 1;
        } else // CASO RECURSIVO
        {
            // SE MULTIPLICA EL NUMERO QUE ENTRA * EL FACTORIAL DEL NUMERO ANTERIOR
            // SI ENTRA UN 5 EL RESULTADO FACTORIAL ES IGUAL A 5 * FACTORIAL(4)
            // SI ENTRA UN 4 EL FACTORIAL ES IGUAL A 4 * FACTORIAL(3)
            result = num * FACTORIAL(num - 1);
            /*
             * factorial(5)
             * cae en el else
             * resultado = 5 * factorial(4)
             * resultado = 5 * 24 = 120
             * 
             * factorial(4)
             * cae en el else
             * resultado = 4 * factorial(3)
             * resultado = 4 * 6 = 24
             * 
             * factorial(3)
             * cae en el else
             * resultado = 3 * factorial(2)
             * resultado = 3 * 2 = 6
             * 
             * factorial(2)
             * cae en el else
             * resultado = 2 * factorial(1)
             * resultado = 2 * 1 = 2
             * 
             * factorial(1)
             * cae en el if
             * resultado = 1
             */
        }
        return result;
    }
    //crear un metodo recursivo para calcular la serie fibonacci hasta cierto elemento
    public static long fibonacci(long num) {
        long result = 1;
        //caso de salida
        if(num <= 2){
            result = 1;
        }
        //caso recursivo
        else{
            result = fibonacci(num - 1) + fibonacci(num - 2);
        }
        /*  
         * fibonacci(6)
         * cae en caso recursivo
         * resultado = fibonacci(5) + fibonacci(4)
         * resultado = 5 + 3 = 8
         * 
         * fibonacci(5)
         * cae en caso recursivo
         * resultado = fibonacci(4) + fibonacci(3)
         * resultado = 3 + 2 = 5
         * 
         * fibonacci (4)
         * cae en caso recursivo
         * resultado = fibonacci(3) + fibonacci(2)
         * resultado = 2 + 1 = 3
         * 
         * fibonacci(3)
         * cae en caso recursivo
         * resultado = fibonacci(2) + fibonacci(1)
         * resultado 1 + 1 = 2
         * 
         * fibonacci(2)
         * cae en caso de salida
         * resultado = 1
         * 
         * fibonacci(1)
         * cae en caso de salida
         * resultado = 1
         */
        return result;
    }
}
