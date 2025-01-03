public class SumaNumerosPares {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int limite = 1000000;
        long suma = 0;

        for (int i = 1; i <= limite; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("La suma de los números pares hasta " + limite + " es: " + suma);
        System.out.println("Tiempo de ejecución: " + time );
    }
}





