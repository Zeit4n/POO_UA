import java.util.Scanner;
abstract class FiguraGeometrica {
    public FiguraGeometrica() {

    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

}

class Rectangulo extends FiguraGeometrica {
    private int largo;
    private int ancho;

    public Rectangulo(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public double calcularArea() {
        double area = largo * ancho;
        System.out.println("El área de este rectángulo es " + area + ".");
        return area; // Retorna el área
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = 2 * (largo + ancho);
        System.out.println("El perímetro de este rectángulo es " + perimetro + ".\n");
        return perimetro; // Retorna el perímetro                
    }

    public String toString() {
        return "DIMENSIONES DEL RECTÁNGULO:\nLARGO: " + largo + "\nANCHO: " + ancho + "\n";
    }
}

class Triangulo extends FiguraGeometrica {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        double area = Math.sqrt(s*(s - lado1)*(s - lado2)*(s - lado3));
        System.out.println("El área de este triángulo es " + area + ".");
        return area; // Retorna el área
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = lado1 + lado2 + lado3;
        System.out.println("El perímetro de este triángulo es " + perimetro + ".\n");
        return perimetro; // Retorna el perímetro
    }

    public String toString() {
        return "DIMENSIONES DEL TRIÁNGULO:\nLADO 1: " + lado1 + "\nLADO 2: " + lado2 + "\nLADO 3: " + lado3 + "\n";
    }
}

class Circulo extends FiguraGeometrica {
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        double area = 3.14 * Math.pow(radio, 2);
        System.out.println("El área de este círculo es " + area + ".");
        return area; // Retorna el área
    }

    @Override
    public double calcularPerimetro() {    
        double perimetro = 2 * 3.14 * radio;
        System.out.println("El perímetro de este círculo es " + perimetro + ".\n");
        return perimetro; // Retorna el perímetro
    }

    public String toString() {
        return "DIMENSIONES DEL CÍRCULO:\nRADIO: " + radio + ".\n";
    }
}
/*
public class figuras {
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(5, 10);
        Triangulo t1 = new Triangulo(6, 8, 10);
        Circulo c1 = new Circulo(6);
        System.out.print(r1);
        t1.calcularArea();
        c1.calcularPerimetro();
    }
} */

public class figuras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int largo,ancho,lado1,lado2,lado3,radio;
        System.out.println("BIENVENIDO A GEOFIGURAS EN JAVA\n");
        do {
            System.out.println("Seleccione una de las siguientes opciones:\n");
            System.out.print("1) Crear rectángulo.\n");                
            System.out.print("2) Crear triángulo.\n");                
            System.out.print("3) Crear círculo.\n");                                
            System.out.print("4) Salir.\n");
            System.out.print(">>> ");                            
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el largo del rectángulo: ");
                    largo = scanner.nextInt();
                    System.out.print("Ingrese el ancho del rectángulo: ");
                    ancho = scanner.nextInt();                    
                    Rectangulo r = new Rectangulo(largo,ancho);
                    r.calcularArea();
                    r.calcularPerimetro();
                    break;
                case 2:
                    System.out.print("Ingrese la medida del primer lado del triángulo: ");
                    lado1 = scanner.nextInt();
                    System.out.print("Ingrese la medida del segundo lado del triángulo: ");
                    lado2 = scanner.nextInt();
                    System.out.print("Ingrese la medida del tercer lado del triángulo: ");
                    lado3 = scanner.nextInt();
                    Triangulo t = new Triangulo(lado1,lado2,lado3);
                    t.calcularArea();
                    t.calcularPerimetro();
                    break;
                case 3:
                    System.out.print("Ingrese el radio del círculo: ");
                    radio = scanner.nextInt();                 
                    Circulo c = new Circulo(radio);
                    c.calcularArea();
                    c.calcularPerimetro();
                    break;
                case 4:
                    System.out.println("GRACIAS POR UTILIZAR NUESTRA APLICACIÓN ;)\n");
                    break;                    
            }
        } while (opcion != 4);
        scanner.close();
    }
}
