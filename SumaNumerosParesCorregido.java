public class SumaNumerosParesCorregido {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int limite = 1000000;
        long suma = (long) (2 + limite) * limite/4;
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("La suma de los números pares hasta " + limite + " es: " + suma);
        System.out.println("Tiempo de ejecución: " + time );
    }
}


