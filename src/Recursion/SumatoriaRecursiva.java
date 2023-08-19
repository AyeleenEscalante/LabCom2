package Recursion;
import java.util.Scanner;

public class SumatoriaRecursiva {
    public static int calcularSumatoria(int numero) {
        if (numero <= 0) {
            return 0;
        }
        return numero + calcularSumatoria(numero - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char seguir;

        do {
            System.out.print("Ingrese un número para calcular la sumatoria: ");
            int numero = scanner.nextInt();

            int sumatoria = calcularSumatoria(numero);
            System.out.println("La sumatoria de los números desde 1 hasta " + numero + " es: " + sumatoria);

            System.out.print("¿Desea calcular otra sumatoria? (s/n): ");
            seguir = scanner.next().charAt(0);
        } while (seguir == 's' || seguir == 'S');
    }
}


